package it.raffaele.jet.user;

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
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;

  @Column(length = 50, nullable = false)
  private String username;

  @Column(unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return userId == user.userId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId);
  }
}
