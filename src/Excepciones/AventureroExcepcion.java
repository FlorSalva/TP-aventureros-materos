package Excepciones;

public class AventureroExcepcion extends RuntimeException {
    private String mensaje;

    public AventureroExcepcion(String mensaje) {
        super(mensaje);
    }
}
