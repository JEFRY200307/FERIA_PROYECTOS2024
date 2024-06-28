package edu.uni.pe.medicprojectback.service.Impl;

import edu.uni.pe.medicprojectback.model.Cita;
import edu.uni.pe.medicprojectback.service.Interface.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Cita createCita(Cita cita) {
        String sql = "INSERT INTO Cita (fecha, hora_inicio, hora_fin, estado, departamento, nombre_especialista, apellido_especialista, usuario_id, id_org) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cita.getFecha(), cita.getHoraInicio(), cita.getHoraFin(), cita.getEstado(),
                cita.getDepartamento(), cita.getNombreEspecialista(), cita.getApellidoEspecialista(),
                cita.getIdCodUni(), cita.getIdOrg());
        return cita;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> getAllCitas() {
        String sql = "SELECT * FROM Cita";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cita cita = new Cita();
            cita.setIdCita(rs.getInt("id_cita"));
            cita.setFecha(rs.getDate("fecha"));
            cita.setHoraInicio(rs.getTime("hora_inicio"));
            cita.setHoraFin(rs.getTime("hora_fin"));
            cita.setEstado(rs.getString("estado"));
            cita.setDepartamento(rs.getString("departamento"));
            cita.setNombreEspecialista(rs.getString("nombre_especialista"));
            cita.setApellidoEspecialista(rs.getString("apellido_especialista"));
            cita.setIdCodUni(rs.getString("id_cod_uni"));
            cita.setIdOrg(rs.getInt("id_org"));
            return cita;
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCitasPorUsuario(String idCodUni) {
        String sql = "SELECT * FROM Cita WHERE id_cod_uni = ?";
        return jdbcTemplate.query(sql, new Object[] { idCodUni }, (rs, rowNum) -> {
            Cita cita = new Cita();
            cita.setIdCita(rs.getInt("id_cita"));
            cita.setFecha(rs.getDate("fecha"));
            cita.setHoraInicio(rs.getTime("hora_inicio"));
            cita.setHoraFin(rs.getTime("hora_fin"));
            cita.setEstado(rs.getString("estado"));
            cita.setDepartamento(rs.getString("departamento"));
            cita.setNombreEspecialista(rs.getString("nombre_especialista"));
            cita.setApellidoEspecialista(rs.getString("apellido_especialista"));
            cita.setIdCodUni(rs.getString("id_cod_uni"));
            cita.setIdOrg(rs.getInt("id_org"));
            return cita;
        });
    }
    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCitasPorMedico(String nombreEspecialista, String apellidoEspecialista) {
        String sql = "SELECT * FROM Cita WHERE nombre_especialista = ? AND apellido_especialista = ?";
        return jdbcTemplate.query(sql, new Object[]{nombreEspecialista, apellidoEspecialista}, (rs, rowNum) -> {
            Cita cita = new Cita();
            cita.setIdCita(rs.getInt("id_cita"));
            cita.setFecha(rs.getDate("fecha"));
            cita.setHoraInicio(rs.getTime("hora_inicio"));
            cita.setHoraFin(rs.getTime("hora_fin"));
            cita.setEstado(rs.getString("estado"));
            cita.setDepartamento(rs.getString("departamento"));
            cita.setNombreEspecialista(rs.getString("nombre_especialista"));
            cita.setApellidoEspecialista(rs.getString("apellido_especialista"));
            cita.setIdCodUni(rs.getString("id_cod_uni"));
            cita.setIdOrg(rs.getInt("id_org"));
            return cita;
        });
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void actualizarEstadoCita(int idCita, String estado) {
        String sql = "UPDATE Cita SET estado = ? WHERE id_cita = ?";
        jdbcTemplate.update(sql, estado, idCita);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void actualizarEstadoCitaReservada(int idCita, Time horaInicio) {
        String estadoActual = obtenerEstadoCita(idCita);
        if ("RES".equals(estadoActual) && haPasadoQuinceMinutos(horaInicio)) {
            actualizarEstadoCita(idCita, "FAL");
        }
    }

    public void actualizarEstadoCitaManual(int idCita, String nuevoEstado) {
        String estadoActual = obtenerEstadoCita(idCita);
        if ("RES".equals(estadoActual) && "ASI".equals(nuevoEstado)) {
            actualizarEstadoCita(idCita, nuevoEstado);
        }
    }

    public void cancelarCita(int idCita) {
        String estadoActual = obtenerEstadoCita(idCita);
        if ("RES".equals(estadoActual)) {
            actualizarEstadoCita(idCita, "ACT");
        }
    }

    private String obtenerEstadoCita(int idCita) {
        String sql = "SELECT estado FROM Cita WHERE id_cita = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idCita}, String.class);
    }

    private boolean haPasadoQuinceMinutos(Time horaInicio) {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime inicio = horaInicio.toLocalTime().atDate(LocalDateTime.now().toLocalDate());
        return Duration.between(inicio, ahora).toMinutes() >= 15;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void deleteCita(int id) {
        String sql = "DELETE FROM Cita WHERE id_cita = ?";
        jdbcTemplate.update(sql, id);
    }

}
