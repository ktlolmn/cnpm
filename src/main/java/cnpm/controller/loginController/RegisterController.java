package cnpm.controller.loginController;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cnpm.DAO.AccountDAO;
import cnpm.model.Account;

@Controller
public class RegisterController {
	AccountDAO accountDAO = new AccountDAO();
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new Account());
        return "login/register";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") Account user, RedirectAttributes redirectAttributes) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        if (accountDAO.createAccount(user.getUsername(), hashedPassword, user.getEmail())) {
            return "redirect:/login.htm";
        } else {
            redirectAttributes.addFlashAttribute("error", "Tên tài khoản đã tồn tại");
            return "redirect:/register.htm";
        }
    }

}
