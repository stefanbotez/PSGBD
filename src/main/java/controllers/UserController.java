package controllers;

import database.Database;
import model.User;

import java.sql.*;

public class UserController {

    public User findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select first_name, last_name from users where user_id=" + id)) {
            return rs.next() ? new User(id, rs.getString(1), rs.getString(2)) : null;
        }
    }

    public User findByIdProcedure(int id) throws SQLException {
        Connection con = Database.getConnection();

        String f_name;
        String l_name;

        String command = "{call GETUSERBYID(?,?,?)}";
        CallableStatement cstmt = con.prepareCall(command);
        cstmt.setInt(1, id);
        cstmt.registerOutParameter(2, Types.VARCHAR);
        cstmt.registerOutParameter(3, Types.VARCHAR);
        cstmt.execute();

        f_name = cstmt.getString(2);
        l_name = cstmt.getString(3);

        return new User(id, f_name, l_name);
    }


}
