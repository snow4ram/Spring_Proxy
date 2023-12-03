package proxydecember02.springproxy.proxy;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProxy {

    private final OrderService orders;

    public Item findItemName(String itemId) {
        try {

            long searchStartTime = System.currentTimeMillis();

            log.info("검색 시작 시간 = {}", searchStartTime);

            Item byItemName = orders.findItemName(itemId);

            long searchTimeOut = System.currentTimeMillis();

            log.info("검색 종료 시간 = {}", searchTimeOut);


            return byItemName;

        } catch (Exception e) {
            throw new IllegalArgumentException("정보가 없습니다.");
        }

    }
}
