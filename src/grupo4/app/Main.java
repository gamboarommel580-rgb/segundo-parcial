package grupo4.app;

import java.util.List;
import java.util.Scanner;
import grupo4.modelo.Estudiante;
import grupo4.modelo.UnidadAcademica;
import grupo4.enums.TipoUnidad;
import grupo4.negocio.ArbolEstudiantes;
import grupo4.negocio.NodoEstudiante;
import grupo4.negocio.NodoUnidad;
import grupo4.enums.TipoRecorrido;

public class Main {

    public static void main(String[] args) {

        Contexto c = new Contexto();

        try (Scanner in = new Scanner(System.in)) {

            boolean ejecutando = true;

            while (ejecutando) {

                mostrarMenu();

                if (!in.hasNextLine()) {
                    break;
                }

                String opcion = in.nextLine().trim();

                try {

                    switch (opcion) {

                        case "1":
                            consultarJerarquia(c, in);
                            break;

                        case "2":
                            registrarOBuscarEstudiante(c, in);
                            break;

                        case "3":
                            mostrarRecorridosYEstadisticas(c, in);
                            break;

                        case "4":
                            modificarOEliminarEstudiante(c, in);
                            break;

                        case "5":
                            gestionarUnidadesYTransformacion(c, in);
                            break;

                        case "6":
                            mostrarEstadoSistema(c);
                            break;

                        case "7":
                            c.reiniciar();
                            System.out.println(
                                "\nDatos reiniciados correctamente."
                            );
                            mostrarVerificacionReinicio(c);
                            break;

                        case "8":
                            ejecutarRetoIntegrador(c);
                            break;

                        case "0":
                            System.out.println(
                                "\nFinalizando SJA-UTA. Hasta pronto."
                            );
                            ejecutando = false;
                            break;

                        default:
                            System.out.println(
                                "\nOpcion invalida. Intente nuevamente."
                            );
                    }

                } catch (NumberFormatException e) {

                    System.out.println(
                        "\nError: ingrese un valor numerico valido."
                    );

                } catch (IllegalArgumentException | IllegalStateException e) {

                    System.out.println(
                        "\nAviso: " + e.getMessage()
                    );
                }
            }
        }
    }

