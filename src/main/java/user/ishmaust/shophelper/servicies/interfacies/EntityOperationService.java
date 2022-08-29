package user.ishmaust.shophelper.servicies.interfacies;

import java.util.Optional;
import user.ishmaust.shophelper.repositories.entity.interfacies.EntityMarker;

public interface EntityOperationService<T extends EntityMarker> {

  T addEntity(T entity);

  T findById(Long id);

  void removeEntity(Long id);

  void removeEntity(T entity);

}
