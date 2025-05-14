public class ContaCorrente extends Conta {

    public ContaCorrente(String numero, String agencia, String banco, PessoaFisica titular) {
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
}
