package modelo;

/**
 *
 * @author MiguelAngel
 */
public abstract class Electrodomestico extends Producto implements ProductoDescontable{
    private String marca;

    public Electrodomestico(String codigo, int precioBase, int stock, String marca) {
        super(codigo, precioBase, stock);
        setMarca(marca);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca.length() < 2)
            throw new IllegalArgumentException("Marca debe tener mínimo 2 carácteres");
        else
            this.marca = marca;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Marca: " + marca;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Electrodomestico{" + "marca=" + marca + '}';
    }
    
}
