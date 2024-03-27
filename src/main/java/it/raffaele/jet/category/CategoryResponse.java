package it.raffaele.jet.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class CategoryResponse {

  private long categoryId;
  private String categoryName;

}
