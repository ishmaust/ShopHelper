package user.ishmaust.shophelper.servicies.interfacies;

import java.util.List;
import java.util.Set;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;

public interface ProductService extends EntityOperationService<Product> {

  Set<String> getAllProductName();

  List<Product> getAllProduct();

  void updateProductContainer(Long id, Container container);
}
