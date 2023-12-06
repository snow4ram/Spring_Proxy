package proxydecember02.springproxy.proxy;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Proxy;


@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orders;

    //Advice find
    @GetMapping("/api/search")
    public String search(@RequestParam(name = "itemId") String itemId) {

        ProxyFactory proxyFactory = new ProxyFactory(orders);

        proxyFactory.addAdvice(new OrderInvocationHandlerProxy());


        OrderService proxy = (OrderService) proxyFactory.getProxy();


        Item itemName = proxy.findItemName(itemId);

        log.info("itemName = {}" , itemName);

        return "find Item = " + itemName;

    }


    //Advisor find
    @GetMapping("/api/search/advisors")
    public String searchAdvisors(@RequestParam(name = "itemId") String itemId) {

        ProxyFactory proxyFactoryAdvisors = new ProxyFactory(orders);

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new OrderInvocationHandlerProxy());

        proxyFactoryAdvisors.addAdvisor(defaultPointcutAdvisor);

        OrderService orderService = (OrderService) proxyFactoryAdvisors.getProxy();

        Item itemName = orderService.findItemName(itemId);

        log.info("itemName = {}" , itemName);

        return "find Item = " + itemName;

    }




    @PostMapping("/api/save")
    public String save(@RequestBody  Item item) {

        ProxyFactory proxyFactory = new ProxyFactory(orders);

        proxyFactory.addAdvice(new OrderInvocationHandlerProxy());

        OrderService proxy = (OrderService) proxyFactory.getProxy();

        proxy.itemSave(item);

        return "save!!";

    }

}
