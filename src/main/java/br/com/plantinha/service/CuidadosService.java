package br.com.plantinha.service;

import br.com.plantinha.Cuidados;
import br.com.plantinha.repository.CuidadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuidadosService {

    @Autowired
    private CuidadosRepository repository;

    public Cuidados buscarPorId(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Cuidados> cuidados = this.repository.findById(id);
        if (cuidados.isPresent()) {
            return cuidados.get();
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public Cuidados buscarPorPlantaId(Long id) {
        Cuidados cuidado = new Cuidados();
        try {
            cuidado = this.repository.findByPlantaId(id);
        } catch (Exception e) {}
        return cuidado;
    }

    public Cuidados salvarCuidados(Cuidados planta) {
        Cuidados salvarCuidados = new Cuidados();
        salvarCuidados.setPlantaId(planta.getPlantaId());
        salvarCuidados.setSubstrato(planta.getSubstrato());
        salvarCuidados.setRega(planta.getRega());
        salvarCuidados.setIluminacao(planta.getIluminacao());
        salvarCuidados.setTemperatura(planta.getTemperatura());
        salvarCuidados.setUmidade(planta.getUmidade());
        salvarCuidados.setVentos(planta.getVentos());
        this.repository.save(salvarCuidados);
        return salvarCuidados;
    }

    public Cuidados atualizarCuidados(Cuidados planta) {
        Optional<Cuidados> atualizarCuidados = Optional.ofNullable(this.repository.findByPlantaId(planta.getPlantaId()));
        if(atualizarCuidados.isPresent()) {
            atualizarCuidados.get().setSubstrato(planta.getSubstrato());
            atualizarCuidados.get().setRega(planta.getRega());
            atualizarCuidados.get().setIluminacao(planta.getIluminacao());
            atualizarCuidados.get().setTemperatura(planta.getTemperatura());
            atualizarCuidados.get().setUmidade(planta.getUmidade());
            atualizarCuidados.get().setVentos(planta.getVentos());
            this.repository.save(atualizarCuidados.get());
        }
        return planta;
    }

    public void deletarPorId(Long id) {
        this.repository.deleteById(id);
    }
}
