package proxydecember02.springproxy.proxy;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderProxy orders;

    @GetMapping("/api/search")
    public String search(@RequestParam(name = "itemId") String itemId) {

        Item search = orders.findItemName(itemId);

        log.info("search = {}" , search);

        return "find Item = " + search ;

    }
}
