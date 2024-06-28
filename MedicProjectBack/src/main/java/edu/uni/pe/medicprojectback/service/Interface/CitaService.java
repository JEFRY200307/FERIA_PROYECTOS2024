package edu.uni.pe.medicprojectback.service.Interface;

import edu.uni.pe.medicprojectback.model.Cita;

import java.sql.Time;
import java.util.List;

public interface CitaService {
    Cita createCita(Cita appointment);
    void deleteCita(int id);
    void actualizarEstadoCitaReservada(int idCita, Time horaInicio);
    List<Cita> getAllCitas();
    List<Cita> getCitasPorUsuario(String idCodUni);
    List<Cita> getCitasPorMedico(String nombreEspecialista, String apellidoEspecialista);
    void actualizarEstadoCita(int idCita, String estado);
}
