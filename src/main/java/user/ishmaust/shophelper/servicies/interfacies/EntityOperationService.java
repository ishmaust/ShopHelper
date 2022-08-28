package user.ishmaust.shophelper.servicies.interfacies;

import java.util.List;
import java.util.Optional;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.repositories.entity.interfacies.Dto;

public interface EntityOperationService<T extends Dto> {

  T addEntity(T entity);

  Optional<T> findById(Long id);

  void removeEntity(Long id);

  void removeEntity(T entity);

}
