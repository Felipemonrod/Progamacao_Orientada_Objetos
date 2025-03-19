import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maior_numero = 0;
        int menor_numero = 0;
        int media = 0;
        int valor = 0;
        int tamanho = 0;
        do {
            System.out.println("Digite o valor:");
            valor = input.nextInt();
            if (tamanho == 0) {
                maior_numero = valor;
                menor_numero = valor;
            }
            if (valor > maior_numero) {
                maior_numero = valor;
            } else if (valor < menor_numero) {
                menor_numero = valor;
            }
            media = media + valor;
            tamanho++;
        }while(valor != -1);
        tamanho--;
        media = media/tamanho;
        System.out.println("Maior:"+maior_numero);
        System.out.println("Menor:"+menor_numero);
        System.out.println("Media:"+(media));
        input.close();
    }
}
