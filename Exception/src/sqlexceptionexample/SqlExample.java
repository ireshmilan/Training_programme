/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlexceptionexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Iresh
 */
public class SqlExample {

    private Connection con;
    private Statement st;

    public void example() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bs", "root", "");
            st = con.createStatement();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage()+" invalid path");

        }
    }
    public static void main(String[] args) {
        SqlExample sql =new SqlExample();
        sql.example();
        
    }
}
