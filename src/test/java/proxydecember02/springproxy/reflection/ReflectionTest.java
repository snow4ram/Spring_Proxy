package proxydecember02.springproxy.reflection;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


@Slf4j
class ReflectionTest {


    @Test
    @DisplayName("public Method 접근 테스트")
    public void reflection_method() throws Exception{

        Class<?> helloClass = Class.forName("proxydecember02.springproxy.reflection.Hello");

        Hello hello = new Hello();

        Method callA = helloClass.getMethod("callA");

        Object invoke = callA.invoke(hello);

        assertThat(hello.callA()).isEqualTo(invoke);
    }


    @Test
    @DisplayName("private Method 에 접근 테스트")
    public void reflection_method_Accessible()  throws Exception{

        Class<?> helloClass = Class.forName("proxydecember02.springproxy.reflection.Hello");

        Hello hello = new Hello();

        Method callC = helloClass.getDeclaredMethod("callC");

        callC.setAccessible(true);

        Object invoke = callC.invoke(hello);

        assertThat(invoke).isEqualTo("C");

    }



    @Test
    @DisplayName("Hello Class Fields 있는 모든 값에 접근")
    public void fieldAll() throws Exception{

        Class<?> helloClass = Class.forName("proxydecember02.springproxy.reflection.Hello");

        Hello hello = new Hello();
        Arrays.stream(helloClass.getDeclaredFields()).forEach(field -> {
            try {
                field.setAccessible(true);
                System.out.println(field.get(hello));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Test
    @DisplayName("특정 Fields 있는 값에 접근 ")
    public void oneField() throws Exception{

        Class<?> helloClass = Class.forName("proxydecember02.springproxy.reflection.Hello");

        Arrays.stream(new Field[]{helloClass.getDeclaredField("A")}).forEach(System.out::println);
    }




    @Test
    @DisplayName("생성자에 접근")
    public void constructors() throws Exception{

        Class<?> helloClass = Class.forName("proxydecember02.springproxy.reflection.Hello");

        Arrays.stream(helloClass.getConstructors()).forEach(System.out::println);
    }

}