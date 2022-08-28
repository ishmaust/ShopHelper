package user.ishmaust.shophelper.servicies;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;

@Service
public class ProductUpdateService {

  private final ProductServiceImpl productService;
  private final ContainerServiceImpl containerService;

  @Autowired
  public ProductUpdateService(ProductServiceImpl productService,
      ContainerServiceImpl containerService) {
    this.productService = productService;
    this.containerService = containerService;
  }

  @Transactional
  public Product updateProductContainer(Long productId, String containerIdValue) {
    Optional<Container> containerOptional = containerService.findById(Long.parseLong(containerIdValue));
    Optional<Product> productOptional = productService.findById(productId);

    if (productOptional.isPresent() && containerOptional.isPresent()) {
      Product product = productOptional.get();
      Container container = containerOptional.get();

      productService.updateProductContainer(productId, container);
      product.setContainer(container);

      return product;
    } else {
      throw new NumberFormatException("Incorrect id!");
    }
  }
}
