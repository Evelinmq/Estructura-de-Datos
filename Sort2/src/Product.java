public class Product {
    private String nombre;
    private double price;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(String nombre, double price) {
        this.nombre = nombre;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [nombre=" + nombre + ", price=" + price + "]";
    }

    

}
