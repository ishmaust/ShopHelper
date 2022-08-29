package user.ishmaust.shophelper.repositories.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import user.ishmaust.shophelper.dto.ProductDto;
import user.ishmaust.shophelper.repositories.entity.interfacies.EntityMarker;

@Getter
@Setter
@Entity
public class Product implements EntityMarker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can not be empty!")
    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 2048)
    private String description;

    @Min(value = 1, message = "The min price for product is 1 coin!")
    @Column(nullable = false)
    private int orderPrice;

    @Column(nullable = false)
    @Range(message = "Margin can be only positive value!", min = 0, max = 500)
    private int margin;

    @PositiveOrZero(message = "Count can not be negative!")
    private int count;

    @PositiveOrZero(message = "Min count can not be negative!")
    private int minCount;

    @Transient
    private int shopPrice;

    @ManyToOne
    private Container container;

    @ManyToOne
    private Company company;

    @PostLoad
    private void initValues() {
        this.shopPrice = this.orderPrice + (this.orderPrice*40)/100;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }

        if(!(object instanceof Product)) {
            return false;
        }

        Product product = (Product) object;
        return this.name.equals(product.name) && this.description.equals(product.description) &&
            this.orderPrice == product.orderPrice && this.margin == product.margin &&
            this.count == product.count && this.minCount == product.minCount &&
            this.container.equals(product.container) && this.company.equals(product.company);
    }

    public boolean equalsFields(ProductDto productDto) {
        return this.name.equals(productDto.getName()) && this.description.equals(productDto.getDescription()) &&
            this.orderPrice == productDto.getOrderPrice() && this.margin == productDto.getMargin() &&
            this.count == productDto.getCount() && this.minCount == productDto.getMinCount() &&
            this.container.getId().equals(productDto.getContainer()) &&
            this.company.getName().equalsIgnoreCase(productDto.getCompany());
    }
}
