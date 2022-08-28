package user.ishmaust.shophelper.repositories.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import user.ishmaust.shophelper.dto.CompanyInformation;
import user.ishmaust.shophelper.repositories.entity.interfacies.Dto;
import user.ishmaust.shophelper.utils.converters.CompanyInformationConverter;

@Entity
@Getter
@Setter
public class Company implements Dto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Convert(converter = CompanyInformationConverter.class)
  private CompanyInformation companyInformation;

  @JsonIgnore
  @OneToMany(targetEntity = Product.class)
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  private Set<Product> products;

  @JsonIgnore
  @OneToMany(targetEntity = Order.class)
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  private Set<Order> orders;

}
