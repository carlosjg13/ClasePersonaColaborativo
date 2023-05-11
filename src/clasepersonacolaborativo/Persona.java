
package clasepersonacolaborativo;

import java.time.DateTimeException;
import java.time.LocalDate;


public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos) {

        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

    }
    
    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {
        if ("".equals(nombre) || "".equals(apellidos) || "".equals(fechaNacimiento)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }

    }

    private LocalDate generarFecha(String fecha) {
        int dia = 0;
        int mes = 0;
        int anio = 0;

        if (!fecha.matches("\\d{2}-\\d{2}-\\d{4}")
                && !fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException();
        }

        try {
            dia = Integer.parseInt(fecha.substring(0, 2));
            mes = Integer.parseInt(fecha.substring(3, 5));
            anio = Integer.parseInt(fecha.substring(6, fecha.length()));

            return LocalDate.of(anio, mes, dia);
        } catch (NumberFormatException | DateTimeException ex1) {
            throw new IllegalArgumentException();
        }

    }
    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }
}

