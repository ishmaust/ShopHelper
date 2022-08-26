package user.ishmaust.shophelper.repositories.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import user.ishmaust.shophelper.repositories.entity.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

  @Modifying
  @Query("update Container c set c.place = ?2 where c.id = ?1")
  int updateContainerPlace(Long id, int place);

}
