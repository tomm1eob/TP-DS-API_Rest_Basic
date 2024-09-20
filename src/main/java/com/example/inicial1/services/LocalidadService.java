package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService implements BaseService<Localidad>{

    private LocalidadRepository localidadRepository;

    public LocalidadService(LocalidadRepository localidadRepository){
        this.localidadRepository = localidadRepository;
    }

    @Transactional
    @Override
    public List<Localidad> findAll() throws Exception {
        try {
            List<Localidad> entities = localidadRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Localidad findBy(Long id) throws Exception {
        try {
            Optional<Localidad> enityOptional = localidadRepository.findById(id);
            return enityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Localidad save(Localidad entity) throws Exception {
        try {
            entity = localidadRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Localidad update(Long id, Localidad entity) throws Exception {
        try {
            Optional<Localidad> entityOpcional = localidadRepository.findById(id);
            Localidad localidad = entityOpcional.get();
            localidad = localidadRepository.save(entity);
            return localidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (localidadRepository.existsById(id)){
                localidadRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
