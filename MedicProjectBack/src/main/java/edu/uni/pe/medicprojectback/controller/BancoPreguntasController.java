package edu.uni.pe.medicprojectback.controller;

import edu.uni.pe.medicprojectback.model.BancoPreguntas;
import edu.uni.pe.medicprojectback.service.Interface.BancoPreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bancoPreguntas")
public class BancoPreguntasController {

    @Autowired
    private BancoPreguntasService bancoPreguntasService;

    @PostMapping("/crear/pregunta")
    public ResponseEntity<BancoPreguntas> crearBancoPreguntas(@RequestBody BancoPreguntas bancoPreguntas) {
        BancoPreguntas nuevaPregunta = bancoPreguntasService.crearBancoPreguntas(bancoPreguntas);
        return ResponseEntity.ok(nuevaPregunta);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<BancoPreguntas> actualizarBancoPreguntas(@PathVariable int id, @RequestBody BancoPreguntas bancoPreguntas) {
        BancoPreguntas preguntaActualizada = bancoPreguntasService.actualizarBancoPreguntas(id, bancoPreguntas);
        return ResponseEntity.ok(preguntaActualizada);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarBancoPreguntas(@PathVariable int id) {
        bancoPreguntasService.eliminarBancoPreguntas(id);
        return ResponseEntity.noContent().build();
    }
}

