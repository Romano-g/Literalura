package br.com.alura.challenge.literalura.main;

import br.com.alura.challenge.literalura.model.AuthorDataClass;
import br.com.alura.challenge.literalura.model.BookDataClass;
import br.com.alura.challenge.literalura.model.LanguagesEnum;
import br.com.alura.challenge.literalura.model.ResultsData;
import br.com.alura.challenge.literalura.repository.BookRepository;
import br.com.alura.challenge.literalura.service.ConsumeApi;
import br.com.alura.challenge.literalura.service.DataConverter;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Scanner;

public class Main {
    private BookRepository repository;
    private DataConverter dataConverter = new DataConverter();
    private ConsumeApi consumeApi = new ConsumeApi();
    private Scanner scanner = new Scanner(System.in);

    private int userOption = -1;

    private final String URI = "https://gutendex.com/books/?search=";

    public Main(BookRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {

        while (userOption != 0) {
            System.out.println(
                    """
                    \nEscolha uma das opções abaixo:
                    
                    1 - Buscar um livro;
                    2 - Listar livros buscados;
                    3 - Listar autores;
                    4 - Buscar autores vivos em um ano;
                    5 - Mostrar apenas os livros em português;
                    
                    0 - Sair;
                    """
            );
            userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    showSearchs();
                    break;
                case 3:
                    showAuthors();
                    break;
                case 4:
                    showAliveAuthors();
                    break;
                case 5:
                    showBooksInPt();
                    break;
                case 0:
                    System.out.println("\nSaindo...\n");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

    }

    private void searchBook() {
        System.out.println("\nDigite o titulo do livro para pesquisar:");
        var userBook = scanner.nextLine();

        var userBookJson = consumeApi.getData(
                URI + userBook.toLowerCase().replace(" ", "+"));

        try {
            ResultsData resultsData = dataConverter.getData(userBookJson, ResultsData.class);

            AuthorDataClass authorDataClass = new AuthorDataClass(resultsData);
            BookDataClass userBookClass = new BookDataClass(resultsData);
            try {
                authorDataClass.setBooks(userBookClass);
                repository.save(userBookClass);
                System.out.println("\n" + userBookClass);
            } catch (DataIntegrityViolationException c) {
                System.out.println("\n" + userBookClass);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nO gutendex não reconhece este livro!");
        }

    }

    private void showSearchs() {
        System.out.println("\nEsses são os títulos buscados ate agora:");
        var searched = repository.findAll();
        searched.stream().forEach(System.out::println);
    }

    private void showAuthors() {
        System.out.println("\nEsses são os autores que foram buscados ate aqui:");
        var searched = repository.findAll();
        searched.stream().forEach(e -> System.out.println(e.getAuthor()));
    }

    private void showAliveAuthors() {
        System.out.println("\nEm que ano gostaria de pesquisar?");
        var userYear = scanner.nextInt();
        scanner.nextLine();

        var searched = repository.findByAuthorBirthYearLessThanEqualAndAuthorDeathYearGreaterThanEqual(userYear, userYear);

        if (searched.size() > 0) {
            System.out.println("\nO(s) autor(es) vivo(s) nesse ano era(m):");
            searched.forEach(a -> System.out.println(a.getAuthor()));
        } else {
            System.out.println("\nNenhum autor da nossa database estava vivo nesse ano!");
        }

    }

    private void showBooksInPt() {
        LanguagesEnum languagesEnum = LanguagesEnum.fromString("pt");

        var searched = repository.findByLanguages(languagesEnum);

        System.out.println("\nEsses são todos os nossos " + searched.size() + " títulos em português:");
        searched.forEach(System.out::println);
    }
}
