package user.ishmaust.shophelper.servicies.interfacies;

import java.util.Set;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;

public interface ProductService extends EntityOperationService<Product> {

  Set<String> getAllProductName();

  void updateProductContainer(Long id, Container container);
}
