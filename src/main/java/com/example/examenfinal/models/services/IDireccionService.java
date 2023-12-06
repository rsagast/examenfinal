package com.example.examenfinal.models.services;

import com.example.examenfinal.models.entity.direccion;

import java.util.List;

public interface IDireccionService {
    public List<direccion> findAll();

    public void save(direccion direccion);

    public direccion findOne(Long id);

    public  void delete(Long id);

}