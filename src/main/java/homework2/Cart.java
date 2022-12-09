package homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> cart;
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        cart = new ArrayList<>();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductById(Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            cart.add(product);
        } else {
            System.out.println("Продукт с таким id отсутствует");
        }
    }

    public void deleteProductById(Long id) {
        Optional<Product> optional = cart.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (optional.isPresent()) {
            Product product = optional.get();
            cart.remove(product);
        } else {
            System.out.println("Продукт с таким id отсутствует в корзине");
        }
    }

    public List<Product> getCart() {
        return cart;
    }
}
