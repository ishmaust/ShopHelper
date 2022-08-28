package user.ishmaust.shophelper.servicies;

import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ishmaust.shophelper.exceptions.NotFoundEntityException;
import user.ishmaust.shophelper.repositories.dao.ContainerRepository;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.interfacies.ContainerService;

@Service
public class ContainerServiceImpl implements ContainerService {

  private final ContainerRepository containerRepository;

  @Autowired
  public ContainerServiceImpl(ContainerRepository containerRepository) {
    this.containerRepository = containerRepository;
  }

  @Override
  public Container addEntity(Container entity) {
    return containerRepository.save(entity);
  }

  @Override
  public Optional<Container> findById(Long id) {
    return containerRepository.findById(id);
  }

  @Override
  public void removeEntity(Long id) {
    containerRepository.deleteById(id);
  }

  @Override
  public void removeEntity(Container entity) {
    containerRepository.delete(entity);
  }

  @Override
  public Set<Product> getAllProductsFromContainerById(Long id) {
    Optional<Container> optionalContainer = findById(id);
    if(optionalContainer.isPresent()) {
      return optionalContainer.get().getProducts();
    }
    throw new NotFoundEntityException();
  }
}
