package user.ishmaust.shophelper.servicies;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.ishmaust.shophelper.dto.ProductDto;
import user.ishmaust.shophelper.exceptions.NotFoundEntityException;
import user.ishmaust.shophelper.repositories.dao.ProductRepository;
import user.ishmaust.shophelper.repositories.entity.Company;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.interfacies.CompanyService;
import user.ishmaust.shophelper.servicies.interfacies.ProductService;
import user.ishmaust.shophelper.utils.converters.ProductBuilder;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final CompanyService companyService;
  private final ProductBuilder productBuilder;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository, CompanyService companyService,
      ProductBuilder productBuilder) {
    this.productRepository = productRepository;
    this.companyService = companyService;
    this.productBuilder = productBuilder;
  }

  @Transactional
  @Override
  public Product addEntity(Product entity) {
    return productRepository.save(entity);
  }

  @Override
  public Product findById(Long id) {
    return productRepository.findById(id).orElseThrow(NotFoundEntityException::new);
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
  public List<Product> getProductsByName(String name) {
    return StreamSupport.stream(productRepository.findAllByNameContainingIgnoreCase(name).spliterator(), false)
        .collect(Collectors.toList());
  }

  @Transactional
  @Override
  public Product addNewProduct(ProductDto productDto) {
    return productRepository.save(productBuilder.setDataByProductDto(productDto).build());
  }

  @Transactional
  @Override
  public Product updateProduct(ProductDto productDto, Long id) {
    Product product = productRepository.findById(id).orElseThrow(NotFoundEntityException::new);
    if(product.equalsFields(productDto)) {
      return product;
    }
    Product newProduct = productBuilder.setDataByProductDto(productDto).build();
    newProduct.setId(id);
    return productRepository.save(newProduct);

  }

  @Override
  public Product deleteProduct(Long id) {
    Product product = productRepository.findById(id).orElseThrow(NotFoundEntityException::new);
    removeEntity(id);
    return product;
  }
}
