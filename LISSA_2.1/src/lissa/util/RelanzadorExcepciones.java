package lissa.util;

/**
 *
 * @author JSULCAG
 */
public class RelanzadorExcepciones {

    public static RuntimeException lanzar(Exception ex) {
        RelanzadorExcepciones.<RuntimeException>lanzarComoUnchecked(ex);
        throw new AssertionError("Esta línea  nunca se ejecutará pero Java no lo sabe");
    }

    private static <T extends Exception> void lanzarComoUnchecked(Exception toThrow) throws T {
        throw (T) toThrow;
    }
}
