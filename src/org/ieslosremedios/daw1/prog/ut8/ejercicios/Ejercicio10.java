package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import java.sql.*;

public class Ejercicio10 {
    public static void main(String[] args) {
    /**
     * Escribe un programa que realice las siguientes operaciones en la bbdd tienda:
     * Borra todos los registros que tuviera la tabla productos.
     * Inserta 3 nuevos registros: (especificados en las transparencias)
     * Modifica el precio de la pera a 20 céntimos.
     * */
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url="jdbc:mariadb://localhost:3306/tienda";
            Connection con = DriverManager.getConnection(url,"den","root");
            Statement stmt = con.createStatement();
            System.out.println("Conexión exitosa");
            // Insertamos tres registros
            String delQuery="DELETE FROM producto";
            System.out.println("Se han eliminado "+stmt.executeUpdate(delQuery)+" filas");
            String insertQuery="INSERT INTO tienda.producto VALUES(1,'manzana','Manzanas golden','50','Francia'),(2,'pera','Peras conferencia','25','España'),(3,'uva','Uvas gourmet','20','España')";
            System.out.println("Se han añadido "+ stmt.executeUpdate(insertQuery)+" filas");
            String updateQuery="UPDATE producto SET precio=20 WHERE id=2";
            System.out.println("Se ha actualizado "+ stmt.executeUpdate(updateQuery)+" filas");

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
