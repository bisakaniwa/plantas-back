package br.com.plantinha.repository;

import br.com.plantinha.Cuidados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuidadosRepository extends JpaRepository<Cuidados, Long> {

    Cuidados findByPlantaId(Long id);
    void deleteById(Long id);

}
