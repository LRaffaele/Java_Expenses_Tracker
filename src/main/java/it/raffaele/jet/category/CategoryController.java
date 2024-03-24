package it.raffaele.jet.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
@Validated
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping("/{categoryId}")
  public ResponseEntity<?> getCategory(@PathVariable @Min(1) long categoryId){
    return categoryService.getCategory(categoryId);
  }

  @PostMapping
  public ResponseEntity<?> addCategory(@RequestParam @NotBlank @Size(min = 5, max = 50) String categoryName){
    return categoryService.addCategory(categoryName);
  }



}