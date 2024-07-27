package com.sparta.springprepare.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ResponseBody와 Controller를 합친 것. 이제 ResponseBody를 안붙여도 된다.
@RequestMapping("/response/rest")
public class ResponseRestController {

    @GetMapping("/json/hello")
    public String helloStringJson() {
        return "{\"message\":\"Hello World\"}";
    }

    @GetMapping("/json/class")
    public Star starClassJson() {
        return new Star("kyeonkim", 95);
    }
}
