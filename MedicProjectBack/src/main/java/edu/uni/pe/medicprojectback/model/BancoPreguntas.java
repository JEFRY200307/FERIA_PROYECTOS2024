package edu.uni.pe.medicprojectback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BancoPreguntas {
    private int idPreg;              // Id_preg
    private String tipoPreg;         // Tipo_preg
    private Date fechaCreacion;    // Fecha_creacion
    private String descripcion;      // Descripcion
}
