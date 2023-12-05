package proxydecember02.springproxy.proxy;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Proxy;


@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orders;

    @GetMapping("/api/search")
    public String search(@RequestParam(name = "itemId") String itemId) {

        ProxyFactory proxyFactory = new ProxyFactory(orders);

        OrderService proxy = (OrderService) proxyFactory.getProxy();

        Item itemName = proxy.findItemName(itemId);

        log.info("itemName = {}" , itemName);

        return "find Item = " + itemName;

    }




    @PostMapping("/api/save")
    public String save(@RequestBody  Item item) {

        ProxyFactory proxyFactory = new ProxyFactory(orders);

        OrderService proxy = (OrderService) proxyFactory.getProxy();

        proxy.itemSave(item);

        return "save!!";

    }

}
