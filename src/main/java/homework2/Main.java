package homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CartApp cartApp = context.getBean(CartApp.class);
        cartApp.startCart();
        context.close();
    }

}
