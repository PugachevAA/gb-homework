package interfaces;

import obj.Product;

import java.util.List;

public interface Cart {
    void addProduct(int id, int count);
    void deleteProduct(int id);
    List<Product> cartList();
    Product getProduct(int id);
}
