package br.com.plantinha.controller;

import br.com.plantinha.Planta;
import br.com.plantinha.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantas")
@CrossOrigin
public class PlantaController {

    @Autowired
    private PlantaService service;

    @GetMapping("/{id}")
    ResponseEntity<Planta> buscarPorId(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/tipo/{tipo}")
    ResponseEntity<Planta> buscarPorTipo(@PathVariable String tipo) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.buscarPorTipo(tipo));
    }

    @GetMapping("/genero/{genero}")
    ResponseEntity<Planta> buscarPorGenero(@PathVariable String genero) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.buscarPorGenero(genero));
    }

    @GetMapping("/especie/{especie}")
    ResponseEntity<Planta> buscarPorEspecie(@PathVariable String especie) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.buscarPorEspecie(especie));
    }

    @PostMapping
    ResponseEntity<Planta> salvar(@RequestBody Planta planta) {
        return new ResponseEntity<>(this.service.salvar(planta), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Planta>> buscarTudo() {
        return ResponseEntity.ok(this.service.buscarTudo());
    }

    @GetMapping("/buscar/{termo}")
    ResponseEntity<List<Planta>> buscarGeneroEspecie(@PathVariable String termo) {
        return ResponseEntity.ok(this.service.buscarGeneroEspecie(termo));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Planta> deletarPorId(@PathVariable Long id) {
        this.service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
