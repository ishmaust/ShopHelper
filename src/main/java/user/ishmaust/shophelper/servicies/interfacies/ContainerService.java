package user.ishmaust.shophelper.servicies.interfacies;

import java.util.List;
import java.util.Set;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;

public interface ContainerService extends EntityOperationService<Container> {
  Set<Product> getAllProductsFromContainerById(Long id);

  Container updateContainer(Long id, Container cOntainer);

  Container deleteContainer(Long id);

  List<Container> getAllContainers();
}
