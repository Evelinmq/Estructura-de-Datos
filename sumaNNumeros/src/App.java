import java.util.Scanner;

public class App {


    public static int suma(int numero){
        if(numero==0){
            return 0;
        }else{
            return numero + suma(numero-1);
        }

    }

    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un numero: ");
        int numero = scanner.nextInt();
        int resultado = suma(numero);

        scanner.close();

        System.out.println("El resultado es: " + resultado);
        

    }
}
