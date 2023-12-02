package proxydecember02.springproxy.noPorxy;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public Item findByItemName(String itemId) {


        try {

            long searchStartTime = System.currentTimeMillis();

            log.info("검색 시작 시간 = {}", searchStartTime);

            Item item = orderRepository.findByItemName(itemId).orElseThrow();

            long searchTimeOut = System.currentTimeMillis();

            log.info("검색 종료 시간 = {}", searchTimeOut);


            return item;

        } catch (Exception e) {
            throw new IllegalArgumentException("정보가 없습니다.");
        }

    }
}