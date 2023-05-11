
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
     public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento(char separador) {
        String fecha = null;

        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%02d%c%02d%c%04d", this.fechaNacimiento.getDayOfMonth(), separador,
                        this.fechaNacimiento.getMonthValue(), separador,
                        this.fechaNacimiento.getYear());
            }
            return fecha;
        }
    }


}

