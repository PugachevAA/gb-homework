package interfaces;

import obj.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProduct(int id);
}
