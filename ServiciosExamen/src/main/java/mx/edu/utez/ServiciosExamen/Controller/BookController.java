package mx.edu.utez.ServiciosExamen.Controller;

import mx.edu.utez.ServiciosExamen.Model.Book;
import mx.edu.utez.ServiciosExamen.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/")
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public Book saveBook(@RequestBody(required = true)Book book){
        return service.saveBook(book);
    }

    @GetMapping
    public List<Book> getAllBoooks(){
        return service.getAllBooks();
    }

    @GetMapping("/orderAutor")
    public List<Book> orderByAutor(){
        return service.getAllBooksOrderedByAutorAsc();
    }

    @GetMapping("/orderFecha")
    public List<Book> orderByFecha(){
        return service.getAllBooksOrderedByFechaPublicacionAsc();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        service.deleteBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBoo(@PathVariable Long id, @RequestBody Book book){
    return service.updateBook(id, book);
    }

}
