package user.ishmaust.shophelper.repositories.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import user.ishmaust.shophelper.repositories.entity.interfacies.Dto;


@Getter
@Setter
@Entity
public class Container implements Dto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int place;

    @OneToMany(targetEntity = Product.class)
    @JoinColumn(name = "container_id",referencedColumnName = "id")
    private Set<Product> products;

}
