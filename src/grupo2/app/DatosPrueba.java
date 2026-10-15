package grupo2.app;

import grupo2.enums.TipoUnidad;
import grupo2.modelo.Estudiante;
import grupo2.modelo.UnidadAcademica;
import grupo2.negocio.ArbolEstudiantes;
import grupo2.negocio.ArbolOrganizacional;

public class DatosPrueba {

    private DatosPrueba() {
    }

    public static UnidadAcademica universidad() {
        return new UnidadAcademica("UTA", "Universidad Técnica de Ambato", TipoUnidad.UNIVERSIDAD);
    }

    public static void cargar(ArbolOrganizacional arbol) {
        arbol.agregar("UTA", new UnidadAcademica("FISEI", "Ingeniería en Sistemas, Electrónica e Industrial", TipoUnidad.FACULTAD));
        arbol.agregar("FISEI", new UnidadAcademica("SW", "Software", TipoUnidad.CARRERA));
        arbol.agregar("FISEI", new UnidadAcademica("TI", "Tecnologías de la Información", TipoUnidad.CARRERA));
        arbol.agregar("FISEI", new UnidadAcademica("TEL", "Telecomunicaciones", TipoUnidad.CARRERA));
        arbol.agregar("FISEI", new UnidadAcademica("AR", "Automatización y Robótica", TipoUnidad.CARRERA));
        arbol.agregar("FISEI", new UnidadAcademica("IND", "Industrial", TipoUnidad.CARRERA));
        arbol.agregar("SW", new UnidadAcademica("SW-N3", "Nivel 3", TipoUnidad.NIVEL));
        arbol.agregar("SW-N3", new UnidadAcademica("SW-N3-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("SW-N3", new UnidadAcademica("SW-N3-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("SW", new UnidadAcademica("SW-N4", "Nivel 4", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FCIAB", "Ciencia e Ingeniería en Alimentos y Biotecnología", TipoUnidad.FACULTAD));
        arbol.agregar("FCIAB", new UnidadAcademica("ALI", "Ingeniería en Alimentos", TipoUnidad.CARRERA));
        arbol.agregar("FCIAB", new UnidadAcademica("BIO", "Ingeniería Bioquímica", TipoUnidad.CARRERA));
        arbol.agregar("ALI", new UnidadAcademica("ALI-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("ALI-N1", new UnidadAcademica("ALI-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("ALI-N1", new UnidadAcademica("ALI-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("ALI", new UnidadAcademica("ALI-N2", "Nivel 2", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FCA", "Ciencias Administrativas", TipoUnidad.FACULTAD));
        arbol.agregar("FCA", new UnidadAcademica("OE", "Organización de Empresas", TipoUnidad.CARRERA));
        arbol.agregar("FCA", new UnidadAcademica("MKT", "Marketing y Gestión de Negocios", TipoUnidad.CARRERA));
        arbol.agregar("OE", new UnidadAcademica("OE-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("OE-N1", new UnidadAcademica("OE-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("OE-N1", new UnidadAcademica("OE-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("OE", new UnidadAcademica("OE-N2", "Nivel 2", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FCAGP", "Ciencias Agropecuarias", TipoUnidad.FACULTAD));
        arbol.agregar("FCAGP", new UnidadAcademica("AGR", "Ingeniería Agronómica", TipoUnidad.CARRERA));
        arbol.agregar("FCAGP", new UnidadAcademica("MVZ", "Medicina Veterinaria y Zootecnia", TipoUnidad.CARRERA));
        arbol.agregar("FCAGP", new UnidadAcademica("AGP", "Ingeniería Agropecuaria", TipoUnidad.CARRERA));
        arbol.agregar("AGR", new UnidadAcademica("AGR-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("AGR-N1", new UnidadAcademica("AGR-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("AGR-N1", new UnidadAcademica("AGR-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("AGR", new UnidadAcademica("AGR-N2", "Nivel 2", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FICM", "Ingeniería Civil y Mecánica", TipoUnidad.FACULTAD));
        arbol.agregar("FICM", new UnidadAcademica("CIV", "Ingeniería Civil", TipoUnidad.CARRERA));
        arbol.agregar("FICM", new UnidadAcademica("MEC", "Ingeniería Mecánica", TipoUnidad.CARRERA));
        arbol.agregar("CIV", new UnidadAcademica("CIV-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("CIV-N1", new UnidadAcademica("CIV-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("CIV-N1", new UnidadAcademica("CIV-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("CIV", new UnidadAcademica("CIV-N2", "Nivel 2", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FCS", "Ciencias de la Salud", TipoUnidad.FACULTAD));
        arbol.agregar("FCS", new UnidadAcademica("MED", "Medicina", TipoUnidad.CARRERA));
        arbol.agregar("FCS", new UnidadAcademica("ENF", "Enfermería", TipoUnidad.CARRERA));
        arbol.agregar("FCS", new UnidadAcademica("PSC", "Psicología Clínica", TipoUnidad.CARRERA));
        arbol.agregar("FCS", new UnidadAcademica("TF", "Terapia Física", TipoUnidad.CARRERA));
        arbol.agregar("FCS", new UnidadAcademica("LC", "Laboratorio Clínico", TipoUnidad.CARRERA));
        arbol.agregar("FCS", new UnidadAcademica("ET", "Estimulación Temprana", TipoUnidad.CARRERA));
        arbol.agregar("MED", new UnidadAcademica("MED-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("MED-N1", new UnidadAcademica("MED-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("MED-N1", new UnidadAcademica("MED-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("MED", new UnidadAcademica("MED-N2", "Nivel 2", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FDAA", "Diseño y Arquitectura", TipoUnidad.FACULTAD));
        arbol.agregar("FDAA", new UnidadAcademica("DGP", "Diseño Gráfico Publicitario", TipoUnidad.CARRERA));
        arbol.agregar("FDAA", new UnidadAcademica("AI", "Arquitectura de Interiores", TipoUnidad.CARRERA));
        arbol.agregar("FDAA", new UnidadAcademica("DM", "Diseño de Modas", TipoUnidad.CARRERA));
        arbol.agregar("DGP", new UnidadAcademica("DGP-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("DGP-N1", new UnidadAcademica("DGP-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("DGP-N1", new UnidadAcademica("DGP-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("DGP", new UnidadAcademica("DGP-N2", "Nivel 2", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FCAUD", "Contabilidad y Auditoría", TipoUnidad.FACULTAD));
        arbol.agregar("FCAUD", new UnidadAcademica("CA", "Contabilidad y Auditoría", TipoUnidad.CARRERA));
        arbol.agregar("FCAUD", new UnidadAcademica("GF", "Gestión Financiera", TipoUnidad.CARRERA));
        arbol.agregar("FCAUD", new UnidadAcademica("EE", "Economía Empresarial", TipoUnidad.CARRERA));
        arbol.agregar("CA", new UnidadAcademica("CA-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("CA-N1", new UnidadAcademica("CA-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("CA-N1", new UnidadAcademica("CA-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("CA", new UnidadAcademica("CA-N2", "Nivel 2", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FCHE", "Ciencias Humanas y de la Educación", TipoUnidad.FACULTAD));
        arbol.agregar("FCHE", new UnidadAcademica("EB", "Educación Básica", TipoUnidad.CARRERA));
        arbol.agregar("FCHE", new UnidadAcademica("EI", "Educación Inicial", TipoUnidad.CARRERA));
        arbol.agregar("FCHE", new UnidadAcademica("ING", "Inglés", TipoUnidad.CARRERA));
        arbol.agregar("FCHE", new UnidadAcademica("CF", "Cultura Física", TipoUnidad.CARRERA));
        arbol.agregar("FCHE", new UnidadAcademica("IC", "Informática y Computación", TipoUnidad.CARRERA));
        arbol.agregar("FCHE", new UnidadAcademica("TH", "Turismo y Hotelería", TipoUnidad.CARRERA));
        arbol.agregar("FCHE", new UnidadAcademica("PE", "Psicología Educativa", TipoUnidad.CARRERA));
        arbol.agregar("FCHE", new UnidadAcademica("PI", "Psicología Industrial", TipoUnidad.CARRERA));
        arbol.agregar("FCHE", new UnidadAcademica("EAE", "Educación Ambiental y Ecoturismo", TipoUnidad.CARRERA));
        arbol.agregar("EB", new UnidadAcademica("EB-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("EB-N1", new UnidadAcademica("EB-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("EB-N1", new UnidadAcademica("EB-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("EB", new UnidadAcademica("EB-N2", "Nivel 2", TipoUnidad.NIVEL));
        arbol.agregar("UTA", new UnidadAcademica("FJCS", "Jurisprudencia y Ciencias Sociales", TipoUnidad.FACULTAD));
        arbol.agregar("FJCS", new UnidadAcademica("DER", "Derecho", TipoUnidad.CARRERA));
        arbol.agregar("FJCS", new UnidadAcademica("CS", "Comunicación Social", TipoUnidad.CARRERA));
        arbol.agregar("DER", new UnidadAcademica("DER-N1", "Nivel 1", TipoUnidad.NIVEL));
        arbol.agregar("DER-N1", new UnidadAcademica("DER-N1-A", "Paralelo A", TipoUnidad.PARALELO));
        arbol.agregar("DER-N1", new UnidadAcademica("DER-N1-B", "Paralelo B", TipoUnidad.PARALELO));
        arbol.agregar("DER", new UnidadAcademica("DER-N2", "Nivel 2", TipoUnidad.NIVEL));
        cargarEstudiantes(arbol.buscar("SW-N3-B").getEstudiantes());
    }

    private static void cargarEstudiantes(ArbolEstudiantes abb) {
        abb.insertar(new Estudiante(50, "1850004321", "Ana Pérez", 9.0));
        abb.insertar(new Estudiante(30, "1830014321", "Luis Mora", 7.0));
        abb.insertar(new Estudiante(70, "1870024321", "Sofía Ruiz", 8.0));
        abb.insertar(new Estudiante(20, "1820034321", "Carlos Vega", 9.0));
        abb.insertar(new Estudiante(40, "1840044321", "María León", 8.0));
        abb.insertar(new Estudiante(60, "1860054321", "Pedro Andrade", 7.0));
        abb.insertar(new Estudiante(80, "1880064321", "Diana Castro", 9.0));
        abb.insertar(new Estudiante(35, "1835074321", "Jorge Silva", 7.5));
        abb.insertar(new Estudiante(65, "1865084321", "Elena Paredes", 7.5));
    }
}
