package user.ishmaust.shophelper.repositories.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.ishmaust.shophelper.repositories.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
