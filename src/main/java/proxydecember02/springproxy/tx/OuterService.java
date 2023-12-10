package proxydecember02.springproxy.tx;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OuterService {

    private final InnerService innerService;


    public void out(String title) {
        log.info("외부 트랜잭션 실행");
        try {
            innerService.interior(title);
        } catch (Exception e) {
            log.error("내부 예외 = {}" , e.getMessage());
        }
    }


}
