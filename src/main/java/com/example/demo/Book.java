package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "Book")
public class Book {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "pages")
    private int pages;

    private Book() {
        this.id = UUID.randomUUID();
    }

    public Book(String name, int pages){
        this(UUID.randomUUID(), name, pages);
    }

    public Book(final UUID id, final String name, final int pages) {
        this.id = id;
        this.name = name;
        this.pages = pages;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(final int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pages=" + pages +
            '}';
    }
}
