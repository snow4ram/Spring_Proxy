package proxydecember02.springproxy.ad;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Slf4j
@SpringBootTest
public class ThreadLocalNameTest {

    @Autowired
    PlatformTransactionManager manager;

    ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public void internal() {


        TransactionStatus transaction = manager.getTransaction(new DefaultTransactionDefinition());

        Connection connection = threadLocal.get();

        manager.commit((TransactionStatus) connection);


    }

    @Test
    public void getThreadLocalName() throws SQLException {
        

        String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

        String user = "sa";

        String password = "";

        Connection connection = DriverManager.getConnection(url, user, password);

        threadLocal.set(connection);

        internal();

        log.info("트랜잭션 정보 = {}", threadLocal.get());
    }

}
