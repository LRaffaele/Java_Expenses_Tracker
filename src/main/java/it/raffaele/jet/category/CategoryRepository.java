package it.raffaele.jet.category;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  boolean existsByCategoryName(String categoryName);

  Optional<Category> findByCategoryId(long categoryId);

  @Query(value = "SELECT new it.raffaele.jet.category.CategoryResponse(" 
      + "c.categoryId, "
      + "c.categoryName "
      + ") FROM Category c ")
  List<CategoryResponse> getAllCategories();

  boolean existsByCategoryNameAndCategoryIdNot(String newCategoryName, long categoryId);
}
