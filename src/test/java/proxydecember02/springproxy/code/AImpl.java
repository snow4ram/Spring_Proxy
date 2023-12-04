package proxydecember02.springproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface{
    @Override
    public String callA() {
        log.info("AImpl 호출");
        return "a";
    }
}
