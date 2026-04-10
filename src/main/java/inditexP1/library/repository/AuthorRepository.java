package inditexP1.library.repository;

import inditexP1.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Integer> {
    List<Author> findByCategory(String category);
}
