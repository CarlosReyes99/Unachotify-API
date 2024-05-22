package com.UNACHOtify.demo.repository;

import com.UNACHOtify.demo.entity.ArtistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<ArtistaEntity, Integer> {
}
