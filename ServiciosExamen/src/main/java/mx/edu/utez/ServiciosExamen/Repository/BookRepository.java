package mx.edu.utez.ServiciosExamen.Repository;

import mx.edu.utez.ServiciosExamen.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
