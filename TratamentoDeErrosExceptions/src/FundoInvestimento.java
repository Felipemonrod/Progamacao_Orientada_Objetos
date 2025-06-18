public class FundoInvestimento extends Investimento {
    private String nomeFundo;
    private String cnpjGestora;
    private double taxaAdministracaoAnual;
    private final double rendimentoMensalBruto = 0.01;

    public FundoInvestimento(Cliente cliente, double valorInicial, String nomeFundo, String cnpjGestora, double taxaAdministracaoAnual) {
        super(cliente, valorInicial);
        this.nomeFundo = nomeFundo;
        this.cnpjGestora = cnpjGestora;
        this.taxaAdministracaoAnual = taxaAdministracaoAnual;
    }

    public String getNomeFundo() {
        return nomeFundo;
    }

    public void setNomeFundo(String nomeFundo) {
        this.nomeFundo = nomeFundo;
    }

    public String getCnpjGestora() {
        return cnpjGestora;
    }

    public void setCnpjGestora(String cnpjGestora) {
        this.cnpjGestora = cnpjGestora;
    }

    public double getTaxaAdministracaoAnual() {
        return taxaAdministracaoAnual;
    }

    public void setTaxaAdministracaoAnual(double taxaAdministracaoAnual) {
        this.taxaAdministracaoAnual = taxaAdministracaoAnual;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double saldoProjetado = getSaldo();
        double taxaAdministracaoMensal = this.taxaAdministracaoAnual / 12.0;

        for (int i = 0; i < numeroMeses; i++) {
            double rendimentoBrutoMes = saldoProjetado * rendimentoMensalBruto;
            double taxaAdmDoMesProjetado = saldoProjetado * taxaAdministracaoMensal;
            saldoProjetado = saldoProjetado + rendimentoBrutoMes - taxaAdmDoMesProjetado;
        }
        return saldoProjetado;
    }

    @Override
    public void simularPassagemDeMes() {
        double saldoAtual = getSaldo();
        double rendimentoBruto = saldoAtual * rendimentoMensalBruto;
        double taxaAdmDevida = saldoAtual * (this.taxaAdministracaoAnual / 12.0);
        double novoSaldo = saldoAtual + rendimentoBruto - taxaAdmDevida;
        setSaldo(Math.max(0, novoSaldo));
    }
}
