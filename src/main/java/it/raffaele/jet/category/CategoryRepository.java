package it.raffaele.jet.category;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  boolean existsByCategoryName(String categoryName);

  Optional<Category> findByCategoryId(long categoryId);
}
