
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;


public class Persona {
    private String rut;
    private String nombre;
    private Date fechaNacimiento;
    private Date fechaDefuncion;
    private String lugarNacimiento;
    private String estadoCivil;
    private Date fechaMatrimonio;

    public void mostrar(){       
        System.out.println("Nombre Completo: " + nombre);
        System.out.println("Numero de R.U.T: " + rut); 
    }

    public void mostrar(String Nacimiento, SimpleDateFormat tipo){       
        System.out.println("Fecha de Nacimiento: " + tipo.format(fechaNacimiento));
        System.out.println("Lugar de Nacimiento: " + Nacimiento);     
    }
    public void setRut(String rut) {this.rut = rut;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setLugarNacimiento(String lugarNacimiento) {this.lugarNacimiento = lugarNacimiento;}

    public void setEstadoCivil(String estadoCivil) {this.estadoCivil = estadoCivil;}

    public void setFechaDefuncion(String fechaDefuncion) {

        SimpleDateFormat tipo = new SimpleDateFormat("dd-MM-yyyy");
        tipo.setLenient(false);
        Date fecha = null;

        try{
            fecha = tipo.parse(fechaDefuncion);
            Date fechaActual = new Date();

            if(fecha.after(fechaActual)) System.out.println("ERROR: La fecha ingresada no puede ser futura\n-----------------------------------------------");
            else this.fechaDefuncion = fecha;

        }catch(ParseException e){ System.out.println("ERROR: El formato de la fecha es invalido\n-----------------------------------------------");}  
    }

    public void setFechaMatrimonio(String fechaMatrimonio) {

        SimpleDateFormat tipo = new SimpleDateFormat("dd-MM-yyyy");
        tipo.setLenient(false);
        Date fecha = null;

        try{
            fecha = tipo.parse(fechaMatrimonio);
            Date fechaActual = new Date();

            if(fecha.after(fechaActual)) System.out.println("ERROR: La fecha ingresada no puede ser futura\n-----------------------------------------------");
            else this.fechaMatrimonio = fecha;

        }catch(ParseException e){ System.out.println("ERROR: El formato de la fecha es invalido\n-----------------------------------------------");}  
    }

    public void setFechaNacimiento(String fechaNacimiento){

        SimpleDateFormat tipo = new SimpleDateFormat("dd-MM-yyyy");
        tipo.setLenient(false);
        Date fecha = null;

        try{
            fecha = tipo.parse(fechaNacimiento);
            Date fechaActual = new Date();

            if(fecha.after(fechaActual)) System.out.println("ERROR: La fecha ingresada no puede ser futura\n-----------------------------------------------");
            else this.fechaNacimiento = fecha;

        }catch(ParseException e){ System.out.println("ERROR: El formato de la fecha es invalido\n-----------------------------------------------");}  

    } 

    public String getRut() {return rut;}

    public String getNombre() {return nombre;}

    public Date getFechaNacimiento() {return fechaNacimiento;}

    public String getEstadoCivil() {return estadoCivil;}

    public Date getFechaDefuncion() {return fechaDefuncion;}

    public String getLugarNacimiento() {return lugarNacimiento;}

    public Date getFechaMatrimonio() {return fechaMatrimonio;} 
}