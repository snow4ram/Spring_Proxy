package proxydecember02.springproxy;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import proxydecember02.springproxy.proxy.Item;
import proxydecember02.springproxy.proxy.OrderRepository;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final OrderRepository orderRepository;


    @PostConstruct
    public void init() {
        orderRepository.save(new Item("itemA", 1000));
        orderRepository.save(new Item("itemB", 2000));
        orderRepository.save(new Item("itemC", 3000));
    }
}
