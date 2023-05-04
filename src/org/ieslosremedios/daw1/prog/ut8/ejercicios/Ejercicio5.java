package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import javax.persistence.*;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {

        /**
         * Enunciado del ejercicio:
         * Imprime el primer evento que insertaste en el ejercicio anterior, utilizando el identificador
         * Imprimer el segundo evento utilizando JPQL. En este caso hazlo de dos formas:
         *  - Con una query estática
         *  - Con una querry dinámica
         * */
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("objectdb:$objectdb/db/eventos.odb");
        EntityManager em= emf.createEntityManager();

        // Recuperación (lectura) sin usar JPQL
        EventoMusical evento=em.find(EventoMusical.class,10);
        System.out.println("Nombre del Evento: "+evento.getNombreEvento());
        System.out.println("Fecha del Evento: " + evento.getFecha());
        System.out.println("Recaudación del Evento: "+evento.getRecaudacion());

        // Recuperar usando JPQL (estatica)
        TypedQuery<EventoMusical> query= em.createNamedQuery("verEventos", EventoMusical.class);
        query.setParameter(1,11);
        EventoMusical preuba1=query.getSingleResult();
        System.out.println(preuba1);

        // Recuperar usando JPQL (dinamica)
        Query querryDinamica= em.createQuery("SELECT ev FROM Eventos ev WHERE id = ?1");
        querryDinamica.setParameter(1,10);
        EventoMusical prueba2=(EventoMusical) querryDinamica.getSingleResult();
        System.out.println(prueba2);

    }
}
