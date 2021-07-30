package com.deveficiente.casadocodigo.newauthor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    //1
    public ResponseEntity<String> create(@RequestBody @Valid NewAuthorRequest newAuthorRequest) {
        //1
        Author author = newAuthorRequest.toEntity();
        entityManager.persist(author);
        return ResponseEntity.ok(author.toString());
    }

}
