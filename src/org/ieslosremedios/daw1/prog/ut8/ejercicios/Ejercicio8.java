package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio8 {
    public static void main(String[] args) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String url="jdbc:mariadb://localhost:3306/tienda";
            Connection con = DriverManager.getConnection(url,"den","root");
            Statement stmt = con.createStatement();
            System.out.println("Conexión exitosa");
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("No ha podido conectarse a la BBDD");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
