package com.example.demo.services;

import com.example.demo.entity.Notas;
import com.example.demo.repository.NotaRepository;
import com.example.demo.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankService {
    @Autowired
    private NotaRepository notaRepository;
    @Autowired
    private RankRepository rankRepository;



}
