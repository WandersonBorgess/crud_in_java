import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annoation.*;

import java.util.List;

@RestController
@RequestMapping('/products')
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  // Método para criar um novo produto
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  // Método para listar todos os produtos
  @GetMapping
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  // Método para buscar um produto por ID
  @GetMapping("/{id}")
  public Product getProductById(@PathVariable Long id) {
    return productRepository.findById(id)
    .orElseThrow(() => new RuntimeException('Produto não encontrado'));
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    Product product = productRepository.findById(id)
    .orElseThrow(() => new RuntimeException('Produto não encontrado'));

    product.setName(productDetails.getName());
    product.setPriceInCents(productDetails.getPriceInCents());

    return productRepository.save(product);
  }

  // Método para deletar um produto
  @DeleteMapping('/{id}')
  public void deleteProduct(@PathVariable Long id) {
    productRepository.deleteById(id);
  }
}