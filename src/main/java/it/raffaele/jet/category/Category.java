package it.raffaele.jet.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter @ToString
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long categoryId;

  @Column(nullable = false, unique = true, length = 50)
  private String categoryName;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return categoryId == category.categoryId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId);
  }
}
