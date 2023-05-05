package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import javax.persistence.*;

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
        if (euroUpdate!=null) {
            euroUpdate.setNombreEvento(euroUpdate.getNombreEvento().toUpperCase());
        } else{
            System.out.println("Indice no encontrado");
        }

        // Finalizamos la transacción
        em.getTransaction().commit();

        // Inicializamos la transacción (JPQL estático)
        em.getTransaction().begin();
        TypedQuery<EventoMusical> evenTyper=em.createNamedQuery("updateEventos", EventoMusical.class);
        evenTyper.setParameter(1,11);

        em.getTransaction().commit();

        // Inicializamos la transaccion (JPQL Dinámico)
        em.getTransaction().begin();
        Query updateEvento= em.createQuery("UPDATE Eventos ev SET ev.nombreEvento = LOWER(ev.nombreEvento) WHERE ev.id=11");
        System.out.println("Registro actualizado: "+updateEvento.executeUpdate());

        // Finalizamos la transaccion
        em.getTransaction().commit();

    }
}
