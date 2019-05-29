package backend.controllers;

import backend.database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchController {
    public List<Integer> searchSongs(String query){
        List<Integer> songs = new ArrayList<>();
        Connection con = Database.getConnection();
        String q = "select song_id from songs where title like ?";
        try
        {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, "%" + query + "%");

            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                songs.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return songs;
    }

    public List<Integer> searchArtist(String query){
        List<Integer> artists = new ArrayList<>();
        Connection con = Database.getConnection();
        String q = "select artist_id from artists where name like ?";
        try
        {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, "%" + query + "%");

            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                artists.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return artists;
    }

    public List<Integer> searchAlbums(String query){
        List<Integer> albums = new ArrayList<>();
        Connection con = Database.getConnection();
        String q = "select album_id from albums where title like ?";
        try
        {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, "%" + query + "%");

            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                albums.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return albums;
    }

    public List<Integer> searchUsers(String query){
        List<Integer> users = new ArrayList<>();
        Connection con = Database.getConnection();
        String q = "select user_id from users where first_name || ' ' || last_name like ?";
        try
        {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, "%" + query + "%");

            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                users.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return users;
    }




}
