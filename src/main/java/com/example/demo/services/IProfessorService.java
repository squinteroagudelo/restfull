package com.example.demo.services;

import com.example.demo.entities.Professor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {

    public List<Professor> findAll();

    public void save(Professor p);

    public Professor findProfessor(Professor p);

    public Professor checkProfessorLogin(Professor p);

    public void deleteProfessor(Professor p);

    public void deleteAllProfessors();

    public Professor updateProfessor(Professor p);

    public Optional<Professor> findProfessorById(Long id);

    public void deleteProfessor(Long id);

    public Professor findById(Long id);

    @Query(value = "select p from professor p where p.id=?1", nativeQuery = true)
    public Professor findByIdSQL(long id);

}
