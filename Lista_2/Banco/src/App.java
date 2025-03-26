public class App {
    public static void main(String[] args){
        ContaCorrente conta1 = new ContaCorrente(1, 12, "Felipe", 1000);
        ContaCorrente conta2 = new ContaCorrente(2, 12, "Thiago", 5000);

        conta1.Deposito(500);
        System.out.println(conta1.getSaldo());
        conta2.Saque(2500);
        System.out.println(conta2.getSaldo());
        conta2.Transferencia(conta1, 2501);
        System.out.println(conta1.getSaldo());
    }
}
