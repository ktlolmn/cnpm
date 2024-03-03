package cnpm.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cnpm.DAO.AccountDAO;
import cnpm.model.Account;

@Controller
public class ChangePasswordController {
    AccountDAO accountDAO = new AccountDAO();

    @RequestMapping(value = "change-password", method = RequestMethod.GET)
    public String changerPasswordForm(Model model) {
        return "login/change-password";
    }

    @RequestMapping(value = "change-password", method = RequestMethod.POST)
    public String changerPassword(@ModelAttribute("user") Account user,
                                  @RequestParam("username") String username,
                                  @RequestParam("oPassword") String oldPassword,
                                  @RequestParam("new-password") String newPassword,
                                  @RequestParam("confirm-password") String confirmPassword,
                                  RedirectAttributes redirectAttributes) {
        if (!accountDAO.isOldPasswordCorrect(username, oldPassword)) {
            redirectAttributes.addFlashAttribute("error", "Mật khẩu cũ không đúng.");
            return "redirect:/change-password.htm";
        }

        if (accountDAO.changePassword(username, newPassword)) {
            redirectAttributes.addFlashAttribute("success", "Đổi mật khẩu thành công.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi. Vui lòng thử lại sau.");
        }

        return "redirect:/change-password.htm";
    }
}