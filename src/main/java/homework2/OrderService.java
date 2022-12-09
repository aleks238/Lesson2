package homework2;

import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class OrderService {
    private int counter = 1;

    public void createOrder(List<Product> cart) {
        double sum = 0;
        System.out.println("Заказ #" + counter + " создан");
        for (Product product : cart) {
            System.out.println(product.getTitle());
            sum += product.getPrice();
        }
        System.out.println("Общая сумма: " + sum);
        counter++;
    }
}
