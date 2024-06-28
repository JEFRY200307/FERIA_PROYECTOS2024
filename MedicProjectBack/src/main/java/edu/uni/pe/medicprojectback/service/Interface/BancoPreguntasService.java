package edu.uni.pe.medicprojectback.service.Interface;

import edu.uni.pe.medicprojectback.model.BancoPreguntas;

public interface BancoPreguntasService {
    BancoPreguntas crearBancoPreguntas(BancoPreguntas bancoPreguntas);
    BancoPreguntas actualizarBancoPreguntas(int id, BancoPreguntas bancoPreguntas);
    void eliminarBancoPreguntas(int id);
}
