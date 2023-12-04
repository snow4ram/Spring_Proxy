package proxydecember02.springproxy.proxy;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public Item findItemName(String itemId) {

        return orderRepository.findByItemName(itemId).orElseThrow();

    }

    @Override
    public void itemSave(Item item) {
        orderRepository.save(item);
    }


}