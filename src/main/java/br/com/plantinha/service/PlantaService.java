package br.com.plantinha.service;

import br.com.plantinha.Planta;
import br.com.plantinha.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantaService {
    
    @Autowired
    private PlantaRepository repository;

    public Planta salvar(Planta planta) {
        Planta paraSalvar = new Planta();
        paraSalvar.setEspecie(planta.getEspecie());
        paraSalvar.setGenero(planta.getGenero());
        paraSalvar.setTipo(planta.getTipo());
        paraSalvar.setImagem(planta.getImagem());
        this.repository.save(paraSalvar);
        return paraSalvar;
    }

    public Planta buscarPorId(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Planta> planta = this.repository.findById(id);
        if (planta.isPresent()) {
            return planta.get();
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public Planta buscarPorTipo(String tipo) throws ChangeSetPersister.NotFoundException {
        Optional<Planta> planta = this.repository.findByTipo(tipo);
        if (planta.isPresent()) {
            return planta.get();
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public Planta buscarPorGenero(String genero) throws ChangeSetPersister.NotFoundException {
        Optional<Planta> planta = this.repository.findByGenero(genero);
        if (planta.isPresent()) {
            return planta.get();
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public Planta buscarPorEspecie(String especie) throws ChangeSetPersister.NotFoundException {
        Optional<Planta> planta = this.repository.findByEspecie(especie);
        if (planta.isPresent()) {
            return planta.get();
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public List<Planta> buscarTudo() {
        return this.repository.findAll();
    }

    public List<Planta> buscarGeneroEspecie(String genero, String especie) {
        return this.repository.findByGeneroOrEspecie(genero, especie);
    }

    public void deletarPorId(Long id) {
        this.repository.deleteById(id);
    }

    public void deletarPorGenero(String genero) {
        this.repository.deletarPorGenero(genero);
    }

    public void deletarPorEspecie(String especie) {
        this.repository.deletarPorEspecie(especie);
    }
}
