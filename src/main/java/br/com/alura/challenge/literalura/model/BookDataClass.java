package br.com.alura.challenge.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookDataClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private AuthorDataClass author;

    private Integer downloads;

    @Enumerated(EnumType.STRING)
    private LanguagesEnum languages;

    public BookDataClass() {}

    public BookDataClass(ResultsData resultsData) {
        this.title = resultsData.resultados().get(0).titulo();
        this.languages = LanguagesEnum.fromString(resultsData.resultados().get(0).idiomas().get(0).toString());
        this.downloads = resultsData.resultados().get(0).numeroDownloads();
    }

    public void setAuthor(AuthorDataClass author) {
        this.author = author;
    }

    public AuthorDataClass getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Título: " + title + " | Autor: " + author + " | Idioma: " + languages + " | Número de downloads: " + downloads;
    }
}
