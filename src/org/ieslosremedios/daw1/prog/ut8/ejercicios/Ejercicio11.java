package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import java.sql.*;

public class Ejercicio11 {
    public static void main(String[] args) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String url="jdbc:mariadb://localhost:3306/tienda";
            Connection con= DriverManager.getConnection(url,"den","root");
            Statement stmt = con.createStatement();
            System.out.println("Conexión exitosa");
            Boolean consulta=stmt.execute("SELECT * FROM producto WHERE pais='España'");
            if (consulta){
                ResultSet consul= stmt.getResultSet();
                while (consul.next()){
                    System.out.println(consul.getString("nombre"));
                }
            }
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
