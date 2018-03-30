package xxxxxx.yyyyyy.zzzzzz.app.login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import xxxxxx.yyyyyy.zzzzzz.app.main.UserForm;
import xxxxxx.yyyyyy.zzzzzz.domain.model.User;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserServiceImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


@Controller
public class RegistrationController {
PasswordEncoder passwordEncoder;
    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/projectName-env.xml");


    @RequestMapping(value = "register", params = "confirm", method = RequestMethod.POST)
    public String register(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("pass") String password, @RequestParam("pass-repeat") String passwordRepeat,  Model model) throws SQLException, NoSuchAlgorithmException {
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        if(!password.equals(passwordRepeat)){
            model.addAttribute("error", "hasła nie są takie same");
            return "../../register";
        }else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            userService.addUser(user);
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("user", userForm);
        return "../../register";
    }

    public static String getMD5(String data) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest=MessageDigest.getInstance("MD5");

        messageDigest.update(data.getBytes());
        byte[] digest=messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }
}
