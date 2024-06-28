package edu.uni.pe.medicprojectback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Organizacion {
    private int idOrg;            // Id_org
    private String nombre;           // nombre
    private String encargadoOrg;     // Encargardo_org
    private boolean habilitado;     // habilitado
    private int idWeb;

}
