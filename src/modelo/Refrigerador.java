package modelo;

/**
 *
 * @author MiguelAngel
 */
public class Refrigerador extends Electrodomestico{
    private int cantidadPies;

    public Refrigerador(String codigo, int precioBase, int stock, String marca, int cantidadPies) {
        super(codigo, precioBase, stock, marca);
        this.cantidadPies = cantidadPies;
    }

    public int getCantidadPies() {
        return cantidadPies;
    }

    public void setCantidadPies(int cantidadPies) {
        this.cantidadPies = cantidadPies;
    }
    
    @Override
    public double calcularTotal(int cantidad, String horario) {
        if (this.validarStock(cantidad)) {
            double total = (this.getPrecioBase() - calcularDescuento(horario)) * cantidad * 1.19;
            return total; 
        }
        else{
            throw new IllegalArgumentException("Stock insuficiente");
        }
    }

    @Override
    public double calcularDescuento(String horario) {
        boolean validacion = horario.equalsIgnoreCase("nocturno") && this.getMarca().equalsIgnoreCase("Acme") && cantidadPies == 15;
        if (validacion) {
            return this.getPrecioBase() * ProductoDescontable.PORCENTAJE_DESCUENTO;
        }
        return 0;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Cantidad de pies: " + cantidadPies;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Refrigerador{" + "cantidadPies=" + cantidadPies + '}';
    }
    
}
