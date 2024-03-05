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

    public void deleteBook(Long id){
        repo.deleteById(id);
    }

    public Book updateBook(Long id, Book updateBook) {
        Book existingBook = repo.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitulo(updateBook.getTitulo());
            existingBook.setAutor(updateBook.getAutor());
            existingBook.setFechaPublicacion(updateBook.getFechaPublicacion());
            return repo.save(existingBook);
        }
        return null;
    }

    public List<Book> getAllBooksOrderedByFechaPublicacionAsc() {
        return repo.findByOrderByFechaPublicacionAsc();
    }

    public List<Book> getAllBooksOrderedByAutorAsc() {
        return repo.findByOrderByAutorAsc();
    }

}
