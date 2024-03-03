package cnpm.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import cnpm.DAO.AccountDAO;
import cnpm.model.Account;

@Controller
public class LoginController {
	
	AccountDAO accountDAO = new AccountDAO();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(Model model, HttpServletResponse response) {
    	Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        model.addAttribute("user", new Account());
        return "login/login";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showLoginFormIndex(Model model, HttpServletResponse response) {
    	Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        model.addAttribute("user", new Account());
        return "login/login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@ModelAttribute("user") Account user, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        if (accountDAO.isValidAccount(user.getUsername(), user.getPassword())) {
            Cookie cookie = new Cookie("username", user.getUsername());
            cookie.setMaxAge(60*60);  //đặt thời gian cho cookies
            response.addCookie(cookie);
            return "redirect:/home.htm";
        } else {
            redirectAttributes.addFlashAttribute("error", "Tài khoản hoặc mật khẩu không đúng!");
            return "redirect:/login.htm";
        }
    }   
}

