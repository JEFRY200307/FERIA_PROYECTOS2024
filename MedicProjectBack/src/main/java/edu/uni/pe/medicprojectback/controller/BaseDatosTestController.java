package edu.uni.pe.medicprojectback.controller;

import edu.uni.pe.medicprojectback.model.BaseDatosTest;
import edu.uni.pe.medicprojectback.service.Interface.BancoDatosTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baseDatosTest")
public class BaseDatosTestController {

    @Autowired
    private BancoDatosTestService bancoDatosTestService;

    @PostMapping("/crear/test")
    public ResponseEntity<BaseDatosTest> crearBaseDatosTest(@RequestBody BaseDatosTest baseDatosTest) {
        BaseDatosTest nuevoTest = bancoDatosTestService.crearBaseDatosTest(baseDatosTest);
        return ResponseEntity.ok(nuevoTest);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<BaseDatosTest> actualizarBaseDatosTest(@PathVariable int id, @RequestBody BaseDatosTest baseDatosTest) {
        BaseDatosTest testActualizado = bancoDatosTestService.actualizarBaseDatosTest(id, baseDatosTest);
        return ResponseEntity.ok(testActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarBaseDatosTest(@PathVariable int id) {
        bancoDatosTestService.eliminarBaseDatosTest(id);
        return ResponseEntity.noContent().build();
    }
}
