package impl;

import interfaces.ProductRepository;
import obj.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class SimpleProductRepository implements ProductRepository {
    private List<Product> productBase;
    private Random rnd = new Random();

    public SimpleProductRepository() {
        this.productBase = new ArrayList<>();
    }
    @PostConstruct
    public void init() {
        for (int i = 1; i <= 5; i++) {
            productBase.add(new Product(i, "Product " + i, BigDecimal.valueOf(rnd.nextInt(10000)/10d)));
        }
    }
    @Override
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productBase);
    }

    @Override
    public Product getProduct(int id) {
        Product p = null;
        for (Product pp : productBase) {
            if (pp.getId() == id) p = pp;
        }
        return p;
    }
}
