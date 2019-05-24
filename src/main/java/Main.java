import controllers.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserController uc = new UserController();
        CredentialsController cc = new CredentialsController();
        ListenedController lc = new ListenedController();
        ContainsController coc = new ContainsController();
        CategorizedController cac = new CategorizedController();
        SangByController sbc = new SangByController();
        System.out.println(lc.getSongFreqForUser(1,5070));

    }
}