    private static void mostrarMenu() {

        System.out.println("\n======================================");
        System.out.println("    SISTEMA JERARQUICO ACADEMICO UTA");
        System.out.println("           APE3 - GRUPO 4");
        System.out.println("======================================");

        System.out.println("1. Jerarquia academica");
        System.out.println("2. Insercion y busqueda de estudiantes");
        System.out.println("3. Recorridos y estadisticas");
        System.out.println("4. Modificacion y eliminacion de estudiantes");
        System.out.println("5. Unidades y transformacion binaria");
        System.out.println("6. Estado general del sistema");
        System.out.println("7. Reiniciar datos de ejemplo");
        System.out.println("8. Ejecutar reto integrador");
        System.out.println("0. Salir");

        System.out.println("======================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void consultarJerarquia(Contexto c, Scanner in) {

        System.out.println("\n===== JERARQUIA ACADEMICA =====");

        System.out.println(c.organizacion.mostrarJerarquia());

        System.out.println(
            "Altura organizacional: " + c.organizacion.altura()
        );

        System.out.println(
            "Total de hojas: " + c.organizacion.contarHojas()
        );

        System.out.print("\nCodigo de unidad a consultar: ");
        String codigo = in.nextLine().trim();

        NodoUnidad unidad = c.organizacion.buscar(codigo);

        if (unidad == null) {
            System.out.println("La unidad academica no existe.");
            return;
        }

        System.out.println("Unidad encontrada: " + codigo);

        System.out.println(
            "Nivel: " + c.organizacion.nivel(codigo)
        );

        System.out.println(
            "Grado: " + c.organizacion.grado(codigo)
        );

        // Integrante Cris:
        // Completar registro de unidades y pruebas de jerarquia.
    }

    private static void registrarOBuscarEstudiante(
        Contexto c, Scanner in
    ) {

        System.out.println("\n===== ESTUDIANTES =====");
        System.out.println("1. Insertar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.print("Seleccione una opcion: ");

        String opcion = in.nextLine().trim();

        if (!opcion.equals("1") && !opcion.equals("2")) {
            System.out.println("Opcion invalida.");
            return;
        }

        System.out.print("Matricula: ");
        int matricula = Integer.parseInt(in.nextLine().trim());

        ArbolEstudiantes abb = c.estudiantes();

        if (opcion.equals("2")) {

            Estudiante estudiante = abb.buscar(matricula);

            if (estudiante == null) {
                System.out.println("Estudiante no encontrado.");
            } else {
                System.out.println(
                    "Estudiante encontrado: " + estudiante
                );
            }

            return;
        }

        System.out.print("Cedula: ");
        String cedula = in.nextLine().trim();

        System.out.print("Nombres: ");
        String nombres = in.nextLine().trim();

        System.out.print("Promedio: ");
        double promedio = Double.parseDouble(
            in.nextLine().trim()
        );

        Estudiante estudiante = new Estudiante(
            matricula, cedula, nombres, promedio
        );

        boolean insertado = abb.insertar(estudiante);

        if (insertado) {
            System.out.println(
                "Estudiante registrado correctamente."
            );
        } else {
            System.out.println(
                "La matricula ya se encuentra registrada."
            );
        }

        // Integrante Andres:
        // Validar duplicados y datos invalidos en el modelo.
    }

    private static void mostrarRecorridosYEstadisticas(
        Contexto c, Scanner in
    ) {

        System.out.println("\n===== RECORRIDOS Y ESTADISTICAS =====");

        ArbolEstudiantes abb = c.estudiantes();

        System.out.println("1. Mostrar recorridos");
        System.out.println("2. Mostrar estadisticas");
        System.out.println("3. Mostrar todo");
        System.out.print("Seleccione una opcion: ");

        String opcion = in.nextLine().trim();

        if (opcion.equals("1") || opcion.equals("3")) {

            for (TipoRecorrido tipo : TipoRecorrido.values()) {

                System.out.println(
                    "\n--- " + tipo + " ---"
                );

                System.out.println(
                    abb.trazaRecorrido(tipo)
                );
            }
        }

        if (opcion.equals("2") || opcion.equals("3")) {

            System.out.println("\n--- ESTADISTICAS ---");

            System.out.println(
                "Cantidad: " + abb.contar()
            );

            System.out.println(
                "Altura: " + abb.altura()
            );

            if (abb.estaVacio()) {

                System.out.println(
                    "El paralelo no tiene estudiantes."
                );

            } else {

                System.out.println(
                    "Menor matricula: " + abb.menor()
                );

                System.out.println(
                    "Mayor matricula: " + abb.mayor()
                );

                System.out.printf(
                    "Promedio general: %.2f%n",
                    abb.promedioGeneral()
                );
            }
        }

        if (!opcion.equals("1")
            && !opcion.equals("2")
            && !opcion.equals("3")) {

            System.out.println("Opcion invalida.");
        }

        // Integrante Lenin:
        // Verificar recorridos, trazas y casos limite.
    }

    private static void modificarOEliminarEstudiante(
        Contexto c, Scanner in
    ) {

        System.out.println("\n===== MODIFICAR O ELIMINAR =====");

        System.out.println("1. Modificar estudiante");
        System.out.println("2. Eliminar estudiante");
        System.out.print("Seleccione una opcion: ");

        String opcion = in.nextLine().trim();

        if (!opcion.equals("1") && !opcion.equals("2")) {
            System.out.println("Opcion invalida.");
            return;
        }

        System.out.print("Matricula: ");
        int matricula = Integer.parseInt(
            in.nextLine().trim()
        );

        ArbolEstudiantes abb = c.estudiantes();

        if (opcion.equals("2")) {

            System.out.println(
                "\nInorden antes de eliminar:"
            );

            System.out.println(
                abb.recorrer(TipoRecorrido.INORDEN)
            );

            boolean eliminado = abb.eliminar(matricula);

            if (eliminado) {

                System.out.println(
                    "Estudiante eliminado correctamente."
                );

            } else {

                System.out.println(
                    "La matricula no existe."
                );
            }

            System.out.println(
                "\nInorden despues de eliminar:"
            );

            System.out.println(
                abb.recorrer(TipoRecorrido.INORDEN)
            );

            return;
        }

        System.out.print("Nueva cedula: ");
        String cedula = in.nextLine().trim();

        System.out.print("Nuevos nombres: ");
        String nombres = in.nextLine().trim();

        System.out.print("Nuevo promedio: ");
        double promedio = Double.parseDouble(
            in.nextLine().trim()
        );

        boolean modificado = abb.modificar(
            matricula, cedula, nombres, promedio
        );

        if (modificado) {

            System.out.println(
                "Estudiante modificado correctamente."
            );

        } else {

            System.out.println(
                "La matricula no existe."
            );
        }

        // Integrante Josue:
        // Comprobar modificacion y los tres casos de eliminacion.
    }

    private static void gestionarUnidadesYTransformacion(
        Contexto c, Scanner in
    ) {

        System.out.println("\n===== UNIDADES ACADEMICAS =====");

        System.out.println("1. Transformar a binario");
        System.out.println("2. Eliminar unidad academica");
        System.out.print("Seleccione una opcion: ");

        String opcion = in.nextLine().trim();

        if (opcion.equals("1")) {

            System.out.println(
                "\nTransformacion hijo izquierdo - hermano derecho:"
            );

            System.out.println(
                c.organizacion.transformarABinario()
            );

            return;
        }

        if (!opcion.equals("2")) {
            System.out.println("Opcion invalida.");
            return;
        }

        System.out.print("Codigo de unidad: ");
        String codigo = in.nextLine().trim();

        NodoUnidad unidad = c.organizacion.buscar(codigo);

        if (unidad == null) {
            System.out.println(
                "La unidad academica no existe."
            );
            return;
        }

        if (unidad.getEstudiantes() != null
            && !unidad.getEstudiantes().estaVacio()) {

            System.out.println(
                "No se puede eliminar un paralelo con estudiantes."
            );

            return;
        }

        boolean eliminado = c.organizacion.eliminar(codigo);

        if (eliminado) {

            System.out.println(
                "Unidad academica eliminada correctamente."
            );

        } else {

            System.out.println(
                "No se puede eliminar la unidad solicitada."
            );
        }

        // Integrante Hector:
        // Aplicar la proteccion tambien en la capa de negocio.
        // Verificar transformacion HI/HD.
    }

    private static void mostrarEstadoSistema(Contexto c) {

        System.out.println("\n===== ESTADO GENERAL SJA-UTA =====");

        NodoUnidad nodo = c.organizacion.buscar(c.paralelo);

        if (nodo == null || nodo.getEstudiantes() == null) {

            System.out.println(
                "ERROR: el paralelo activo no tiene un ABB valido."
            );

            return;
        }

        ArbolEstudiantes abb = c.estudiantes();

        boolean vinculado = nodo.getEstudiantes() == abb;

        System.out.println(
            "Paralelo activo: " + c.paralelo
        );

        System.out.println(
            "ABB vinculado: " + vinculado
        );

        System.out.println("\n--- Arbol organizacional ---");

        System.out.println(
            "Altura: " + c.organizacion.altura()
        );

        System.out.println(
            "Hojas: " + c.organizacion.contarHojas()
        );

        System.out.println(
            "Nivel del paralelo: " +
            c.organizacion.nivel(c.paralelo)
        );

        System.out.println("\n--- Arbol de estudiantes ---");

        System.out.println(
            "Cantidad: " + abb.contar()
        );

        System.out.println(
            "Altura: " + abb.altura()
        );

        if (abb.estaVacio()) {

            System.out.println(
                "No hay estudiantes registrados."
            );

        } else {

            System.out.println(
                "Menor matricula: " +
                abb.menor().getMatricula()
            );

            System.out.println(
                "Mayor matricula: " +
                abb.mayor().getMatricula()
            );

            System.out.printf(
                "Promedio general: %.2f%n",
                abb.promedioGeneral()
            );
        }

        System.out.println(
            "\nDiagnostico finalizado."
        );
    }

    // ===================== RETO INTEGRADOR (opcion 8) =====================

    private static int correctas;
    private static int total;

    private static void verificar(String descripcion, boolean cumple) {
        total++;
        if (cumple) {
            correctas++;
        }
        System.out.println((cumple ? "  [OK]    " : "  [FALLA] ") + descripcion);
    }

    private static String matriculas(ArbolEstudiantes abb) {
        StringBuilder sb = new StringBuilder("[");
        List<Estudiante> lista = abb.recorrer(TipoRecorrido.INORDEN);
        for (int i = 0; i < lista.size(); i++) {
            sb.append(i == 0 ? "" : ", ").append(lista.get(i).getMatricula());
        }
        return sb.append("]").toString();
    }

    private static ArbolEstudiantes abb(Contexto c, String codigo) {
        return c.organizacion.buscar(codigo).getEstudiantes();
    }

    // Describe que caso de eliminacion del ABB le toca a la matricula
    private static String casoEliminacion(ArbolEstudiantes abb, int matricula) {
        NodoEstudiante nodo = abb.getRaiz();
        boolean esRaiz = true;
        while (nodo != null && nodo.getDato().getMatricula() != matricula) {
            nodo = matricula < nodo.getDato().getMatricula()
                    ? nodo.getIzquierdo() : nodo.getDerecho();
            esRaiz = false;
        }
        if (nodo == null) {
            return "no existe";
        }
        String caso;
        if (nodo.esHoja()) {
            caso = "nodo hoja";
        } else if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {
            caso = "nodo con un hijo";
        } else {
            caso = "nodo con dos hijos (sucesor inorden)";
        }
        return esRaiz ? "raiz, " + caso : caso;
    }

    private static void ejecutarRetoIntegrador(Contexto c) {

        correctas = 0;
        total = 0;

        // Se parte siempre de los datos iniciales: repetir la opcion 8
        // no duplica unidades ni estudiantes.
        c.reiniciar();

        System.out.println("\n========== RETO INTEGRADOR SJA-UTA ==========");
        System.out.println("(Se reiniciaron los datos para partir del estado inicial)");

        // ---------------- Mision 1 ----------------
        System.out.println("\n--- Mision 1. Jerarquia y ruta institucional ---");
        System.out.println("Antes: altura " + c.organizacion.altura()
                + ", hojas " + c.organizacion.contarHojas());

        boolean sw = c.organizacion.agregar("FCHE",
                new UnidadAcademica("SW", "Software", TipoUnidad.CARRERA));
        boolean swN3 = c.organizacion.agregar("SW",
                new UnidadAcademica("SW-N3", "Tercer nivel", TipoUnidad.NIVEL));
        boolean swN3A = c.organizacion.agregar("SW-N3",
                new UnidadAcademica("SW-N3-A", "Paralelo A", TipoUnidad.PARALELO));
        verificar("Agregar SW, SW-N3 y SW-N3-A bajo FCHE", sw && swN3 && swN3A);
        verificar("Rechazar un PARALELO directamente bajo FCHE",
                !c.organizacion.agregar("FCHE",
                        new UnidadAcademica("X-P", "Paralelo invalido", TipoUnidad.PARALELO)));

        System.out.println(c.organizacion.mostrarJerarquia());
        System.out.println("Despues: altura " + c.organizacion.altura()
                + ", hojas " + c.organizacion.contarHojas()
                + ", nivel SW " + c.organizacion.nivel("SW")
                + ", nivel SW-N3-A " + c.organizacion.nivel("SW-N3-A"));
        verificar("Altura 4, hojas 3 y nivel de SW-N3-A = 4",
                c.organizacion.altura() == 4 && c.organizacion.contarHojas() == 3
                        && c.organizacion.nivel("SW-N3-A") == 4);

        String rutaA = c.organizacion.obtenerRutaJerarquica("EB-N1-A");
        String rutaSw = c.organizacion.obtenerRutaJerarquica("sw-n3-a");
        String rutaX = c.organizacion.obtenerRutaJerarquica("XYZ");
        System.out.println("Ruta EB-N1-A: " + rutaA);
        System.out.println("Ruta SW-N3-A: " + rutaSw);
        System.out.println("Ruta XYZ:     " + rutaX);
        verificar("Ruta EB-N1-A = UTA -> FCHE -> EB -> EB-N1 -> EB-N1-A",
                rutaA.equals("UTA -> FCHE -> EB -> EB-N1 -> EB-N1-A"));
        verificar("Codigo inexistente devuelve \"No existe\"", rutaX.equals("No existe"));

        // ---------------- Mision 2 ----------------
        System.out.println("\n--- Mision 2. Proteccion de unidades y transformacion binaria ---");
        verificar("No elimina EB-N1-A (tiene estudiantes)", !c.organizacion.eliminar("EB-N1-A"));
        verificar("No elimina SW-N3 (tiene subunidades)", !c.organizacion.eliminar("SW-N3"));
        verificar("No elimina UTA (raiz con hijos)", !c.organizacion.eliminar("UTA"));
        verificar("Codigo inexistente devuelve false", !c.organizacion.eliminar("XYZ"));

        int alturaAntes = c.organizacion.altura();
        int hojasAntes = c.organizacion.contarHojas();
        String jerarquiaAntes = c.organizacion.mostrarJerarquia();
        String binario = c.organizacion.transformarABinario();
        System.out.println("\nTransformacion hijo izquierdo / hermano derecho:");
        System.out.println(binario);
        verificar("SW es hermano derecho de EB", binario.contains("Hermano Der de EB: SW"));
        verificar("EB-N1-B es hermano derecho de EB-N1-A",
                binario.contains("Hermano Der de EB-N1-A: EB-N1-B"));
        verificar("La transformacion no altera el arbol general",
                jerarquiaAntes.equals(c.organizacion.mostrarJerarquia())
                        && alturaAntes == c.organizacion.altura()
                        && hojasAntes == c.organizacion.contarHojas());

        verificar("Elimina SW-N3-A (hoja vacia)", c.organizacion.eliminar("SW-N3-A"));
        verificar("SW-N3-A ya no existe", c.organizacion.buscar("SW-N3-A") == null);

        // ---------------- Mision 3 ----------------
        System.out.println("\n--- Mision 3. Validacion de datos y traslado entre paralelos ---");
        verificar("Matricula 0 se rechaza", lanza(() -> new Estudiante(0, "0000000001", "X", 8)));
        verificar("Matricula negativa se rechaza", lanza(() -> new Estudiante(-5, "0000000001", "X", 8)));
        Estudiante prueba = new Estudiante(99, "0000000099", "Prueba", 8);
        verificar("setPromedio(-1) se rechaza", lanza(() -> prueba.setPromedio(-1)));
        verificar("setPromedio(10.5) se rechaza", lanza(() -> prueba.setPromedio(10.5)));
        verificar("setPromedio(NaN) se rechaza", lanza(() -> prueba.setPromedio(Double.NaN)));
        verificar("setPromedio(Infinity) se rechaza",
                lanza(() -> prueba.setPromedio(Double.POSITIVE_INFINITY)));
        verificar("Promedio sin cambios tras los rechazos", prueba.getPromedio() == 8.0);

        verificar("Traslado rechazado: origen inexistente",
                !c.organizacion.trasladarEstudiante("XYZ", "EB-N1-B", 10));
        verificar("Traslado rechazado: destino no es PARALELO",
                !c.organizacion.trasladarEstudiante("EB-N1-A", "EB-N1", 10));
        verificar("Traslado rechazado: matricula 99 no existe en origen",
                !c.organizacion.trasladarEstudiante("EB-N1-A", "EB-N1-B", 99));
        abb(c, "EB-N1-B").insertar(new Estudiante(15, "0000000015", "Duplicado", 8));
        verificar("Traslado rechazado: matricula 15 ya existe en destino",
                !c.organizacion.trasladarEstudiante("EB-N1-A", "EB-N1-B", 15));
        verificar("El rechazo no borra al 15 del origen", abb(c, "EB-N1-A").buscar(15) != null);
        abb(c, "EB-N1-B").eliminar(15); // se quita el duplicado de prueba

        // ---------------- Mision 4 ----------------
        System.out.println("\n--- Mision 4. Modificacion segura y casos de eliminacion ---");
        ArbolEstudiantes a = abb(c, "EB-N1-A");
        ArbolEstudiantes b = abb(c, "EB-N1-B");
        Estudiante e35 = a.buscar(35);
        verificar("Modificar promedio de 35 a 9.80",
                a.modificar(35, e35.getCedula(), e35.getNombres(), 9.80));
        System.out.println("  Registro 35: " + a.buscar(35));
        verificar("Cedula invalida rechazada",
                lanza(() -> a.modificar(35, "123", "Estudiante 35", 7.0)));
        verificar("Promedio 15 rechazado",
                lanza(() -> a.modificar(35, "0000000035", "Estudiante 35", 15)));
        Estudiante d35 = a.buscar(35);
        verificar("El registro 35 sigue valido (cedula 0000000035, promedio 9.80)",
                d35.getCedula().equals("0000000035") && d35.getPromedio() == 9.80);

        int[] traslados = {10, 40, 45, 30};
        for (int m : traslados) {
            String caso = casoEliminacion(a, m);
            System.out.println("\nTrasladar " + m + " (en EB-N1-A es " + caso + ")");
            System.out.println("  Inorden EB-N1-A antes:   " + matriculas(a));
            boolean ok = c.organizacion.trasladarEstudiante("EB-N1-A", "EB-N1-B", m);
            System.out.println("  Inorden EB-N1-A despues: " + matriculas(a));
            System.out.println("  Inorden EB-N1-B:         " + matriculas(b));
            verificar("Traslado de " + m, ok && a.buscar(m) == null && b.buscar(m) != null);
        }
        verificar("EB-N1-A = [15, 20, 35, 50, 55]", matriculas(a).equals("[15, 20, 35, 50, 55]"));
        verificar("EB-N1-B = [10, 30, 40, 45]", matriculas(b).equals("[10, 30, 40, 45]"));
        verificar("Total de estudiantes conservado (9)", a.contar() + b.contar() == 9);

        // ---------------- Mision 5 ----------------
        System.out.println("\n--- Mision 5. Recorridos y estadisticas comparadas ---");
        System.out.printf("%-20s %-22s %-18s%n", "Dato", "EB-N1-A", "EB-N1-B");
        System.out.printf("%-20s %-22s %-18s%n", "Inorden", matriculas(a), matriculas(b));
        System.out.printf("%-20s %-22d %-18d%n", "Cantidad", a.contar(), b.contar());
        System.out.printf("%-20s %-22d %-18d%n", "Altura", a.altura(), b.altura());
        System.out.printf("%-20s %-22d %-18d%n", "Matricula menor",
                a.menor().getMatricula(), b.menor().getMatricula());
        System.out.printf("%-20s %-22d %-18d%n", "Matricula mayor",
                a.mayor().getMatricula(), b.mayor().getMatricula());
        System.out.printf("%-20s %-22.2f %-18.2f%n", "Promedio general",
                a.promedioGeneral(), b.promedioGeneral());
        System.out.printf("%-20s %-22d %-18d%n", "Aprobados (>= 8.00)",
                a.contarAprobados(8.00), b.contarAprobados(8.00));
        verificar("Promedio EB-N1-A = 8.36", String.format("%.2f", a.promedioGeneral()).equals(String.format("%.2f", 8.36)));
        verificar("Promedio EB-N1-B = 8.00", String.format("%.2f", b.promedioGeneral()).equals(String.format("%.2f", 8.00)));
        verificar("Aprobados >= 9.00: EB-N1-A = 1 (solo el 35)", a.contarAprobados(9.00) == 1);
        System.out.println("El inorden visita izquierdo, nodo y derecho; en un ABB los menores");
        System.out.println("estan a la izquierda y los mayores a la derecha, por eso las");
        System.out.println("matriculas salen ordenadas aun despues de eliminar o trasladar.");

        // ---------------- Mision 6 ----------------
        System.out.println("\n--- Mision 6. Integracion y reinicio ---");
        verificar("SW existe antes del reinicio", c.organizacion.buscar("SW") != null);
        System.out.println("Use la opcion 7 para restablecer los datos originales.");

        System.out.println("\nResultado del reto: " + correctas + "/" + total + " verificaciones OK");
    }

    private static boolean lanza(Runnable accion) {
        try {
            accion.run();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private static void mostrarVerificacionReinicio(Contexto c) {
        System.out.println("EB-N1-A: " + matriculas(abb(c, "EB-N1-A")));
        System.out.println("EB-N1-B: " + matriculas(abb(c, "EB-N1-B"))
                + (abb(c, "EB-N1-B").estaVacio() ? " (vacio)" : ""));
        System.out.println("SW existe: " + (c.organizacion.buscar("SW") != null));
        System.out.println("Altura: " + c.organizacion.altura()
                + " | Hojas: " + c.organizacion.contarHojas());
    }
}
