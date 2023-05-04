package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Ejercicio6 {
    public static void main(String[] args) {
        /**
         * Cámbiale el nombre al primer evento para ponerlo en mayúsculas utilizando el identificador.
         * Cambia ahora el nombre al segundo evento para ponerlo también en mayusculas, pero ahora utilizando
         * JPQL. En este caso hazlo de dos formas nuevamente:
         *  - Con una querry estática
         *  - Con una querry dinámica
         * */
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("objectdb:$objectdb/db/eventos.odb");
        EntityManager em= emf.createEntityManager();

        // Iniciamos la transaccion
        em.getTransaction().begin();

        // Modificamos el nombre del primer evento
        EventoMusical euroUpdate = em.find(EventoMusical.class,10);
        euroUpdate.setNombreEvento(euroUpdate.getNombreEvento().toUpperCase());

        // Finalizamos la transacción
        em.getTransaction().commit();

        // Inicializamos la transaccion
        em.getTransaction().begin();
        Query updateEvento= em.createQuery("UPDATE Eventos ev SET ev.nombreEvento = UPPER(ev.nombreEvento) WHERE ev.id=11");
        System.out.println("Registro actualizado: "+updateEvento.executeUpdate());

        // Finalizamos la transaccion
        em.getTransaction().commit();

    }
}
