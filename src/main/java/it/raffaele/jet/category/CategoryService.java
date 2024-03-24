package it.raffaele.jet.category;

import it.raffaele.jet.common.ResourceNotFoundException;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
