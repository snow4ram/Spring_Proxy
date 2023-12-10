package proxydecember02.springproxy.tx;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TxController  {


    private final OuterService outerService;

    @GetMapping("/physical")
    public String physicalTx(@RequestParam(name = "title") String title){
        outerService.out(title);
        return "물리 트랜잭션 실행완료!!";
    }
}
