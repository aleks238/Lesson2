package homework2;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "bread", 1.00),
                new Product(2l, "cheese", 2.00),
                new Product(3l, "apples", 3.00),
                new Product(4l, "tomato", 4.00),
                new Product(5l, "potato", 5.00)
        ));
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductList() {
        return products;
    }
}
