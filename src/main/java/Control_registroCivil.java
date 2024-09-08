import java.text.SimpleDateFormat;
import java.util.*;

public class Control_registroCivil {

    private HashMap<String, Persona> personas = new HashMap<>();


    public boolean addPersona(Persona pp) {
        if (personas.containsKey(pp.getRut())) return false;
        personas.put(pp.getRut(), pp);
        return true;
    }

    public boolean buscarPersona(String rut) {
        return personas.containsKey(rut);
    }

    public void imprimirPersonas(String rut) {
        SimpleDateFormat tipo = new SimpleDateFormat("dd-MM-yyyy");
        if (personas.containsKey(rut)) {
            Persona pp = personas.get(rut);
            System.out.println("Datos de la persona :\n");
            System.out.println("Rut: " + pp.getRut());
            System.out.println("Nombre completo : " + pp.getNombre());
            System.out.println("Fecha de nacimiento : " + tipo.format(pp.getFechaNacimiento()));
            System.out.println("Estado civil : " + pp.getEstadoCivil());
        }
    }

    public void certNacimiento(String rut) {
        Persona pp = personas.get(rut);
        SimpleDateFormat tipo = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("==================================================");
        System.out.println("           CERTIFICADO DE NACIMIENTO              ");
        System.out.println("==================================================");
        System.out.println("Nombre Completo: " + pp.getNombre());
        System.out.println("Numero de R.U.T: " + pp.getRut());
        System.out.println("Fecha de Nacimiento: " + tipo.format(pp.getFechaNacimiento()));
        System.out.println("Lugar de Nacimiento: " + pp.getLugarNacimiento());
        System.out.println("--------------------------------------------------");
        System.out.println("Fecha de Emision: " + tipo.format(new Date()));
        System.out.println("==================================================");
        System.out.println("==================================================\n");
    }

    public boolean certMatrimonio(String rut) {
        Persona pp = personas.get(rut);
        String txt = pp.getEstadoCivil().toLowerCase();
        SimpleDateFormat tipo = new SimpleDateFormat("dd-MM-yyyy");
        if (!txt.equals("casado")) return false;
        System.out.println("==================================================");
        System.out.println("           CERTIFICADO DE MATRIMONIO              ");
        System.out.println("==================================================");
        System.out.println("Este es para certificar que :");
        System.out.println("El Sr./Sra. " + pp.getNombre() + " R.U.T " + pp.getRut());
        System.out.println("ha conciliado matrimonio con fecha " + tipo.format(pp.getFechaMatrimonio()));
        System.out.println("--------------------------------------------------");
        System.out.println("Fecha de Emision: " + tipo.format(new Date()));
        System.out.println("==================================================");
        System.out.println("==================================================\n");
        return true;
    }

    public boolean certDefuncion(String rut) {
        Persona pp = personas.get(rut);
        SimpleDateFormat tipo = new SimpleDateFormat("dd-MM-yyyy");
        if (pp.getFechaDefuncion() == null) return false;
        System.out.println("==================================================");
        System.out.println("           CERTIFICADO DE DEFUNCION               ");
        System.out.println("==================================================");
        System.out.println("Este es para certificar que :");
        System.out.println("El Sr./Sra. " + pp.getNombre() + " R.U.T " + pp.getRut());
        System.out.println("ha fallecido con fecha " + tipo.format(pp.getFechaDefuncion()));
        System.out.println("--------------------------------------------------");
        System.out.println("Fecha de Emision: " + tipo.format(new Date()));
        System.out.println("==================================================");
        System.out.println("==================================================\n");
        return true;
    }

    public boolean registrarDef(String rut, Date fecha) {
        Persona pp = personas.get(rut);
        SimpleDateFormat tipo = new SimpleDateFormat("dd-MM-yyyy");
        if (pp.getFechaDefuncion() != null) return false;
        pp.setFechaDefuncion(tipo.format(fecha));
        return true;
    }
}
