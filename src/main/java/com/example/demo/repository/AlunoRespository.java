package com.example.demo.repository;

import com.example.demo.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRespository extends CrudRepository<Aluno, Long> {

}
