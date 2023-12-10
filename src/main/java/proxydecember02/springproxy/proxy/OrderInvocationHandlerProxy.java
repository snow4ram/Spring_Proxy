package proxydecember02.springproxy.proxy;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OrderInvocationHandlerProxy implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        long searchStartTime = System.currentTimeMillis();

        log.info("검색 시작 시간 = {}", searchStartTime);

        Object result = invocation.proceed();

        long searchTimeOut = System.currentTimeMillis();

        long resultTimeOut = searchTimeOut - searchStartTime;

        log.info("검색 종료 시간 = {}", resultTimeOut);
        return result;
    }



}
