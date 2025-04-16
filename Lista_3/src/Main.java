import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Conta> banco = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        boolean aux;
        
        while (true) {
            System.out.println("----------=-=----------");
            System.out.println("Digite um numero para selecionar uma opção abaixo:");
            System.out.println("1: Criar Conta");
            System.out.println("2: Exibir Extrato");
            System.out.println("3: Sacar");
            System.out.println("4: Depositar");
            System.out.println("5: Transferir");
            System.out.println("----------=-=----------");
            int controle = scan.nextInt();
            scan.nextLine();
            String numConta;
            switch (controle) {
                case 1://Criar Conta
                    System.out.println("----------=-=----------");
                    System.out.println("Digite seu nome:");
                    String nome = scan.nextLine();
                    System.out.println("Digite seu cpf:");
                    String cpf = scan.nextLine();
                    numConta = banco.size() + 1 +"";
                    Conta novaConta = new Conta(numConta, nome, cpf);
                    novaConta.exibirExtrato();
                    banco.add(novaConta);
                    break;
                case 2://Exibir Extrato
                    if(banco.size() == 0){
                        System.out.println("Nenhuma conta cadastrada");
                        break;
                    }
                    System.out.println("----------=-=----------");
                    System.out.println("Digite o numero da Conta:");
                    numConta = scan.nextLine();
                    aux = false;
                    for (Conta conta : banco) {
                        if(conta.getNumConta().equals(numConta)){
                            conta.exibirExtrato();
                            aux = true;
                            break;
                        }
                    }
                    
                    if(aux == false){
                        System.out.println("Nenhuma conta encontrada com o numero: "+numConta);
                    }

                    break;
                case 3://Sacar
                    if(banco.size() == 0){
                        System.out.println("Nenhuma conta cadastrada");
                        break;
                    }
                    System.out.println("----------=-=----------");
                    System.out.println("Digite o numero da Conta:");
                    numConta = scan.nextLine();
                    aux = false;
                    for (Conta conta : banco) {
                        if(conta.getNumConta().equals(numConta)){
                            System.out.println("Digite o valor do Saque: ");
                            double saque = scan.nextDouble();
                            scan.nextLine();
                            conta.sacar(saque);
                            aux = true;
                            break;
                        }
                    }

                    if(aux == false){
                        System.out.println("Nenhuma conta encontrada com o numero: "+numConta);
                    }
                    break;
                case 4://Depositar
                    if(banco.size() == 0){
                        System.out.println("Nenhuma conta cadastrada");
                        break;
                    }
                    System.out.println("----------=-=----------");
                    System.out.println("Digite o numero da Conta:");
                    numConta = scan.nextLine();
                    aux = false;
                    for (Conta conta : banco) {
                        if(conta.getNumConta().equals(numConta)){
                            System.out.println("Digite o valor do Deposito: ");
                            double deposito = scan.nextDouble();
                            scan.nextLine();
                            conta.depositar(deposito);
                            aux = true;
                            break;
                        }
                    }
                    if(aux == false){
                        System.out.println("Nenhuma conta encontrada com o numero: "+numConta);
                    }
                    
                    break;
                case 5://Transferir
                    if(banco.size() == 0){
                        System.out.println("Nenhuma conta cadastrada");
                        break;
                    }
                    System.out.println("----------=-=----------");
                    System.out.println("Digite o numero da sua Conta:");
                    numConta = scan.nextLine();

                    boolean contaA = false;
                    boolean contaB = false;

                    for (Conta contaEnvio : banco) { 
                        if(contaEnvio.getNumConta().equals(numConta)){
                            contaA = true;
                            System.out.println("Digite o numero da outra Conta:");
                            numConta = scan.nextLine();

                            for (Conta contaRecebimento: banco) {
                                if(contaRecebimento.getNumConta().equals(numConta)){
                                    contaB = true;
                                    System.out.println("Informe o valor para transferencia:");
                                    double valorTransferencia = scan.nextDouble();
                                    scan.nextLine();
                                    if(valorTransferencia > 0){
                                        contaEnvio.sacar(valorTransferencia);
                                        contaRecebimento.depositar(valorTransferencia);
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }

                    if(contaA == false){
                        System.out.println("A conta de envio não foi encontrada");
                    }

                    if(contaB == false){
                        System.out.println("A conta de recebimento não foi encontrada");
                    }
                    break;
                default:
                    System.out.println("----------=X=----------");
                    System.out.println("Opção invalida, tente novamente");
                    break;
            }
        }
    }
}