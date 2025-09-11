public class Worker {
    int id;
    String nombre;
    float sueldo;

    public Worker(int id, String nombre, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "\n Id: " + id + "\t Nombre: " + nombre + "\t Sueldo: " + sueldo;
    }

}
