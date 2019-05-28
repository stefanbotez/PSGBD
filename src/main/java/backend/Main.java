package backend;

import backend.controllers.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main{
    public static void main(String[] args) {
        UserController uc = new UserController();
        CredentialsController cc = new CredentialsController();
        ListenedController lc = new ListenedController();
        ContainsController coc = new ContainsController();
        CategorizedController cac = new CategorizedController();
        SangByController sbc = new SangByController();
        try {
            System.out.println(uc.recommend(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
