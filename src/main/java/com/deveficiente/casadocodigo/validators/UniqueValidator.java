package com.deveficiente.casadocodigo.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Long email = (Long) entityManager.createQuery(
                        "SELECT COUNT (a) FROM Author a WHERE a.email LIKE :email")
                .setParameter("email", value)
                .getSingleResult();

        return email == 0;
    }
}
