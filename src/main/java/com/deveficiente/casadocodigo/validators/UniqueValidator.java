package com.deveficiente.casadocodigo.validators;

import com.deveficiente.casadocodigo.newauthor.Author;
import com.deveficiente.casadocodigo.newauthor.AuthorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

//1
public class UniqueValidator implements ConstraintValidator<Unique, String> {

    private final AuthorRepository authorRepository;

    public UniqueValidator(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Author> author = authorRepository.findByEmail(value);
        return author.isEmpty();
    }
}
