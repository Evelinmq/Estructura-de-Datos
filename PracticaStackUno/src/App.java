public class App {

    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()){
            return false;
        } 


        StringBuilder cleaned = new StringBuilder();
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(c);
            }
        }

        ArrayStack<Character> stack = new ArrayStack<>(cleaned.length());

        // Coloca los caracteres en el stack
        for (int i = 0; i < cleaned.length(); i++) {
            stack.push(cleaned.charAt(i));
        }

        // Forma la versión invertida
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Compara ambas
        return cleaned.toString().equals(reversed.toString());
    }


    public static void main(String[] args) throws Exception {
        String s1 = "Anita lava la tina";
        String s2 = "Hola";

        System.out.println("\"" + s1 + "\" -> " + isPalindrome(s1));
        System.out.println("\"" + s2 + "\" -> " + isPalindrome(s2));
    }
}
