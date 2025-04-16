public class Conta {
    private String numConta;
    private Titular titular;
    private Double saldo;

    public Conta(String numConta, String nome, String cpf) {
        this.numConta = numConta;
        this.titular = new Titular(nome, cpf);
        this.saldo = 0.0;
    }

    public void exibirExtrato(){
        System.out.println("----------+----------");
        System.out.println("Numero da Conta: "+this.numConta);
        System.out.println("Nome do Titular: "+ this.titular.getNome());
        System.out.println("Saldo em Conta:"+ this.saldo);
        System.out.println("----------+----------");
    }

    public boolean sacar(double valorSaque){
        if(this.saldo > 0 && this.saldo >= valorSaque){
            this.setSaldo(this.saldo - valorSaque);
            System.out.println("Saque realizado com sucesso, Novo Saldo: "+this.getSaldo());
            return true;
        }
        System.out.println("Impossivel realizar o saque, Saldo em Conta: "+this.getSaldo());
        return false;
    }

    public boolean depositar(double valorDeposito){
        if(valorDeposito > 0){
            this.setSaldo(this.saldo + valorDeposito);
            System.out.println("Deposito realizado com sucesso, Novo Saldo: "+this.getSaldo());
            return true;
        }
        System.out.println("Valor de deposito não aceito:" +valorDeposito);
        return false;
    }

    public String getNumConta() {
        return this.numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public Titular getTitular() {
        return this.titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
