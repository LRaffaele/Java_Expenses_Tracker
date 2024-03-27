package it.raffaele.jet.category;

import it.raffaele.jet.common.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public ResponseEntity<?> addCategory(String categoryName) {
    categoryName = categoryName.toLowerCase().trim();

    if(categoryRepository.existsByCategoryName(categoryName)){
      return new ResponseEntity("Category name already exists. Please try another name", HttpStatus.BAD_REQUEST);
    }

    Category newCategory = new Category(categoryName);
    categoryRepository.save(newCategory);
    return new ResponseEntity<>("Category successfully created", HttpStatus.CREATED);
  }

  public ResponseEntity<?> getCategory(long categoryId) {

    Category category = categoryRepository.findByCategoryId(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

    return new ResponseEntity<>(category, HttpStatus.OK);
  }

  public ResponseEntity<?> getAllCategories() {

    List<CategoryResponse> categories = categoryRepository.getAllCategories();

    return new ResponseEntity<>(categories, HttpStatus.OK);
  }

  @Transactional
  public ResponseEntity<?> updateCategory(long categoryId, String newCategoryName) {
    newCategoryName = newCategoryName.trim().toLowerCase();

    if(categoryRepository.existsByCategoryNameAndCategoryIdNot(newCategoryName, categoryId)){
      return new ResponseEntity<>("Category name already in use, please choose another name", HttpStatus.BAD_REQUEST);
    }

    Category category = categoryRepository.findByCategoryId(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));

    category.setCategoryName(newCategoryName);

    return new ResponseEntity<>("Category successfully updated", HttpStatus.OK);
  }

  public ResponseEntity<?> deleteCategory(long categoryId) {

    Category category = categoryRepository.findByCategoryId(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));

    categoryRepository.delete(category);
    return new ResponseEntity<>("Category successfully deleted", HttpStatus.OK);
  }
}
