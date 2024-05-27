package br.com.alura.challenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorData (
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") int birthYear,
        @JsonAlias("death_year") int deathYear
) {}
