package com.example.demo.services;

import com.example.demo.dao.IProfessorDAO;
import com.example.demo.entities.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements IProfessorService{

    @Autowired
    private IProfessorDAO professorDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Professor> findAll() {
        return (List<Professor>) professorDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Professor p) {
        professorDAO.save(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Professor findProfessor(Professor p) {
        return (Professor) professorDAO.findByEmail(p.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public Professor checkProfessorLogin(Professor p) {
        return (Professor) professorDAO.findByEmailAndPassword(p.getEmail(), p.getPassword());
    }

    @Override
    @Transactional
    public void deleteProfessor(Professor p) {
        professorDAO.deleteById(p.getId());
    }

    @Override
    @Transactional
    public void deleteAllProfessors() {
        professorDAO.deleteAll();
    }

    @Override
    @Transactional
    public Professor updateProfessor(Professor p) {
        return (Professor) professorDAO.save(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Professor> findProfessorById(Long id) {
        return (Optional<Professor>) professorDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteProfessor(Long id) {
        professorDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Professor findById(Long id) {
        return (Professor) professorDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Professor findByIdSQL(long id) {
        return professorDAO.findByIdSQL(id);
    }
}
