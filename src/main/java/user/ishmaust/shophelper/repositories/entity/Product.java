package user.ishmaust.shophelper.repositories.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import user.ishmaust.shophelper.repositories.entity.interfacies.Dto;

@Getter
@Setter
@Entity
public class Product implements Dto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name can not be empty!")
    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 2048)
    private String description;

    @Min(value = 1, message = "The min price for product is 1 coin!")
    @Column(nullable = false)
    private int price;

    private int count;

    @ManyToOne
    private Container container;
}
