package com.example.examenfinal.models.services;

import com.example.examenfinal.models.dao.DireccionRepositorio;
import com.example.examenfinal.models.entity.direccion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DireccionService implements IDireccionService{

    private final DireccionRepositorio direccionDAO;

    public DireccionService(DireccionRepositorio direccionDAO){
        this.direccionDAO = direccionDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<direccion> findAll() {
        return (List<direccion>) direccionDAO.findAll();
    }

    @Override
    @Transactional
    public void save(direccion direccion) {
        direccionDAO.save(direccion);
    }

    @Override
    @Transactional(readOnly = true)
    public direccion findOne(Long id) {
        return direccionDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        direccionDAO.deleteById(id);
    }

}