package user.ishmaust.shophelper.repositories.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Transactional
  @Modifying
  @Query("update Product c set c.container = ?2 where c.id = ?1")
  void updateProductContainer(Long id, Container container);

}
