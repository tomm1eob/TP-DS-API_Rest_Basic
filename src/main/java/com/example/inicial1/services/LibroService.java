package com.example.inicial1.services;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements BaseService<Libro>{

    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository){
        this.libroRepository= libroRepository;
    }

    @Transactional
    @Override
    public List<Libro> findAll() throws Exception {
        try {
            List<Libro> entities = libroRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Libro findBy(Long id) throws Exception {
        try {
            Optional<Libro> enityOptional = libroRepository.findById(id);
            return enityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Libro save(Libro entity) throws Exception {
        try {
            entity = libroRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Libro update(Long id, Libro entity) throws Exception {
        try {
            Optional<Libro> entityOpcional = libroRepository.findById(id);
            Libro libro= entityOpcional.get();
            libro = libroRepository.save(entity);
            return libro;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (libroRepository.existsById(id)){
                libroRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
