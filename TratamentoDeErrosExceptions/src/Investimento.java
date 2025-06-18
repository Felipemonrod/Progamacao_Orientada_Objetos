public abstract class Investimento {
    private Cliente cliente;
    private double saldo;

    public Investimento(Cliente cliente, double valorInicial) {
        if (valorInicial < 0) {
            throw new IllegalArgumentException("O valor inicial do investimento não pode ser negativo.");
        }
        this.cliente = cliente;
        this.saldo = valorInicial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean aplicar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean resgatar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public abstract double calcularSaldoProjetado(int numeroMeses);

    public abstract void simularPassagemDeMes();
}
