package com.example.demo.controller;


import com.example.demo.entity.Aluno;
import com.example.demo.entity.Disciplina;
import com.example.demo.entity.Notas;
import com.example.demo.services.FakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("faker")
public class FakerController {
    @Autowired
    FakerService fakerService = new FakerService();

    @GetMapping("/fakerNota")
    public Iterable <Notas> Rankfaker(){
        return fakerService.Notafaker();
    }

    @GetMapping("/fakerAluno")
    public Iterable<Aluno> Alunofaker() {
        return  fakerService.Alunofaker();
    }

    @GetMapping("/fakerDisciplina")
    public Iterable<Disciplina> Disciplinafaker() {
        return fakerService.Disciplinafaker();
    }

}
