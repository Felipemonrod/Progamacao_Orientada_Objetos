import java.util.Scanner;

public class ContaCorrente {
    /*
     * Ter informações basicas de uma conta e do titular
     * 
     * 3 metodos:
     * Sacar, depositar, trasnferir
     * 
     * obs o saldo da conta não pode ser negativo {se for negativo cancele operação}
     */
    private int numeroDaConta;
    private int agencia;
    private String nomeTitular; 
    private double saldo;

    public ContaCorrente( int numeroDaConta, int agencia, String nomeTitular, double saldo){
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }
    
    //Transferencia
    public void Transferencia(ContaCorrente contaCorrente, double valorTransferido){
        if (this.saldo > 0 && this.saldo >= valorTransferido) {
            this.saldo = this.saldo - valorTransferido;
            contaCorrente.setSaldo(valorTransferido + contaCorrente.getSaldo());
            System.out.println("Transferencia realizada");
        }else{
            System.out.println("Trasnferencia recusada");
        }
    }

    public void Deposito(double valorDeposito){
        if (valorDeposito > 0) {
            this.saldo = this.saldo + valorDeposito;
            System.out.println("Deposito realizado");
        }else{
            System.out.println("Deposito recusado");
        }    
    }

    public void Saque(double valorSacado){
        if (this.saldo > 0 && this.saldo >= valorSacado) {
            this.saldo = saldo - valorSacado;
            System.out.println("Saque efetuado");
        }else{
            System.out.println("Saque recusado");
        }
    }


    public int getNumeroDaConta() {
        return this.numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNomeTitular() {
        return this.nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



}
