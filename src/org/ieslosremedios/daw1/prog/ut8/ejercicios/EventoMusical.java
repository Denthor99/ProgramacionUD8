package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.*;
@NamedQuery(name = "borrarEventos",query = "DELTE FROM Eventos WHERE id = ?1")
@Entity (name="Eventos")
public class EventoMusical {
    /*
    @Id
    private IdNombreApellidos id;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaPersonal")
    @SequenceGenerator(initialValue = 10, allocationSize = 10,name = "secuenciaPersonal")
    private Integer id;
    private String nombreEvento;
    private Timestamp fecha;
    private BigDecimal recaudacion;
    @Enumerated(EnumType.ORDINAL)
    private GenerosMusicales generos;
    private List <Artista> artistasConfirmados;
    @Transient
    private Integer control;

    public EventoMusical(String nombreEvento, Timestamp fecha, BigDecimal recaudacion){
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this. recaudacion = recaudacion;
    }

    public EventoMusical(){

    }


    //¿Para que sirven los tipos...?
    //Date: Almacena una fecha, por ejemplo "27/04/2023"
    //Time: Almacena la hora, por ejemplo "12:00".
    //Timestamp: Almacena la fecha y la hora, por ejemplo "27/04/2023 12:00".
    //Calendar:



    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(BigDecimal recaudacion) {
        this.recaudacion = recaudacion;
    }

    @Override
    public String toString() {
        return "Evento" + '\n' +
                "Nombre: " + nombreEvento + '\n' +
                "Fecha del evento: " + fecha + '\n' +
                "Recaudación: " + recaudacion +
                '}';
    }
}
