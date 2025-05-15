public abstract class Conta {
    private String numero;
    private String agencia;
    private String banco;
    private Cliente titular;
    private double saldo;

    public Conta(String numero, String agencia, String banco, Cliente titular) {
        this.numero  = numero;
        this.agencia = agencia;
        this.banco   = banco;
        this.titular = titular;
        this.saldo   = 0.0;
    }

    abstract public boolean sacar(double valor);

    public boolean depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, ContaCorrente destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
    public boolean transferir(double valor, ContaEmpresarial destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, ContaEspecial destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, ContaPoupanca destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public double extrato() {
        return getSaldo();
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }

    public String getNumero() {
        return numero;
    }
    public String getAgencia() {
        return agencia;
    }
    public String getBanco() {
        return banco;
    }
    public Cliente getTitular() {
        return titular;
    }
}
