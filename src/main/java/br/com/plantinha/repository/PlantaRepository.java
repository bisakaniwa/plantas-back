package br.com.plantinha.repository;

import br.com.plantinha.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {

    List<Planta> findByTipo(String tipo);

    List<Planta> findByGenero(String genero);

    Optional<Planta> findByEspecie(String especie);

    @Query("select p from Planta p where p.especie like %:termo% or p.genero like %:termo%")
    List<Planta> buscarGeneroEspecie(@Param("termo") String termo);

}
