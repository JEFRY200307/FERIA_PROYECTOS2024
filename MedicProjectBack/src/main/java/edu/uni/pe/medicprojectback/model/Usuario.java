package edu.uni.pe.medicprojectback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    private String idCodUni;       // Id_cod_uni
    private String contraseña;     // Contraseña
    private int nroContacto;       // Nro_contacto
    private String correo;            // correo
    private String rol;            // Rol
    private String estado;         // Estado
    private boolean reserva;
}
