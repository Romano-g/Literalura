package br.com.alura.challenge.literalura.repository;

import br.com.alura.challenge.literalura.model.AuthorDataClass;
import java.util.List;
import br.com.alura.challenge.literalura.model.BookDataClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<BookDataClass, Long> {
    @Query("SELECT a FROM BookDataClass b JOIN b.author a WHERE (a.birthYear) <= :year AND (a.deathYear) >= :year")
    List<AuthorDataClass> findAliveAuthors(int year);
}
