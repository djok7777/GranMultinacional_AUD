package modelo;

/**
 *
 * @author MiguelAngel
 */
public class Lavadora extends Electrodomestico{
    private char carga;

    public Lavadora(String codigo, int precioBase, int stock, String marca, char carga) {
        super(codigo, precioBase, stock, marca);
        setCarga(carga);
    }

    public char getCarga() {
        return carga;
    }

    public void setCarga(char carga) {
        if (carga == 'A' || carga == 'C')
            this.carga = carga;
        else
            throw new IllegalArgumentException("Error en validación de carga\nDebe ser A o C");
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
        boolean validacion = horario.equalsIgnoreCase("nocturno") && this.getMarca().equalsIgnoreCase("Zoni") && carga == 'A';
        if (validacion) {
            return this.getPrecioBase() * 0.11;
        }
        return 0;
    }
    
    @Override
    public String imprimir() {
        return super.imprimir() + ", Carga: " + carga;
    }

    @Override
    public String toString() {
        return super.toString() + "Lavadora{" + "carga=" + carga + '}';
    }

    @Override
    public boolean validarStock(int cantidad) {
        if (this.getStock() >= cantidad) {
            return true;
        }
        return false;
    }
    
}
