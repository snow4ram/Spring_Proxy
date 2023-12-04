package proxydecember02.springproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface{
    @Override
    public String callB() {
        log.info("BImpl 호출");
        return "b";
    }
}
