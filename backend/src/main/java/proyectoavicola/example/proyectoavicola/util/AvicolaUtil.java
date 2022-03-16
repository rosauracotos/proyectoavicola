package proyectoavicola.example.proyectoavicola.util;

public class AvicolaUtil {

    public static Integer convertirStringANumero(String cadena) {
        return Integer.parseInt(cadena);
    }

    public static String obtenerSiguienteCodigo(Integer codigo) {
        Integer codigoAumentado = codigo + 1;
        return completarNumeroConCeros(8, codigoAumentado);
    }

    public static String completarNumeroConCeros(Integer tamanio, Integer valor) {
        return String.format("%0" + tamanio + "d" , valor);
    }
}
