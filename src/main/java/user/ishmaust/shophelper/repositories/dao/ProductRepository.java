package user.ishmaust.shophelper.repositories.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.ishmaust.shophelper.repositories.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
