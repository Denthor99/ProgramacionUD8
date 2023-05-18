package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import javax.xml.transform.Result;
import java.sql.*;

public class Ejercicio12 {
    public static void main(String[] args) {
        /**
         * Enunciado ejercicio 12
         * Partiendo de la base de datos tienda, realiza una conexión y después imprime por
         * consola los siguientes metadatos:
         *  - Tablas de la base de datos tienda
         *  - Columnas de la tabla producto
         *  - Nombre de usuario que ha realizado la conexión
         *  - url de la conexión
         *  - Nombre y versión del driver utilizado, así como el nombre de SGBD
         * */

        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String url="jdbc:mariadb://localhost:3306/tienda";
            Connection con= DriverManager.getConnection(url,"den","root");
            Statement stmt= con.createStatement();
            DatabaseMetaData dMetaData= con.getMetaData();
            System.out.println("Conexión exitosa");
            System.out.println("Tablas de la base de datos Tienda");
            ResultSet tablas=dMetaData.getTables("tienda",null,null,null);
            while (tablas.next()){
                System.out.println("- "+tablas.getString("TABLE_NAME"));
            }
            System.out.println();
            System.out.println("Nombre de usuario que ha realizado la conexión");
            System.out.println("El usuario es: " + dMetaData.getUserName());
            System.out.println();
            System.out.println("Columnas de la tabla de datos");
            ResultSet columnas=dMetaData.getColumns("tienda",null,"producto",null);
            while (columnas.next()){
                System.out.println("- "+columnas.getString("COLUMN_NAME"));
            }
            System.out.println();
            System.out.println("\tURL de la conexión");
            System.out.println(dMetaData.getURL());
            System.out.println();
            System.out.println("Nombre y versión del driver utilizado, así como el nombre de SGBD");
            System.out.println(dMetaData.getDriverName());
            System.out.println(dMetaData.getDriverVersion());
            System.out.println(dMetaData.getDatabaseProductName());
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
