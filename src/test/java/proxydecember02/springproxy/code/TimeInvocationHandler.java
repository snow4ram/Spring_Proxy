package proxydecember02.springproxy.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {


    private Object object;

    public TimeInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = method.invoke(object, args);


        long endTime = System.currentTimeMillis();

        long resultTime = startTime - endTime;

        log.info("최종결과 시간 = {}", resultTime);

        return result;
    }
}
