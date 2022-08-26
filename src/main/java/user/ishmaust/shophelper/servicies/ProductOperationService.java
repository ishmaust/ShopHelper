package user.ishmaust.shophelper.servicies;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ishmaust.shophelper.repositories.dao.ProductRepository;
import user.ishmaust.shophelper.repositories.entity.Product;

@Service
public class ProductOperationService implements EntityOperationService<Product> {

  private final ProductRepository productRepository;

  @Autowired
  public ProductOperationService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product addEntity(Product entity) {
    return productRepository.save(entity);
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public void updateEntity(Product entity) {

  }

  @Override
  public void removeEntity(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public void removeEntity(Product entity) {
    productRepository.delete(entity);
  }
}
