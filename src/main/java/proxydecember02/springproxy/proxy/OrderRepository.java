package proxydecember02.springproxy.proxy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<Item , Long> {

    Optional<Item> findByItemName(String itemId);

}
