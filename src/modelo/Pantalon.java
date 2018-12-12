package modelo;

/**
 *
 * @author MiguelAngel
 */
public class Pantalon extends Producto{
    private String tipo;
    private char sexo;

    public Pantalon(String codigo, int precioBase, int stock, String tipo, char sexo) {
        super(codigo, precioBase, stock);
        setTipo(tipo);
        setSexo(sexo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equalsIgnoreCase("jeans") || tipo.equalsIgnoreCase("cotele") || tipo.equalsIgnoreCase("tela"))
            this.tipo = tipo;
        else
            throw new IllegalArgumentException("Tipo de pantalon permitidos:\nJeans, Cotele, Tela");
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'H' || sexo == 'M')
            this.sexo = sexo;
        else{
            throw new IllegalArgumentException("Error en validación de sexo\n(Debe ser H o M)");
        }
    }
    
    @Override
    public double calcularTotal(int cantidad, String horario) {
        if (this.validarStock(cantidad)) {
            double total = this.getPrecioBase() * cantidad * 1.19;
            return total;
        }
        else{
        throw new IllegalArgumentException("Stock insuficiente");
        }
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Tipo: " + tipo + ", Sexo: " + sexo;
    }

    @Override
    public String toString() {
        return super.toString() + "Pantalon{" + "tipo=" + tipo + ", sexo=" + sexo + '}';
    }
    
}
