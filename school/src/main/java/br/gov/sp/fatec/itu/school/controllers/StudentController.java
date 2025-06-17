package br.gov.sp.fatec.itu.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.school.entities.Student;
import br.gov.sp.fatec.itu.school.services.StudentService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//expondo os endpoints, camada mais externa. Todos os endpoints são públicos (ESSAS SÃO AS APIs)
//Envia um request e recebe um response
@CrossOrigin
@RestController
@RequestMapping("students")
public class StudentController {
    
    @Autowired //injeção de dependências ("Spring, crie para mim este objeto e injete-o  aqui")
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.created(null).body(service.save(student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Student student) {
        service.update(student, id);
        return ResponseEntity.noContent().build();
    }
}
