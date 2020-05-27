package com.example.demo.Repository;

import java.sql.*;
//Pure fabrication. Havde brug for en måde at få fat på et ID
public class IdRetriever {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/nordicmotorhome?serverTimezone=UTC";

    public static int retrieveID(String idName, String tableName){      //idName = name of id column    //tableName = name of the table we want id from
        String query = "SELECT " + idName + " FROM " + tableName + " ORDER BY " + idName + " DESC";

        try{
            Connection con = DriverManager.getConnection(DATABASE_URL, "user", "1234567890");

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            rs.next();
            int id = rs.getInt(idName) + 1; //returns the first (and highest) id + 1;

            rs.close();
            s.close();
            con.close();

            return id;
        }catch(SQLException e){
            System.err.println(e);
            return -1;
        }
    }
}
