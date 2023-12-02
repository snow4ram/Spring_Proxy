package proxydecember02.springproxy.noPorxy;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orders;

    @GetMapping("/api/search")
    public String search(@RequestParam(name = "itemId") String itemId) {

        Item search = orders.findByItemName(itemId);

        log.info("search = {}" , search);

        return "find Item = " + search ;

    }
}
