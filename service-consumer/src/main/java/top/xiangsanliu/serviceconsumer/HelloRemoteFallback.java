package top.xiangsanliu.serviceconsumer;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteFallback implements HelloRemote {
    @Override
    public String hello(String name) {
        return "this is fallback";
    }
}
