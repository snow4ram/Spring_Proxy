package proxydecember02.springproxy.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        long startTime = System.currentTimeMillis();

        log.info("시작 시간 = {}", startTime);

        Object result = invocation.proceed();

        long endTime = System.currentTimeMillis();

        long resultTime = startTime - endTime;

        log.info("최종결과 시간 = {}", resultTime);


        return result;
    }
}
