package com.example.demo;

import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private BookRepository repository;

    public BookService(final BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Book saveBook(Book book){
        return this.repository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> findBooksByPagesDesc(Specification<Book> specification, int limit, int offset) {
        return this.repository.findBy(specification, entry ->
            entry.sortBy(Sort.by("pages").descending())
                .limit(limit)
                .scroll(ScrollPosition.offset(offset))
                .toList()
        );
    }
}
