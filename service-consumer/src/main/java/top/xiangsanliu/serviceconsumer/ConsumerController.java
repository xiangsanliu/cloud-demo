package top.xiangsanliu.serviceconsumer;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ConsumerController {

    @Resource
    private HelloRemote helloRemote;

    @RequestMapping("/username")
    public String cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", "xiang");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
        return "username changed";
    }

    @GetMapping("/")
    public String readCookie(@CookieValue(value = "username", defaultValue = "Default") String username) {
        return "Hey! My username is " + username;
    }

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }

}
