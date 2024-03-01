package cnpm.model;

import java.sql.Timestamp;

public class User {
    private int idAccount;
    private int idRole;
    private String username;
    private String email;
    private String password;
    private Timestamp _Create;
    private Timestamp _Update;

    public User( int idAccount, int idRole, String username, String email, String password, Timestamp _Create, Timestamp _Update) {
        super();
        this.idAccount = idAccount;
        this.idRole = idRole;
        this.username = username;
        this.email = email;
        this.password = password;
        this._Create = _Create;
        this._Update = _Update;
    }

    public User() {
        super();
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp get_Create() {
        return _Create;
    }

    public void set_Create(Timestamp _Create) {
        this._Create = _Create;
    }

    public Timestamp get_Update() {
        return _Update;
    }

    public void set_Update(Timestamp _Update) {
        this._Update = _Update;
    }
}
