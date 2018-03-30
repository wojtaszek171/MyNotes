package xxxxxx.yyyyyy.zzzzzz.app.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainController {


    @RequestMapping(value = "")
    public String displayMain() {
        // reset password
        return "main/main";
    }

}
