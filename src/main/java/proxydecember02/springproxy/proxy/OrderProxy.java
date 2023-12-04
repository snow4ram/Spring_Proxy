package proxydecember02.springproxy.proxy;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class OrderProxy implements InvocationHandler {

    private final Object object;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long searchStartTime = System.currentTimeMillis();

        log.info("검색 시작 시간 = {}", searchStartTime);

        Object result = method.invoke(object, args);


        long searchTimeOut = System.currentTimeMillis();

        long resultTimeOut = searchTimeOut - searchStartTime;

        log.info("검색 종료 시간 = {}", resultTimeOut);


        return result;
    }
}
