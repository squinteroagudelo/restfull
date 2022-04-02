package com.example.demo.controllers;

import com.example.demo.entities.Professor;
import com.example.demo.services.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessorController {
    @Autowired
    private IProfessorService professorService;

    @GetMapping("/professors")
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> getProfessors(){
        return professorService.findAll();
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> addProfessor(@RequestBody Professor p){
        if (professorService.findProfessor(p) == null){
            professorService.save(p);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Professor p){
        if (professorService.checkProfessorLogin(p) != null){
            return new ResponseEntity<Professor>(professorService.checkProfessorLogin(p),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<?> updateProfessor(@PathVariable(value="id") long id, @RequestBody Professor p){
        Professor professor =  professorService.findById(id);
        if(professor != null) {
            professor.setEmail(p.getEmail());
            professor.setName(p.getName());
            professorService.updateProfessor(professor);
            return new ResponseEntity<>(professor, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable("id") long id){
        Professor professor = professorService.findById(id);
        if (professor != null){
            professorService.deleteProfessor(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteAllProfessors(){
        professorService.deleteAllProfessors();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
