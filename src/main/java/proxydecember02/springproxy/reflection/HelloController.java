package proxydecember02.springproxy.reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class HelloController {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Class<?> route = Class.forName("proxydecember02.springproxy.reflection.Hello");

        Hello hello = new Hello();


        Method callA = route.getMethod("callA");

        Method callB = route.getDeclaredMethod("callB");
        Method callC = route.getDeclaredMethod("callC");

        callC.setAccessible(true);

        Object invokeA = callC.invoke(hello);


        log.info("call invokeA  = {} ", invokeA);




    }
}
