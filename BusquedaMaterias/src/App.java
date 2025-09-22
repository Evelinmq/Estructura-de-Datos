public class App {
    public static void main(String[] args) throws Exception {
        
        ListaMaterias lista = new ListaMaterias();

        lista.agregar("Matemáticas");
        lista.agregar("Química");
        lista.agregar("Filosofía");
        lista.agregar("Biología");
        lista.agregar("Programación");
        lista.agregar("Microbiología");

        lista.imprimir();

        String buscarMateria = "Programación";
        System.out.println("Busqueda: " + buscarMateria);

        if(lista.contiene(buscarMateria)){
            System.out.println("Resultado: Materia encontrada");
        }else{
            System.out.println("Resultado: Materia NO encontrada");
        }


    }
}
