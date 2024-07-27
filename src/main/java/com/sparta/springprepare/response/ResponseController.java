package com.sparta.springprepare.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {

    @GetMapping("/json/hello")
    @ResponseBody
    public String helloStringJson() {
        return "{\"message\":\"Hello World\"}";
    }

    @GetMapping("/json/class")
    @ResponseBody
    public Star starClassJson() {
        return new Star("kyeonkim", 95);
    }
}
