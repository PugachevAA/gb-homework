package config;

import impl.Cart;
import impl.SimpleProductRepository;
import interfaces.ProductRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "java")
public class Config {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProductRepository productRepository() {
        return new SimpleProductRepository();
    }
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Cart cart() {
        return new Cart();
    }
}
