public class App {


    public static int potencia(int base, int exponente){

        if(exponente == 0){
            return 1;
        }

        return base * potencia(base, exponente-1);
    }
    public static void main(String[] args) throws Exception {
        
        int base = 5;
        int exponente = 0;
        int resultado = potencia(base, exponente);

        System.out.println("El resultado de " + base + "^" + exponente +
        " es: " + resultado);


    }
}
