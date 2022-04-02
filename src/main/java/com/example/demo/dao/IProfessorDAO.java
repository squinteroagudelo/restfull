package com.example.demo.dao;

import com.example.demo.entities.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IProfessorDAO extends CrudRepository<Professor, Long> {

    public Professor findByEmail(String email);

    public Professor findByEmailAndPassword(String email, String password);

    public Professor findByName(String name);

    public Optional<Professor> findById(long id);

    @Query(value = "select p from professor p where p.id=?1", nativeQuery = true)
    public Professor findByIdSQL(long id);
}
