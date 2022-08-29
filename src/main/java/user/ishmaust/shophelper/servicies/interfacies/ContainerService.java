package user.ishmaust.shophelper.servicies.interfacies;

import java.util.Set;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;

public interface ContainerService extends EntityOperationService<Container> {
  Set<Product> getAllProductsFromContainerById(Long id);

}
