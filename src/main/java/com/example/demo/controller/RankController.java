package com.example.demo.controller;

import com.example.demo.entity.Notas;
import com.example.demo.entity.Rank;
import com.example.demo.repository.AlunoRespository;
import com.example.demo.repository.DisciplinaRepository;
import com.example.demo.repository.NotaRepository;
import com.example.demo.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@RestController
@RequestMapping("cfo")
@CrossOrigin
public class RankController {
    @Autowired
    private AlunoRespository alunoRespository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private NotaRepository notaRepository;
    @Autowired
    private RankRepository rankRepository;


    @GetMapping("/listNota")
    public Iterable<Notas> listNota() {
        return notaRepository.findAll();
    }

    @GetMapping("/{ano}")
    public Iterable<Rank> listRank(@PathVariable int ano) {
        List<Notas> nota = notaRepository.findByAluno_Ano(ano);
        List<Integer> ids = new ArrayList<Integer>();
        rankRepository.deleteAll();
        for (int i = 0; i < nota.size(); i++) {
            ids.add(nota.get(i).getAluno().getId());
        }
        HashSet<Integer> h = new HashSet<Integer>(ids);
        ids.clear();
        ids.containsAll(h);
        for (Integer temp : h) {
            Double denominador = 0.0;
            Rank rank = new Rank();
            int numerador = 0;
            for (int j = 0; j < nota.size(); j++) {
                if (temp == nota.get(j).getAluno().getId()) {
                    denominador += nota.get(j).getNota() * nota.get(j).getDisciplina().getPeso();
                    numerador += nota.get(j).getDisciplina().getPeso();
                    System.out.println(nota.get(j).getAluno().getNome());
                    System.out.println("Nota:" + nota.get(j).getNota() * nota.get(j).getDisciplina().getPeso());
                    rank.setAluno(nota.get(j).getAluno());
                }
            }
            System.out.println("denominador " + denominador);
            System.out.println("numerador " + numerador);
            System.out.println("Resultado" + denominador / numerador);
            rank.setResultado(denominador / numerador);
            rankRepository.save(rank);
        }
        return rankRepository.findAll();
    }

    @GetMapping("/listRank")
    public Iterable<Rank> listRank() {
        return rankRepository.findByOrderByResultadoDesc() ;
    }

}