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

    public List<Planta> buscarPorTipo(String tipo) {
        return this.repository.findByTipo(tipo);
    }

    public List<Planta> buscarPorGenero(String genero) {
        return this.repository.findByGenero(genero);
    }

    public Planta buscarPorEspecie(String especie) throws ChangeSetPersister.NotFoundException {
        Optional<Planta> planta = this.repository.findByEspecie(especie);
        if (planta.isPresent()) {
            return planta.get();
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public List<String> buscarTipos() {
        return this.repository.findAll().stream()
                .map(Planta::getTipo)
                .distinct()
                .sorted()
                .toList();
    }

    public List<String> buscarGeneros() {
        return this.repository.findAll().stream()
                .map(Planta::getGenero)
                .distinct()
                .sorted()
                .toList();
    }

    public List<Planta> buscarTudo() {
        return this.repository.findAll();
    }

    public List<Planta> buscarGeneroEspecie(String termo) {
        return this.repository.buscarGeneroEspecie(termo);
    }

    public Planta atualizarDados(Planta planta) throws ClassNotFoundException {
        Optional<Planta> paraAtualizar = this.repository.findById(planta.getId());
        if(paraAtualizar.isPresent()) {
            paraAtualizar.get().setGenero(planta.getGenero());
            paraAtualizar.get().setEspecie(planta.getEspecie());
            paraAtualizar.get().setEspecificacao(planta.getEspecificacao());
            paraAtualizar.get().setNomePopular(planta.getNomePopular());
            paraAtualizar.get().setImagem(planta.getImagem());
            paraAtualizar.get().setTipo(planta.getTipo());
            paraAtualizar.get().setDetalhe(planta.getDetalhe());
            return this.repository.save(paraAtualizar.get());
        } else {
            throw new ClassNotFoundException("Algo deu errado :(");
        }
    }

    public void deletarPorId(Long id) {
        this.repository.deleteById(id);
    }


}
