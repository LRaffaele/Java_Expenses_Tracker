package it.raffaele.jet.expense;

import it.raffaele.jet.category.Category;
import it.raffaele.jet.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter @ToString
public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long incomeId;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "category",nullable = false)
  private Category category;

  @Column(length = 100)
  private String description;

  @Column(nullable = false)
  private BigDecimal amountDue;

  @Column(nullable = false)
  private LocalDateTime payedOn;

  public Expense(User user, Category category, String description, BigDecimal amountDue,
      LocalDateTime receivedOn) {
    this.user = user;
    this.category = category;
    this.description = description;
    this.amountDue = amountDue;
    this.payedOn = receivedOn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Expense income = (Expense) o;
    return incomeId == income.incomeId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(incomeId);
  }
}
