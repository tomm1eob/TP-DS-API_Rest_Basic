package com.example.inicial1.services;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements BaseService<Autor> {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @Override
    @Transactional
    public List<Autor> findAll() throws Exception {
        try {
            List<Autor> entities = autorRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor findBy(Long id) throws Exception {
        try {
            Optional<Autor> enityOptional = autorRepository.findById(id);
            return enityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor save(Autor entity) throws Exception {
        try {
            entity = autorRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor update(Long id, Autor entity) throws Exception {
        try {
            Optional<Autor> entityOpcional = autorRepository.findById(id);
            Autor autor = entityOpcional.get();
            autor = autorRepository.save(entity);
            return autor;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (autorRepository.existsById(id)){
                autorRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
