package cnpm.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cnpm.DAO.AccountDAO;

@Controller
public class ForgotPasswordController {
	
	AccountDAO accountDAO = new AccountDAO();
    
    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public String showForgotPasswordForm() {
        return "login/forgot-password";
    }
    
    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public String processForgotPasswordForm(@RequestParam("username") String username, Model model) {
        String newPassword = accountDAO.generateRandomPassword();
        
        if (accountDAO.changePassword(username, newPassword)) {
            model.addAttribute("password", newPassword);
            model.addAttribute("message", "Mật khẩu mới của bạn là: ");
        } else {
            model.addAttribute("message", "Không thể cập nhật mật khẩu. Vui lòng thử lại sau.");
        }
        
        return "login/forgot-password";
    }
    
}
