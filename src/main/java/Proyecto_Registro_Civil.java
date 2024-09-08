import java.io.*;

public class Proyecto_Registro_Civil {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException  {

        int opcion;
        Control_registroCivil registroCivil = new Control_registroCivil();
        insertarDatos(registroCivil);
        System.out.println("\n.:Registro Civil:.\n");
        System.out.println("Bienvenido,");

        do {
            System.out.println("Que deseas hacer? (elige una opcion).\n");
            System.out.println("1. Agregar oficina / persona.\n2. Mostrar oficinas / personas.\n3. Emitir certificado.\n4. Registrar defuncion.\n5. Salir.\n");
            System.out.print("Opcion :");

            opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {
                case 1 -> gestionOpcionUNO(registroCivil);
                case 2 -> gestionOpcionDOS(registroCivil);
                case 3 -> gestionOpcionTRES(registroCivil);
                case 4 -> gestionOpcionCUATRO(registroCivil);
                case 5 -> {return;}
                default -> System.out.println("OPCION INVALIDA, INTENTE NUEVAMENTE.\n");
            }
        } while (true);
    }

    public static void gestionOpcionUNO(Control_registroCivil registroCivil) throws IOException {

        int opcion;
        do {
            System.out.println("----------------------------------------");
            System.out.println("Que deseas agregar? (elige una opcion).\n");
            System.out.println("1. Agregar oficina.\n2. Agregar persona.\n0. Regresar.\n");
            System.out.print("Opcion :");

            opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {
                case 1 -> agregarOficina(registroCivil);
                case 2 -> agregarPersona(registroCivil);
                case 0 -> {return;}
                default -> System.out.println("\nOPCION INVALIDA, INTENTE NUEVAMENTE.\n");
            }
        } while (true);
    }

    public static void agregarPersona(Control_registroCivil registroCivil) throws IOException {

        Persona pp = new Persona();
        System.out.print("\nIngrese el RUT de la persona : ");
        pp.setRut(leer.readLine());

        if (registroCivil.buscarPersona(pp.getRut())) {
            System.out.println("ERROR: La persona ya existe\n-----------------------------------------------");
            return;
        }
        System.out.print("Ingrese el nombre completo de la persona : ");
        pp.setNombre(leer.readLine());

        System.out.print("Ingrese la fecha de nacimiento de la persona (formato dd-mm-yyyy) : ");    
        pp.setFechaNacimiento(leer.readLine());
        if (pp.getFechaNacimiento() == null) 
            return;

        System.out.print("Ingrese el lugar de nacimiento de la persona : ");
        pp.setLugarNacimiento(leer.readLine());

        System.out.print("Esta casado? (si/no) : ");
        String opcion = leer.readLine();

        if (opcion.equals("si") || opcion.equals("SI") || opcion.equals("Si")) {
            System.out.print("Ingrese fecha de matrimonio (formato dd-mm-yyyy) : ");
            pp.setFechaMatrimonio(leer.readLine());
            if (pp.getFechaMatrimonio() == null) 
                return;        
            pp.setEstadoCivil("Casado");
        } else {        
            System.out.print("Ingrese el estado civil de la persona : ");
            pp.setEstadoCivil(leer.readLine());
        }
        if (pp.getFechaNacimiento() == null) 
            return;

        if (registroCivil.addPersona(pp)) System.out.println("\nPersona agregada con exito!\n-----------------------------------------------");   
        else System.out.println("ERROR: La persona ya existe\n-----------------------------------------------"); 
    }

    public static void agregarOficina(Control_registroCivil registroCivil) throws IOException {

        Oficina off = new Oficina();
        System.out.print("\nIngrese la region de la oficina : ");
        off.setRegion(leer.readLine());

        System.out.print("Ingrese la comuna de la oficina : ");
        off.setComuna(leer.readLine());
        System.out.print("Ingrese el codigo de la oficina : ");
        off.setCodigoOficina(Integer.parseInt(leer.readLine()));

        System.out.print("Ingrese la direccion de la oficina : ");
        off.setDireccion(leer.readLine());
        System.out.println("");

        if (registroCivil.addOficina(off)) System.out.println("Oficina agregada con exito!");
        else System.out.println("ERROR: La oficina ya existe");
    }

    public static void gestionOpcionDOS(Control_registroCivil registroCivil) throws IOException {

        int opcion;
        do {
            System.out.println("----------------------------------------");
            System.out.println("Que deseas mostrar? (elige una opcion).\n");
            System.out.println("1. Mostrar oficina\n2. Mostrar persona.\n0. Regresar\n");
            System.out.print("Opcion :");

            opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {
                case 1 -> mostrarOficinas(registroCivil);
                case 2 -> mostrarPersonas(registroCivil);
                case 0 -> {return;}
                default -> System.out.println("\nOPCION INVALIDA, INTENTE NUEVAMENTE.\n");
            }
        } while (true);
    }

    public static void mostrarPersonas(Control_registroCivil registroCivil) throws IOException {

        System.out.print("-----------------------------------------------\nIngresa el RUT de la persona a mostrar : ");
        String rut = leer.readLine();
        System.out.println("");
        registroCivil.imprimirPersonas(rut);
    }

