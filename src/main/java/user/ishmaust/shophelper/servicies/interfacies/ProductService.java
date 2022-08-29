package user.ishmaust.shophelper.servicies.interfacies;

import java.util.List;
import java.util.Set;
import user.ishmaust.shophelper.dto.ProductDto;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;

public interface ProductService extends EntityOperationService<Product> {

  List<Product> getAllProduct();

  List<Product> getProductsByName(String name);

  Product addNewProduct(ProductDto product);

  Product updateProduct(ProductDto product, Long id);

  Product deleteProduct(Long id);
}
