package xxxxxx.yyyyyy.zzzzzz.app.login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {
    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/projectName-env.xml");

    @RequestMapping(value = "login", params = "submit", method = RequestMethod.POST)
    public String loginCheck(WebRequest request, Model model, @RequestParam("login") String login, @RequestParam("pass") String pass){
        return "../../login";
    }

    @RequestMapping(value = "login")
    public String login(WebRequest request, Model model){
        return "../../login";
    }

}