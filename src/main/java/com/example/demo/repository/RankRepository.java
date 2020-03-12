package com.example.demo.repository;

import com.example.demo.entity.Rank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankRepository extends CrudRepository<Rank, Long> {
    List<Rank>  findByOrderByResultadoDesc();
}
