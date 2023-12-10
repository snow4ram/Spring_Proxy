package proxydecember02.springproxy.tx;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
@RequiredArgsConstructor
public class InnerService {

    private final TxRepository repository;

    public void interior(String title) {
        log.info("title = {}" , title);
        if (title.isBlank() || title.isEmpty()) {
            throw new RuntimeException("값이 없습니다.");
        }
        repository.save(new Post(title));

    }
}


