package homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class CartApp {
    private Scanner scanner;
    private Cart cart;
    private OrderService orderService;

    @PostConstruct
    public void init() {
        scanner = new Scanner(System.in);
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void startCart() {
        while (true) {
            System.out.println("Введите команду: add id, delete id, confirm или close:");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "add":
                    Long idAdd = Long.valueOf(tokens[1]);
                    cart.addProductById(idAdd);
                    break;
                case "delete":
                    Long idDelete = Long.valueOf(tokens[1]);
                    cart.deleteProductById(idDelete);
                    break;
                case "confirm":
                    orderService.createOrder(cart.getCart());
                    cart.getCart().clear();
                    break;
            }
            if (input.equals("close")){
                scanner.close();
                System.out.println("Приложение CartApp закрыто");
                break;
            }
        }
    }
}
