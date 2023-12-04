package proxydecember02.springproxy.reflection;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@NoArgsConstructor
public class Hello {


    private String A = "Field A";

    public String B = "Field B";

    protected String C = "Field C";

    public Hello(String a, String b, String c) {
        A = a;
        B = b;
        C = c;
    }

    public String callA() {
        log.info("Hello Method A");
        return "A";
    }

    public static String callB() {
        log.info("Static Method B");
        return "B";
    }

    private String callC() {
        log.info("private Method C");
        return "C";
    }

}
