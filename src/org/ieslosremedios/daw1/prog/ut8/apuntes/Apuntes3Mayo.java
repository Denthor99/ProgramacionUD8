package org.ieslosremedios.daw1.prog.ut8.apuntes;

public class Apuntes3Mayo {
    /**
     * Tipos de datos persistentes
     * - Enumerados --> valores numericos o alfanumericos
     *      ej: enum Dia {Lunes, Martes, ......}
     * @Enumerated(EnumType.Ordinal/String)
     * - Tipos que implementan Serializable
     * - Colecciones o Mapas si contienen tipos persistentes o null
     * - Clases definidas por el usuario
     *
     * Campos
     * - Los campos persistentes se almacenan en una bbdd
     * - Si no quiere que se almacene
     *      - @transient
     *
     * Campos clave primaria
     * - Campo con valor único y no nulo para cada instancia (registro)
     *
     *  Conexión con la base de datos
     *  EntityManager representa la conexión con la base de datos
     * */
}
