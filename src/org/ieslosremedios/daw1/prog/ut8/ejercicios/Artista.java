package org.ieslosremedios.daw1.prog.ut8.ejercicios;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class Artista implements Serializable {
    private String nombre;
    private int edad;

    public Artista() {
    }

    public Artista(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "Nombre: '" + nombre + '\'' +
                ", Edad: " + edad +
                '}';
    }
}
