package inditexP1.library.repository;

import inditexP1.library.model.Author;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;


@Repository
public interface AuthorRepository  extends JpaRepository<Author, Integer> {
}
