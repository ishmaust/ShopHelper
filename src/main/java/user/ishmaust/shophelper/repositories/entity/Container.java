package user.ishmaust.shophelper.repositories.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import user.ishmaust.shophelper.repositories.entity.interfacies.EntityMarker;


@Getter
@Setter
@Entity
public class Container implements EntityMarker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Place identifier  should be more or equals 1!")
    @Column(nullable = false)
    private int place;

    @JsonIgnore
    @OneToMany(targetEntity = Product.class)
    @JoinColumn(name = "container_id", referencedColumnName = "id")
    private Set<Product> products;

}
