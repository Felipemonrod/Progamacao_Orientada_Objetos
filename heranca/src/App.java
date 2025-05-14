public class App {
    public static void main(String[] args) {
        PessoaFisica felipe = new PessoaFisica("Felipe", "123.456.789-00", "9999-9999");
        PessoaFisica thiago = new PessoaFisica("Thiago", "987.654.321-00", "9888-8888");
        ContaCorrente conta1 = new ContaCorrente("1", "12", "BancoX", felipe);
        ContaCorrente conta2 = new ContaCorrente("2", "12", "BancoX", thiago);
        
        conta1.depositar(1000);
        conta1.depositar(500);
        System.out.println("Saldo conta1 (após depósitos): R$ " + conta1.extrato());
        conta2.depositar(5000);

        boolean saqueOK = conta2.sacar(2500);
        System.out.println("Saque de R$ 2500 em conta2 " + (saqueOK ? "foi realizado" : "falhou"));
        System.out.println("Saldo conta2 (após saque): R$ " + conta2.extrato());

        boolean transfOK = conta2.transferir(2501, conta1);
        System.out.println("Transferência de R$ 2501 de conta2 para conta1 " + (transfOK ? "foi realizada" : "falhou"));
        System.out.println("Saldo conta1 (após tentativa de transferência): R$ " + conta1.extrato());
        System.out.println("Saldo conta2 (após tentativa de transferência): R$ " + conta2.extrato());
    }
}
