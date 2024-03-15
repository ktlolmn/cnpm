package cnpm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

import cnpm.DBUtil.DBUtil;

public class AccountDAO {
	public boolean isValidAccount(String username, String password) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM Account WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                return BCrypt.checkpw(password, hashedPassword);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createAccount(String username, String password, String email) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Account (idAccount, idRole, username, password, email) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, generateRandomId(connection));
            preparedStatement.setString(2, generateRandomId(connection));
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, email);
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String generateRandomId(Connection connection) throws SQLException {
        String randomId;
        do {
            randomId = UUID.randomUUID().toString();
        } while (checkIdExist(connection, randomId));
        return randomId;
    }
    
    public boolean checkIdExist(Connection connection, String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM Account WHERE idAccount = ? OR idRole = ?");
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        return count > 0;
    }
    
    public String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder newPassword = new StringBuilder();
        Random rnd = new Random();
        while (newPassword.length() < 5) { 
            int index = (int) (rnd.nextFloat() * characters.length());
            newPassword.append(characters.charAt(index));
        }
               
        return newPassword.toString();
    }
    
    public boolean isOldPasswordCorrect(String username, String oldPassword) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM Account WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                return BCrypt.checkpw(oldPassword, hashedPassword);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePassword(String username, String newPassword) {
        try {
            Connection connection = DBUtil.getConnection();
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Account SET password = ? WHERE username = ?");
            preparedStatement.setString(1, hashedPassword);
            preparedStatement.setString(2, username);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
