package proxydecember02.springproxy.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {


    @Test
    public void dynamicA() {

        AInterface target = new AImpl();

        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{AInterface.class}, handler);

        proxy.callA();

        log.info("target = {}" , target.getClass());

        log.info("proxy = {}" , proxy.getClass());
    }

    @Test
    public void dynamicB() {

        BInterface target = new BImpl();

        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        BInterface proxy = (BInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{BInterface.class}, handler);

        proxy.callB();

        log.info("target = {}" , target.getClass());

        log.info("proxy = {}" , proxy.getClass());
    }
}
