import controllers.CredentialsController;
import controllers.UserController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserController uc = new UserController();
        CredentialsController cc = new CredentialsController();
        try {
            System.out.println(cc.login("citea.aurelian642@gmail.ro", "password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
