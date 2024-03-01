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
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    private boolean hasUsernameCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .anyMatch(cookie -> cookie.getName().equals("username"));
        }
        return false;
    }

    @RequestMapping("/home")
    public String getUsers(Model model, HttpServletRequest request) {
        List<User> userList = new ArrayList<>();

        // Kiểm tra xem có cookie "username" hay không
        if (hasUsernameCookie(request)) {
            Cookie[] cookies = request.getCookies();
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

    @RequestMapping("information")
    public String infor(Model model, HttpServletRequest request) {
    	if(hasUsernameCookie(request)) {
    		return "user/infor";
    	}else {
    		return "redirect:/login.htm";
    	}
        
    }
}
