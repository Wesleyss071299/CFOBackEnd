package com.example.demo.repository;

import com.example.demo.entity.Notas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends CrudRepository<Notas, Long> {
 List<Notas> findByAluno_Ano(int amo);

}
