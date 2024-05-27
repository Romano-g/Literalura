package br.com.alura.challenge.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "authors")
public class AuthorDataClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private int birthYear;
    private int deathYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BookDataClass> books = new ArrayList<>();

    public AuthorDataClass () {}

    public AuthorDataClass (ResultsData resultsData) {
        this.name = resultsData.resultados().get(0).autores().get(0).nome();
        this.birthYear = resultsData.resultados().get(0).autores().get(0).birthYear();
        this.deathYear = resultsData.resultados().get(0).autores().get(0).deathYear();
    }

    public void setBooks(BookDataClass books) {
        books.setAuthor(this);
        this.books.add(books);
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    @Override
    public String toString() {
        return getName();
    }
}
