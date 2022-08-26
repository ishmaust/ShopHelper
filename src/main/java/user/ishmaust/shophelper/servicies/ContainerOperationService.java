package user.ishmaust.shophelper.servicies;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ishmaust.shophelper.repositories.dao.ContainerRepository;
import user.ishmaust.shophelper.repositories.entity.Container;

@Service
public class ContainerOperationService implements EntityOperationService<Container> {

  private final ContainerRepository containerRepository;

  @Autowired
  public ContainerOperationService(ContainerRepository containerRepository) {
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
  public void updateEntity(Container entity) {
    containerRepository.updateContainerPlace(entity.getId(), entity.getPlace());
  }

  @Override
  public void removeEntity(Long id) {
    containerRepository.deleteById(id);
  }

  @Override
  public void removeEntity(Container entity) {
    containerRepository.delete(entity);
  }
}
