package proxydecember02.springproxy.ad;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Slf4j
@SpringBootTest
public class ProxyFactoryTest {

    @Autowired
    CallService service;


    @Autowired
    PlatformTransactionManager manager;


    @TestConfiguration
    static class BeanTestBox {
        @Bean
        CallService callService() {
            return new CallService();
        }
    }

    @Test
    public void beanClassTest() {
        service.internal();
    }


    @Test
    public void beanExternal() {
        service.external();
    }

    @Slf4j
    static class CallService {

        @Transactional
        public void external() {
            log.info("call external");
            printTxInfo();
        }

        @Transactional
        public void internal() {
            log.info("트랜잭셕 테스트");
            printTxInfo();
        }

        private void printTxInfo() {

            boolean tx = TransactionSynchronizationManager.isActualTransactionActive();

            String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();

            log.info("트랜잭션 적용 결과 = {} , 트랜잭션 이름 = {}" ,tx , currentTransactionName);
        }
    }


    @Test
    public void manager() {


        TransactionStatus transactionOut= manager.getTransaction(new DefaultTransactionDefinition());

        log.info("내부 트랜잭션");
        DefaultTransactionAttribute defaultTransactionDefinition = new DefaultTransactionAttribute();

        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

        TransactionStatus transaction = manager.getTransaction(defaultTransactionDefinition);

        log.info("트랜잭션 예외시 롤백 후 새롭게 생성 = {}" , transaction.isNewTransaction());

        manager.rollback(transaction);

        log.info("외부 트랜잭션 = {}" , transactionOut);
        manager.commit(transactionOut);

    }

}
