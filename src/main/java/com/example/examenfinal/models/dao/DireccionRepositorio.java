package com.example.examenfinal.models.dao;

import com.example.examenfinal.models.entity.direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepositorio extends JpaRepository <direccion, Long> {
}