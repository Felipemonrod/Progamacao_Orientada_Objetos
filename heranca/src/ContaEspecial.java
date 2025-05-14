public class ContaEspecial extends Conta {
    private double chequeEspecial;

    public ContaEspecial(String numero, String agencia, String banco,
                         Cliente titular, double chequeEspecial) {
        super(numero, agencia, banco, titular);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }
    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && (getSaldo() + chequeEspecial) >= valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }
}
