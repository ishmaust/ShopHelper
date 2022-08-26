package user.ishmaust.shophelper.repositories.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 2048)
    private String description;

    @Column(nullable = false)
    private int price;

    private int count;

    @ManyToOne
    private Container container;
}
