package user.ishmaust.shophelper.repositories.entity;

import java.util.Set;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import user.ishmaust.shophelper.dto.OrderProduct;
import user.ishmaust.shophelper.repositories.entity.interfacies.EntityMarker;
import user.ishmaust.shophelper.utils.converters.OrderProductConverter;

@Entity
@Getter
@Setter
@Table(name = "company_order")
public class Order implements EntityMarker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Transient
  private int totalPrice;

  @Convert(converter = OrderProductConverter.class)
  private Set<OrderProduct> products;

  @ManyToOne
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  private Company company;

}
