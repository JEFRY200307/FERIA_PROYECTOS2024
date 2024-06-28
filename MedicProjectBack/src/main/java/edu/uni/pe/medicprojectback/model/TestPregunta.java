package edu.uni.pe.medicprojectback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestPregunta {
    private int idTest;
    private int idPreg;
    private int peso;
    private Date fecha_creacion;
}
