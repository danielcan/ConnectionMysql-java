/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.*;//libreria driverManager

/**
 *
 * @author PC LIFE
 */
public class Conexion {

    private final String base = "tienda";
    private final String user = "root";
    private final String password = "1234";
    private final String url = "jdbc:mysql://127.0.0.1:3306/" + base + "?useSSL=false";
    private Connection con = null;

    public Connection getConexion() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return con;
    }

}
