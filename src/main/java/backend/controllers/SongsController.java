package backend.controllers;

import backend.database.Database;
import backend.model.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongsController {
    public String getTitle(int id){
        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select title from songs where song_id = " + id)) {
            if(rs.next())
                return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Song getSongById(int id){
        ArtistsController ac = new ArtistsController();
        AlbumsController alc = new AlbumsController();

        Connection con = Database.getConnection();

        Song song = new Song();

        song.setId(id);
        song.setTitle(getTitle(id));

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select artist_id from sangby where song_id = " + id)) {
            if(rs.next())
                song.setArtistId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        song.setArtistName(ac.getName(song.getArtistId()));

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select album_id from containre where song_id = " + id)) {
            if(rs.next())
                song.setAlbumId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        song.setAlbumName(alc.getTitle(song.getAlbumId()));


        return song;
    }
}
