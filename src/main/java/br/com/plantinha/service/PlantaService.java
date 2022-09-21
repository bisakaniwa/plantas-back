package br.com.plantinha.service;

import br.com.plantinha.Planta;
import br.com.plantinha.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.requireNonNullElse;

@Service
public class PlantaService {
    
    @Autowired
    private PlantaRepository repository;

    public Planta salvar(Planta planta) {
        Planta paraSalvar = new Planta();
        paraSalvar.setTipo(planta.getTipo());
        paraSalvar.setGenero(planta.getGenero());
        paraSalvar.setEspecie(planta.getEspecie());
        paraSalvar.setEspecificacao(planta.getEspecificacao());
        paraSalvar.setNomePopular(planta.getNomePopular());
        paraSalvar.setImagem(planta.getImagem());
        paraSalvar.setDetalhe(planta.getDetalhe());
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

    public List<Planta> buscarGeneroEspecie(String termo) {
        return this.repository.buscarGeneroEspecie(termo);
    }

    public void deletarPorId(Long id) {
        this.repository.deleteById(id);
    }


}
