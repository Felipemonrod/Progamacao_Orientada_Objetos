import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        String[] lista_cores = {"preto", "marrom", "vermelho", "laranja", "amarelo", "verde", "azul", "violeta", "cinza", "branco"};
        Scanner input = new Scanner(System.in);
        // String input = "azul_branco_vermelho";
        System.out.println("Digite duas cores e divida por _ se digitar mais de uma somente as duas primeras serão levadas em conta");
        String cor = input.nextLine();
        // o split retorna um array/lista
        String[] split_cor = cor.split("_");
        String concatenar_numeros = new String();
        for (int i = 0; i < split_cor.length; i++) {
            for (int j = 0; j < lista_cores.length; j++) {
                // Equals ira comparar o valor dos dois objetos
                if (split_cor[i].equals(lista_cores[j])) {
                    // += adiciona uma variavel ao que ela já tem
                    // ""+  Converte em string 
                    concatenar_numeros += ""+j;
                }
            }
        }
        System.out.println(concatenar_numeros);
        input.close();
    }
}

