package edu.uni.pe.medicprojectback.service.Impl;

import edu.uni.pe.medicprojectback.model.BancoPreguntas;
import edu.uni.pe.medicprojectback.service.Interface.BancoPreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BancoPreguntasImpl implements BancoPreguntasService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public BancoPreguntas crearBancoPreguntas(BancoPreguntas bancoPreguntas) {
        String sql = "INSERT INTO banco_preguntas (tipo_preg, fecha_creacion, descripcion) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, bancoPreguntas.getTipoPreg(),bancoPreguntas.getFechaCreacion(), bancoPreguntas.getDescripcion());
        // Asignar el id generado automáticamente
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        bancoPreguntas.setIdPreg(id);
        return bancoPreguntas;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public BancoPreguntas actualizarBancoPreguntas(int id, BancoPreguntas bancoPreguntas) {
        String sql = "UPDATE banco_preguntas SET tipo_preg = ?, fecha_creacion = ?, descripcion = ? WHERE id_preg = ?";
        jdbcTemplate.update(sql, bancoPreguntas.getTipoPreg(), bancoPreguntas.getFechaCreacion(), bancoPreguntas.getDescripcion(), id);
        bancoPreguntas.setIdPreg(id);
        return bancoPreguntas;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void eliminarBancoPreguntas(int id) {
        String sql = "DELETE FROM banco_preguntas WHERE id_preg = ?";
        jdbcTemplate.update(sql, id);
    }
}
