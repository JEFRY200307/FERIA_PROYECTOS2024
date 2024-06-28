package edu.uni.pe.medicprojectback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseDatosTest {
    private int idTest;              // Id_test
    private String versionTest;      // Version_test
    private LocalDate fechaTest;        // Fecha_test
    private String nombre;           // nombre
    private String descripcion;
    private int idWeb;// descripcion
}
