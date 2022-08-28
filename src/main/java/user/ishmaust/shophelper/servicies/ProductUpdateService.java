package user.ishmaust.shophelper.servicies;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;

@Service
public class ProductUpdateService {

  private final ProductServiceImpl productService;
  private final ContainerOperationService containerService;

  @Autowired
  public ProductUpdateService(ProductServiceImpl productService,
      ContainerOperationService containerService) {
    this.productService = productService;
    this.containerService = containerService;
  }

  public Product updateProductContainer(Long productId, String containerIdValue) {
    Optional<Container> containerOptional = containerService.findById(Long.parseLong(containerIdValue));
    Optional<Product> productOptional = productService.findById(productId);
    if (productOptional.isPresent() && containerOptional.isPresent()) {
      productService.updateProductContainer(productId, containerOptional.get());
      return productService.getByIdEntity(productId);
    } else {
      throw new NumberFormatException("Incorrect number!");
    }
  }
}
