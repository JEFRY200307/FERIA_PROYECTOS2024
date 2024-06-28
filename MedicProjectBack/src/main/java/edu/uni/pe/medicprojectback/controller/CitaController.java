package edu.uni.pe.medicprojectback.controller;

import edu.uni.pe.medicprojectback.model.Cita;
import edu.uni.pe.medicprojectback.service.Interface.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/listcitas")
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable int id) {
        List<Cita> citas = citaService.getAllCitas();
        for (Cita cita : citas) {
            if (cita.getIdCita() == id) {
                return ResponseEntity.ok(cita);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get/usuario/{idCodUni}")
    public List<Cita> getCitasPorUsuario(@PathVariable String idCodUni) {
        return citaService.getCitasPorUsuario(idCodUni);
    }

    @GetMapping("/get/medico")
    public List<Cita> getCitasPorMedico(@RequestParam String nombreEspecialista, @RequestParam String apellidoEspecialista) {
        return citaService.getCitasPorMedico(nombreEspecialista, apellidoEspecialista);
    }

    @PostMapping("/crearcita")
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.createCita(cita);
    }

    @PutMapping("/actualizar/{id}/reservada")
    public ResponseEntity<Void> actualizarEstadoCitaReservada(@PathVariable int id, @RequestParam Time horaInicio) {
        citaService.actualizarEstadoCitaReservada(id, horaInicio);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}/estado")
    public ResponseEntity<Void> actualizarEstadoCita(@PathVariable int id, @RequestParam String estado) {
        citaService.actualizarEstadoCita(id, estado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable int id) {
        citaService.deleteCita(id);
        return ResponseEntity.noContent().build();
    }
}
