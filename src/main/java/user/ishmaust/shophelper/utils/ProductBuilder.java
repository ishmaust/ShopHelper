package user.ishmaust.shophelper.utils;

import org.springframework.stereotype.Component;
import user.ishmaust.shophelper.dto.ProductDto;
import user.ishmaust.shophelper.repositories.entity.Company;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.CompanyServiceImpl;
import user.ishmaust.shophelper.servicies.ContainerServiceImpl;
import user.ishmaust.shophelper.servicies.interfacies.CompanyService;
import user.ishmaust.shophelper.servicies.interfacies.ContainerService;

@Component
public class ProductBuilder {

  private final CompanyService companyService;
  private final ContainerService containerService;

  private String name;
  private String description;
  private int orderPrice;
  private int margin;
  private Container container;
  private Company company;
  private int count;
  private int minCount;

  public ProductBuilder(ContainerServiceImpl containerService, CompanyServiceImpl companyService) {
    this.companyService = companyService;
    this.containerService = containerService;

    resetBuilder();
  }

  public void resetBuilder() {
    this.name = null;
    this.container = null;
    this.company = null;
    this.orderPrice = 0;
    this.count = 0;
    this.minCount = 0;
    this.description = "";
    this.margin = 40;
  }

  public ProductBuilder setDataByProductDto(ProductDto productDto) {
    this.name = productDto.getName();
    this.description = productDto.getDescription();
    this.orderPrice = productDto.getOrderPrice();
    this.margin = productDto.getMargin();
    this.count = productDto.getCount();
    this.minCount = productDto.getMinCount();
    this.company = getCompany(productDto.getCompany());
    this.container = getContainer(productDto.getContainer());
    return this;
  }

  public ProductBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ProductBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ProductBuilder setOrderPrice(int orderPrice) {
    this.orderPrice = orderPrice;
    return this;
  }

  public ProductBuilder setMargin(int margin) {
    this.margin = margin;
    return this;
  }

  public ProductBuilder setCount(int count) {
    this.count = count;
    return this;
  }

  public ProductBuilder setMinCount(int minCount) {
    this.minCount = minCount;
    return this;
  }

  public ProductBuilder setContainer(Long containerId) {
    this.container = getContainer(containerId);
    return this;
  }

  public ProductBuilder setCompany(String companyName) {
    this.company = getCompany(companyName);
    return this;
  }

  private Container getContainer(Long containerId) {
    return containerService.findById(containerId);
  }

  private Company getCompany(String companyName) {
    return companyService.findByName(companyName);
  }

  public Product build() {
    Product product = new Product();
    product.setName(name);
    product.setDescription(description);
    product.setOrderPrice(orderPrice);
    product.setMargin(margin);
    product.setContainer(container);
    product.setCompany(company);
    product.setCount(count);
    product.setMinCount(minCount);

    resetBuilder();
    return product;
  }
}
