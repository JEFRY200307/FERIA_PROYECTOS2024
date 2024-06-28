package edu.uni.pe.medicprojectback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cita {
    private int idCita;             // Id_cita
    private Date fecha;              // Fecha
    private Time horaInicio;         // Hora_inicio
    private Time horaFin;            // Hora_fin
    private String estado;             // Estado
    private String departamento;       // Departamento
    private String nombreEspecialista; // Nombre_Especialista
    private String apellidoEspecialista; // Apellido_Especialista
    private String idCodUni;
    private int idOrg;
}
