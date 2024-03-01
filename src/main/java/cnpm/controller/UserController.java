package cnpm.controller;
import cnpm.model.User;
import cnpm.DBUtil.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/home")
    public String getUsers(Model model, HttpServletRequest request) {
        List<User> userList = new ArrayList<>();
        
        // Kiểm tra xem có cookie "username" hay không
        Cookie[] cookies = request.getCookies();
        boolean hasCookie = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    hasCookie = true;
                    break;
                }
            }
        }
        
        if (hasCookie) {
            // Lấy thông tin username từ cookie
            String username = "";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
            model.addAttribute("username", username); // Thêm thông tin username vào model

            try {
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    User user = new User();
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            model.addAttribute("users", userList);
            return "user/home";
        } else {
            // Nếu không có cookie "username", chuyển hướng đến trang login
            return "redirect:/login.htm";
        }
    }
}
