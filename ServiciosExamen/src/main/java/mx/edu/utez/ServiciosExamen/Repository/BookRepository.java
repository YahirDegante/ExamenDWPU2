package mx.edu.utez.ServiciosExamen.Repository;

import mx.edu.utez.ServiciosExamen.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByOrderByFechaPublicacionAsc();
    List<Book> findByOrderByAutorAsc();
}

