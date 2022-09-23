package br.com.plantinha.controller;

import br.com.plantinha.Cuidados;
import br.com.plantinha.Planta;
import br.com.plantinha.service.CuidadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuidados")
@CrossOrigin
public class CuidadosController {

    @Autowired
    private CuidadosService service;

    @PostMapping
    ResponseEntity<Cuidados> salvarCuidados(@RequestBody Cuidados planta) {
        return new ResponseEntity<>(this.service.salvarCuidados(planta), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Cuidados> buscarPorId(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/planta/{id}")
    ResponseEntity<Cuidados> buscarPorPlantaId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorPlantaId(id));
    }

    @PutMapping("/atualizar/cuidados")
    ResponseEntity<Cuidados> atualizarCuidados(@RequestBody Cuidados planta) {
        return ResponseEntity.ok(this.service.atualizarCuidados(planta));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Cuidados> deletarPorId(@PathVariable Long id) {
        this.service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
