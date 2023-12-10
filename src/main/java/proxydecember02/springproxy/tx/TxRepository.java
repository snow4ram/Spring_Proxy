package proxydecember02.springproxy.tx;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.Repository;


public interface TxRepository extends Repository<Post , Long> {

    void save(Post post);
}
