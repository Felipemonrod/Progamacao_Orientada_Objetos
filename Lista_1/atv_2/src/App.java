import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // calcular salario
        // input salario
        // quantidade de produtos vendidos
        //      para cada produto vendido bonus de 10 se >=20 bonus de 13
        // input dias faltados >= 15 descontar 15% do salario
        //
        Scanner input = new Scanner(System.in);  
        System.out.println("Digite seu salario");
        Double funcionario_salario = input.nextDouble();
        System.out.println("Digite quantidade de produtos");
        Integer quantidade_produtos = input.nextInt();
        System.out.println("Digite quantidade de faltas");
        Integer quantidade_faltas = input.nextInt();
        Double taxa;

        if (quantidade_faltas > 5) {
            taxa = funcionario_salario * 0.15;
            // poderia usar um -= iria dar o mesmo
            funcionario_salario = funcionario_salario - taxa;
        }
        if (quantidade_produtos <20) {
            funcionario_salario = funcionario_salario + (quantidade_produtos*10) ;
        } else if(quantidade_produtos >= 20){
            funcionario_salario = funcionario_salario + (quantidade_produtos*13) ;
        }
        System.out.println("Faltas:"+quantidade_faltas);
        System.out.println("Produtos:"+quantidade_produtos);
        System.out.println("Salario:"+funcionario_salario);

    }
}
