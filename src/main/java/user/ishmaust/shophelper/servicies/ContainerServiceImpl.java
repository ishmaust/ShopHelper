package user.ishmaust.shophelper.servicies;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
  public Container findById(Long id) {
    return containerRepository.findById(id).orElseThrow(NotFoundEntityException::new);
  }

  @Transactional
  @Override
  public void removeEntity(Long id) {
    containerRepository.deleteById(id);
  }

  @Transactional
  @Override
  public void removeEntity(Container entity) {
    containerRepository.delete(entity);
  }

  @Override
  public Set<Product> getAllProductsFromContainerById(Long id) {
    return findById(id).getProducts();
  }

  @Transactional
  @Override
  public Container updateContainer(Long id, Container requestContainer) {
    Container container = findById(id);
    requestContainer.setId(id);
    if(container.equals(requestContainer)) {
      return container;
    }
    return containerRepository.save(requestContainer);
  }

  @Transactional
  @Override
  public Container deleteContainer(Long id) {
    Container container = findById(id);
    removeEntity(id);
    return container;
  }

  @Override
  public List<Container> getAllContainers() {
    return containerRepository.findAll();
  }
}
