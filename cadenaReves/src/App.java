public class App {

    public static void invertir(String cadena){
        if(cadena.length()==0){
            return;
        }else{
            char ultimo = cadena.charAt(cadena.length()-1);
        

        System.out.print(ultimo);

        String cadena2 = cadena.substring(0, cadena.length()-1);

        invertir(cadena2);
        }
    }
    public static void main(String[] args) throws Exception {
        
        String texto = "Me gusta dormir";
        
        System.out.println("Rexto original: " + texto);
        System.out.println("Texto al reves: ");
        invertir(texto);

    }
}
