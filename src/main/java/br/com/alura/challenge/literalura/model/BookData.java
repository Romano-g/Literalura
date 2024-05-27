package br.com.alura.challenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AuthorData> autores,
        @JsonAlias("languages") ArrayList idiomas,
        @JsonAlias("download_count") Integer numeroDownloads
) {
}
