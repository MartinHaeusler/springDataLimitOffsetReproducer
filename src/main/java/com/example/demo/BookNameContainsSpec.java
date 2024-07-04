package com.example.demo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BookNameContainsSpec implements Specification<Book> {

    private String name;

    public BookNameContainsSpec(final String name) {
        this.name = name;
    }


    @Override
    public Predicate toPredicate(final Root<Book> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(
            criteriaBuilder.lower(root.get("name")),
            "%" + this.name.toLowerCase() + "%"
        );
    }
}
