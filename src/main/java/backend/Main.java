package backend;

import backend.controllers.*;
import backend.model.Album;
import backend.model.Artist;
import backend.model.Song;
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
        SongsController sc = new SongsController();
        AlbumsController ac = new AlbumsController();
        ArtistsController arc = new ArtistsController();

        try {
            System.out.println(cc.register("xx", "xxy", "oprea.nicusor619@yahoo.ro", "password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
