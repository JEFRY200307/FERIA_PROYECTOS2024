package edu.uni.pe.medicprojectback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HistorialWeb {
    private int idWeb;               // Id_web
    private String versionWeb;       // Version_web
    private Date fechaCreacion;    // Fecha_creacion
    private String descripcion;
    private int idCodUni;// Descripcion
}
