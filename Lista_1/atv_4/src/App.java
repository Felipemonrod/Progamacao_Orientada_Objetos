import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //String input = "4539 3195 0343 6467";
        System.out.println("Digite seu Luhn:");
        String numero_cartao_credito = input.nextLine();
        String trim_numero = numero_cartao_credito.replaceAll(" ", "");
        // System.err.println(numero_cartao_credito);
        // System.out.println(trim_numero);
        String[] todos_numeros = trim_numero.split("");
        int[] segundo_numero = new int[todos_numeros.length/2];
        int[] todos_numeros_int = new int[todos_numeros.length];

        int aux = 0;
        for (int i = 0; i < todos_numeros.length; i++) {
            todos_numeros_int[i] = Integer.parseInt(todos_numeros[i]);
            if (i % 2 == 0) {
                segundo_numero[aux] = todos_numeros_int[i];
                aux++;
            }
        }

        for (int i = 0; i < segundo_numero.length; i++) {
            segundo_numero[i] = segundo_numero[i]*2;
            if (segundo_numero[i] > 9) {
                segundo_numero[i] = segundo_numero[i] -9;
            }
        }
        aux=0;
        for (int i = 0; i < todos_numeros.length; i++) {
            if (i %2 == 0)  {
                todos_numeros_int[i] = segundo_numero[aux];
                aux++;
            }
        }

        int soma =0;
        for (int i : todos_numeros_int) {
            soma = soma + i;
        }
        if (soma % 10 == 0) {
            System.out.println("Valido");
        }else{
            System.out.println("Não é valido");
        }

        input.close();
    }
}
