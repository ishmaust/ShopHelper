package user.ishmaust.shophelper.servicies;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ishmaust.shophelper.repositories.dao.CompanyRepository;
import user.ishmaust.shophelper.repositories.entity.Company;
import user.ishmaust.shophelper.servicies.interfacies.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepository companyRepository;

  @Autowired
  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public Company addEntity(Company entity) {
    return companyRepository.save(entity);
  }

  @Override
  public Optional<Company> findById(Long id) {
    return companyRepository.findById(id);
  }

  @Override
  public void removeEntity(Long id) {
    companyRepository.deleteById(id);
  }

  @Override
  public void removeEntity(Company entity) {
    companyRepository.delete(entity);
  }
}
