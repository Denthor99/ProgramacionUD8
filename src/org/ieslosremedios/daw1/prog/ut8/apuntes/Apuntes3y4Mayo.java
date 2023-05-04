package org.ieslosremedios.daw1.prog.ut8.apuntes;

public class Apuntes3y4Mayo {
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
     *  EntityManager representa la conexión con la base de datos.
     *  Cerramos la conexión una vez terminada la conexión.
     *
     *  Herencia y composición
     *  - Una entidad que herede de otra, heredará sus campos persistentes
     *  - Una entidad con un campo tipo objeto, contedrá ese objeto.
     *      - Esto se haría con campos tipo Embbeded
     * @Entity
     * Persona
     *  - Nombre
     *  ^
     *  |
     *  |
     * @Entity
     * Alumno
     *  - grupo
     * @Embedded                @Embedable
     *  - Direccion dire ----> Direccion
     *                          - Calle
     *
     * Queries (operaciones)
     * Las consultas o queries a bbdd son de 4 tipos (CRUD): creation, read, update, delete
     * Toda operacion que realice un cambio en la bbdd debe realizarse en una transacción:
     * Se pueden realizar las operaciones CRUD de dos formas:
     * - Métodos específicos de EntityManager (find, remove, persist,seter)
     * - Consulta JPQL  (sentencias en una cadena de texto): parecido a SQL, pero propio de java
     *
     * Consultas con JPQL
     * Formas de declaración de consultas
     *  - Éstaticas --> En tiempo de compilación. Obliga el uso de parámetros
     * @NamedQuery(name='...', querry="SELECT")
     *  Lás estáticas son mucho más seguras, pues las dinamicas pueden generar problemas de seguridad.
     *
     * Un único valor o registro
     *
     * Varios registros
     * List<Clase>
     *
     * No es sensible a minusculas/mayusculas salvo los nombres.
     * Cadena de texto con comillas simple.
     * Booleanos se ponen como TRUE o FALSE.
     * */
}
