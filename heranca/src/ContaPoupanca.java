public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 0.005;

    public ContaPoupanca(String numero, String agencia, String banco, PessoaFisica titular) {
        super(numero, agencia, banco, titular);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    public void rendimento() {
        double novoSaldo = getSaldo() + (getSaldo() * TAXA_RENDIMENTO);
        setSaldo(novoSaldo);
    }
}
