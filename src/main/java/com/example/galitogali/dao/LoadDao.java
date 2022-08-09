package com.example.galitogali.dao;

import com.example.galitogali.entity.payLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadDao extends JpaRepository<payLoad, Long> {

    List<payLoad> findByDescription(String description);

    List<payLoad> findByName(String nameLike);
}
