package modelo;

/**
 *
 * @author MiguelAngel
 */
public interface ProductoDescontable {
    public double calcularDescuento(String horario);
    public double PORCENTAJE_DESCUENTO = 0.13;
}
