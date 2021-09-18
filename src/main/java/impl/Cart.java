package impl;

import interfaces.ProductRepository;
import obj.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Cart implements interfaces.Cart {
    private List<Product> cartList;

    @Autowired
    private ProductRepository pr;

    public Cart() {
        this.cartList = new ArrayList<>();;
    }

    @Override
    public void addProduct(int id, int count) {
        do {
            cartList.add(pr.getProduct(id));
            count = count - 1;
        } while (count > 0);
    }

    @Override
    public void deleteProduct(int id) {
        for (Product p : cartList) {
            if (p.getId() == id) cartList.remove(p);
            return;
        }
    }

    @Override
    public List<Product> cartList() {
        return Collections.unmodifiableList(cartList);
    }

    @Override
    public Product getProduct(int id) {
        Product p = null;
        for (Product pp : cartList) {
            if (pp.getId() == id) p = pp;
        }
        return p;
    }
}
