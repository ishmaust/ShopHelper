package user.ishmaust.shophelper.servicies.interfacies;

import java.util.Optional;
import user.ishmaust.shophelper.repositories.entity.Company;

public interface CompanyService extends EntityOperationService<Company>{

  Company findByName(String name);

}
