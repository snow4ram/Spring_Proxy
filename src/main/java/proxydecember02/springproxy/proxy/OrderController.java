package proxydecember02.springproxy.proxy;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Proxy;


@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orders;

    @GetMapping("/api/search")
    public String search(@RequestParam(name = "itemId") String itemId) {

        OrderProxy orderProxy = getOrderProxy();

        OrderService proxy = (OrderService) Proxy.newProxyInstance(orders.getClass().getClassLoader(), new Class[]{OrderService.class}, orderProxy);


        Item itemName = proxy.findItemName(itemId);

        log.info("itemName = {}" , itemName);

        return "find Item = " + itemName;

    }


    @PostMapping("/api/save")
    public String save(@RequestBody Item item) {

        OrderProxy orderProxy = getOrderProxy();

        OrderService proxy = (OrderService) Proxy.newProxyInstance(orders.getClass().getClassLoader(), new Class[]{OrderService.class}, orderProxy);

        proxy.itemSave(item);

        return "save!!";

    }

    private OrderProxy getOrderProxy() {
        return new OrderProxy(orders);
    }
}
