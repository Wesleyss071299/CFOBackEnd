package com.example.demo.services;

import com.example.demo.entity.Aluno;
import com.example.demo.entity.Disciplina;
import com.example.demo.entity.Notas;
import com.example.demo.repository.AlunoRespository;
import com.example.demo.repository.DisciplinaRepository;
import com.example.demo.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class FakerService {
    @Autowired
    private AlunoRespository alunoRespository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private NotaRepository notaRepository;

    public Iterable<Notas> Notafaker(){
        Notas notas = new Notas();
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker(new Locale("pt-BR"));
        int countAluno = (int)alunoRespository.count();
        int countDisciplina = (int)disciplinaRepository.count();

        Aluno aluno = new Aluno();
        aluno.setId(faker.number().numberBetween(1,countAluno));

        Disciplina disciplina = new Disciplina();
        disciplina.setId(faker.number().numberBetween(1,countDisciplina));

        notas.setDisciplina(disciplina);
        notas.setNota(faker.number().randomDouble(2,0,10));
        notas.setAluno(aluno);
        notaRepository.save(notas);
        return  notaRepository.findAll();
    }

    public Iterable<Aluno> Alunofaker() {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker(new Locale("pt-BR"));
        for (int i = 0; i < 10; i++) {
            Aluno aluno = new Aluno();
            aluno.setNome(faker.name().fullName());
            aluno.setAno(faker.number().numberBetween(2018, 2021));
            alunoRespository.save(aluno);
        }
        return alunoRespository.findAll();
    }

    public Iterable<Disciplina> Disciplinafaker() {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker(new Locale("pt-BR"));
        for (int i = 0; i < 10; i++) {
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(faker.educator().course());
            disciplina.setPeso(faker.number().randomDigit());
            disciplinaRepository.save(disciplina);
        }
        return disciplinaRepository.findAll();
    }



}
