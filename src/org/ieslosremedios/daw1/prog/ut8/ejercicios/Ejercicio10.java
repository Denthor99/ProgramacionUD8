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
            String query1="INSERT INTO tienda.producto VALUES(1,'Piña','Colada','1','España')";
            stmt.executeQuery(query1);
            String query2="INSERT INTO tienda.producto VALUES(2,'Platano','Canario','50','España')";
            stmt.executeQuery(query2);
            String query3="INSERT INTO tienda.producto VALUES(3,'Tomate','Venezolano','40','Portugal')";
            stmt.executeQuery(query3);

            String productos="SELECT * FROM tienda.producto ORDER BY id";
            ResultSet resultado= stmt.executeQuery(productos);
            while(resultado.next()){
                System.out.println("Producto Num "+resultado.getInt("id")+": "+resultado.getString("nombre"));
            }
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
