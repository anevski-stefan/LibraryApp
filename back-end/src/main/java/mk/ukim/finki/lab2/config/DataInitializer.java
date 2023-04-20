package mk.ukim.finki.lab2.config;

import mk.ukim.finki.lab2.model.Author;
import mk.ukim.finki.lab2.model.Country;
import mk.ukim.finki.lab2.service.AuthorService;
import mk.ukim.finki.lab2.service.BookService;
import mk.ukim.finki.lab2.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static mk.ukim.finki.lab2.model.enumerations.Category.*;

@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final CountryService countryService;
    private final BookService bookService;

    public DataInitializer(AuthorService authorService, CountryService countryService, BookService bookService) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void initData() {
        Country country = new Country("Macedonia", "Europe");
        Country country1 = new Country("Portugal", "Europe");
        Country country2 = new Country("Slovenia", "Europe");
        Country country3 = new Country("Spain", "Europe");

        countryService.create(country);
        countryService.create(country1);
        countryService.create(country2);
        countryService.create(country3);

        Author author1 = new Author("J.K.", "Rowling", country);
        Author author2 = new Author("Stephen", "King", country1);
        Author author3 = new Author("Neil", "Gaiman", country2);
        Author author4 = new Author("Margaret", "Atwood", country);
        Author author5 = new Author("Haruki", "Murakami", country1);
        Author author6 = new Author("Zadie", "Smith", country2);
        Author author7 = new Author("Salman", "Rushdie", country3);


        authorService.create(author1);
        authorService.create(author2);
        authorService.create(author3);
        authorService.create(author4);
        authorService.create(author5);
        authorService.create(author6);
        authorService.create(author7);

        this.bookService.create("The Shining, It, The Stand", FANTASY, author2.getId(), 2);
        this.bookService.create("American Gods, Coraline, The Sandman graphic novel series", FANTASY, author3.getId(), 4);
        this.bookService.create("The Handmaid's Tale, Alias Grace, Oryx and Crake", HISTORY, author4.getId(), 1);
        this.bookService.create("Norwegian Wood, Kafka on the Shore, 1Q84", SURREALISM, author5.getId(), 1);
        this.bookService.create("White Teeth, On Beauty, Swing Time", FICTION, author6.getId(), 1);
        this.bookService.create("Midnight's Children, The Satanic Verses, Shame", HISTORY, author7.getId(), 1);
    }
}
