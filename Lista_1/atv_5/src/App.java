import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o 1 DNA:");
        String primeiro_dna = input.nextLine();
        System.out.println("Digite o 2 DNA:");
        String segundo_dna = input.nextLine();
        
        //fazer um split para comprar as strings 
        String[] split_primeiro_dna = primeiro_dna.split("");
        String[] split_segundo_dna = segundo_dna.split("");
        // colocar o lenght do meu split como o tamanho da minha lista 
        String[] diferencas = new String[split_primeiro_dna.length];

        int resultado_dna = 0;
        for (int i = 0; i < split_segundo_dna.length; i++) {
            // compara os duas listas e onde não forem igauis 
            // acrescenta mais um em resultado
            if (!split_primeiro_dna[i].equals(split_segundo_dna[i])) {
                
                resultado_dna++;
                diferencas[i] = split_primeiro_dna[i]+""+ split_segundo_dna[i] ;
                System.out.println(split_primeiro_dna[i]+""+ split_segundo_dna[i]);
            } 
        }
        input.close();
        System.out.println("A distância de Hamming é:"+resultado_dna);
    }
}
