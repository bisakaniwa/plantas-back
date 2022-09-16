package br.com.plantinha.repository;

import br.com.plantinha.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {

    Optional<Planta> findByTipo(String tipo);

    Optional<Planta> findByGenero(String genero);

    Optional<Planta> findByEspecie(String especie);

    List<Planta> findByGeneroOrEspecie(String genero, String especie);

    void deletarPorGenero(String genero);

    void deletarPorEspecie(String especie);
}
