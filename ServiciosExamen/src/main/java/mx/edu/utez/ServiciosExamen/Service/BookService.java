package mx.edu.utez.ServiciosExamen.Service;

import mx.edu.utez.ServiciosExamen.Model.Book;
import mx.edu.utez.ServiciosExamen.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public Book saveBook(Book book){
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

}
