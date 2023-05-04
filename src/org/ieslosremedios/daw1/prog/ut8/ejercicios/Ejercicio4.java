package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Ejercicio4 {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("objectdb:$objectdb/db/eventos.odb");
        EntityManager em= emf.createEntityManager();

        // iniciar transacción
        em.getTransaction().begin();

        // Operaciones
        EventoMusical eurovision=new EventoMusical();
        eurovision.setNombreEvento("Eurovision 2022");
        BigDecimal e1=new BigDecimal(95050515803.00);
        eurovision.setRecaudacion(e1);
        eurovision.setFecha(Timestamp.valueOf("2022-04-20 18:00:00"));

        BigDecimal dis=new BigDecimal(1500000.00);
        EventoMusical discotec=new EventoMusical("Party At The Night:DnB",Timestamp.valueOf("2021-12-25 01:30:00"),dis);

        em.persist(eurovision);
        em.persist(discotec);

        // Finalizamos transaccion
        em.getTransaction().commit();

        // Cerramos conexión
        em.close();
        emf.close();

    }
}