package modelo;

/**
 *
 * @author MiguelAngel
 */
public abstract class Producto {
    private String codigo;
    private int precioBase;
    private int stock;

    public Producto(String codigo, int precioBase, int stock) {
        this.codigo = codigo;
        setPrecioBase(precioBase);
        setStock(stock);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        if (precioBase <= 0)
            throw new IllegalArgumentException("precio base debe ser mayor a 0");
        else
            this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0)
            throw new IllegalArgumentException("Stock debe ser mayor o igual a 0");
        else
            this.stock = stock;
    }
    
    public boolean validarStock(int cantidad){
        if (stock >= cantidad) {
            return true;
        }
        else{
            System.out.println("Stock insuficiente");
        return false;
        }
    }
    
    public abstract double calcularTotal(int cantidad, String horario);
    
    public String imprimir(){
        return "Codigo: " + codigo + ", Precio base: " + precioBase + ", Stock: " + stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", precioBase=" + precioBase + ", stock=" + stock + '}';
    }
    
}
