package user.ishmaust.shophelper.servicies;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.ishmaust.shophelper.exceptions.NotFoundEntityException;
import user.ishmaust.shophelper.repositories.dao.ProductRepository;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.interfacies.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product addEntity(Product entity) {
    return productRepository.save(entity);
  }

  @Transactional
  @Override
  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public void removeEntity(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public void removeEntity(Product entity) {
    productRepository.delete(entity);
  }

  @Override
  public List<Product> getAllProduct() {
    return productRepository.findAll();
  }

  @Override
  public Set<String> getAllProductName() {
    return getAllProduct().stream().map(Product::getName).collect(Collectors.toSet());
  }

  @Transactional
  @Override
  public void updateProductContainer(Long id, Container container) {
    productRepository.updateProductContainer(id, container);
  }

  public Product getByIdEntity(Long id) {
    Optional<Product> product = productRepository.findById(id);
    if(product.isPresent()) {
      return product.get();
    } else {
      throw new NotFoundEntityException();
    }
  }
}