    public static void mostrarOficinas(Control_registroCivil registroCivil) throws IOException {

        System.out.print("Ingrese la region de las oficinas a mostrar: ");
        String region = leer.readLine();

        System.out.print("Ingrese la comuna de las oficinas a mostrar (Presione enter para mostrar todas las oficinas de la region. Si desea mostrar una oficina especifica perteneciente a una comuna de la region que buscas ingrese el nombre de la comuna): ");
        String comuna = leer.readLine();

        if (comuna.isEmpty()) {
            registroCivil.imprimirOficinas(region);
        } else {
            registroCivil.imprimirOficinas(region, comuna);
        }
    }

    public static void gestionOpcionTRES(Control_registroCivil registroCivil) throws IOException {

        int opcion;
        do {
            System.out.println("----------------------------------------");
            System.out.println("Que certificado deseas emitir? (elige una opcion).\n");
            System.out.println("1. Certificado de nacimiento\n2. Certificado de matrimonio.\n3. Certificado de defuncion.\n0. Regresar\n");
            System.out.print("Opcion :");

            opcion = Integer.parseInt(leer.readLine());

            switch (opcion) {
                case 1 -> certNacimiento(registroCivil);
                case 2 -> certMatrimonio(registroCivil);
                case 3 -> certDefuncion(registroCivil);
                case 0 -> {return;}
                default -> System.out.println("\nOPCION INVALIDA, INTENTE NUEVAMENTE.\n");
            }
        } while (true);
    }

    public static void certNacimiento(Control_registroCivil registroCivil) throws IOException {

        System.out.print("Ingrese su RUT : ");
        String rut = leer.readLine();

        if (registroCivil.buscarPersona(rut)) {
            registroCivil.certNacimiento(rut);
        } else System.out.println("ERROR: La persona no existe\n-----------------------------------------------");
    }

    public static void certMatrimonio(Control_registroCivil registroCivil) throws IOException {

        System.out.print("-----------------------------------------------\nIngrese su RUT : ");
        String rut = leer.readLine();

        if (registroCivil.buscarPersona(rut)) {
            if (!registroCivil.certMatrimonio(rut)) System.out.println("ERROR: Los datos ingresados no cumplen los requisitos para emitir este certificado.");
        } else System.out.println("ERROR: La persona no existe\n-----------------------------------------------");
    }

    public static void certDefuncion(Control_registroCivil registroCivil) throws IOException {

        System.out.print("-----------------------------------------------\nIngrese su RUT : ");
        String rut = leer.readLine();

        if (registroCivil.buscarPersona(rut)) {
            if (!registroCivil.certDefuncion(rut)) System.out.println("ERROR: Los datos ingresados no cumplen los requisitos para emitir este certificado.");
        } else System.out.println("ERROR: La persona no existe\n-----------------------------------------------");
    }

    public static void gestionOpcionCUATRO(Control_registroCivil registroCivil) throws IOException {

        Persona pp = new Persona();
        System.out.print("-----------------------------------------------\nIngrese el RUT de la persona : ");
        pp.setRut(leer.readLine());

        System.out.print("Ingrese la fecha de defuncion (formato dd-mm-yyyy) : ");
        pp.setFechaDefuncion(leer.readLine());

        if (registroCivil.buscarPersona(pp.getRut())) {
            if (!registroCivil.registrarDef(pp.getRut(), pp.getFechaDefuncion())) System.out.println("ERROR: Los datos ingresados no cumplen los requisitos para registrar defuncion.\n-----------------------------------------------");
            else System.out.println("Datos actualizados correctamente!\n");
        } else System.out.println("ERROR: La persona no existe\n-----------------------------------------------");
    }

    public static void insertarDatos(Control_registroCivil registroCivil){

        Oficina off = new Oficina();
        off.setRegion("Valparaiso");        
        off.setComuna("Vina del Mar");
        off.setCodigoOficina(Integer.parseInt("12"));
        off.setDireccion("Av. Brasil 3582");  
        registroCivil.addOficina(off);

        off = new Oficina();
        off.setRegion("Magallanes y la Antartica Chilena");        
        off.setComuna("Punta Arenas");
        off.setCodigoOficina(Integer.parseInt("129"));
        off.setDireccion("Cerastio 142");  
        registroCivil.addOficina(off);

        off = new Oficina();
        off.setRegion("Libertador General Bernardo O'Higgins");        
        off.setComuna("Machali");
        off.setCodigoOficina(Integer.parseInt("378"));
        off.setDireccion("Plaza el Portal 901");  
        registroCivil.addOficina(off);

        Persona pp = new Persona();
        pp.setRut("21.279.613-1");
        pp.setNombre("Alvaro Carrasco Gallardo");
        pp.setFechaNacimiento("18-04-2003");
        pp.setLugarNacimiento("Talcahuano");
        pp.setEstadoCivil("Casado");
        pp.setFechaMatrimonio("26-10-2020");
        registroCivil.addPersona(pp);

        pp = new Persona();
        pp.setRut("21.735.882-4");
        pp.setNombre("Camilo Mondaca Stay");
        pp.setFechaNacimiento("23-01-2002");
        pp.setLugarNacimiento("Cunco");
        pp.setEstadoCivil("Casado");
        pp.setFechaMatrimonio("26-10-2019");
        registroCivil.addPersona(pp);

        pp = new Persona();
        pp.setRut("20.834.112-k");
        pp.setNombre("Cristian Soto Correa");
        pp.setFechaNacimiento("24-01-2004");
        pp.setLugarNacimiento("San Felipe");
        pp.setEstadoCivil("Soltero");     
        registroCivil.addPersona(pp);
    }
}
