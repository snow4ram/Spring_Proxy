package proxydecember02.springproxy.proxy;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void itemSave(Item item) {

        if (item.getItemName().trim().length() < 0 || item.getItemName().isBlank()) {
            throw new IllegalArgumentException("값을 입력해주세요");
        }

        orderRepository.save(item);
    }

    @Override
    @Transactional
    public void itemUpdate(ItemRe itemRe) {
        Item item = orderRepository.findById(itemRe.getFindItemId()).orElseThrow();

        item.itemUpdate(itemRe);

    }
}