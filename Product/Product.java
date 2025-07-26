import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank(message = "O nome do produto não pode estar vazio")
  @Column(nullable = false, length = 100)
  private String name;

  @Positive(message = "O preço deve ser maior que zero")
  private Integer priceInCents;
}