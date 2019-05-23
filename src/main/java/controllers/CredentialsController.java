package controllers;

import database.Database;
import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CredentialsController {

    public boolean login(String email, String password) throws SQLException {
        Connection con = Database.getConnection();

        String f_name;
        String l_name;

        String command = "{? = call USER_EXISTS(?,?)}";
        CallableStatement cstmt = con.prepareCall(command);

        cstmt.setString(2, email);
        cstmt.setString(3, password);
        cstmt.registerOutParameter(1, Types.NUMERIC);


        cstmt.executeUpdate();

        int result = cstmt.getInt(1);
        return result==1?true:false;
    }
}
