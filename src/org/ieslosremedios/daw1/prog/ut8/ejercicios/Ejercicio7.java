package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;

public class Ejercicio7 {
    public static void main(String[] args) {
        /**
         * Enunciado del ejercicio:
         * Elimina de la base de datos el primer evento, pero antes haz una copia con otro id diferente. Realiza el borrado
         * utilizando el identificador.
         *
         * Después elimina el segundo utilizando JPQL. En este caso hazlo de dos formas nuevamente:
         * - Con una query estática
         * - Con una query dinámica
         * */
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("objectdb:$objectdb/db/eventos.odb");
        EntityManager em= emf.createEntityManager();

        //Copiamos el evento anterior y eliminamos el primero
        em.getTransaction().begin();
        EventoMusical primerEvento = em.find(EventoMusical.class,10);
        EventoMusical copiaEvento= new EventoMusical();
        copiaEvento.setNombreEvento(primerEvento.getNombreEvento());
        copiaEvento.setFecha((Timestamp) primerEvento.getFecha());
        copiaEvento.setRecaudacion(primerEvento.getRecaudacion());
        em.persist(copiaEvento);
        em.remove(primerEvento);
        em.getTransaction().commit();

        // Eliminacion el segundo evento usando JPQL
        em.getTransaction().begin();
        Query eliminaQuery = em.createQuery("DELETE FROM Eventos WHERE id=11");
        System.out.println("Registro eliminado: "+eliminaQuery.executeUpdate());
        em.getTransaction().commit();
    }
}
