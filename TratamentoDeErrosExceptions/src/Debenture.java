public class Debenture extends Investimento {
    private String nomeEmpresaEmissora;
    private double taxaJurosAnualDebenture;
    private double percentualTributacaoPJ;

    public Debenture(Cliente cliente, double valorInicial, String nomeEmpresaEmissora, double taxaJurosAnualDebenture, double percentualTributacaoPJ) {
        super(cliente, valorInicial);
        if (!(cliente instanceof PessoaJuridica)) {
            throw new IllegalArgumentException("Debênture é exclusiva para Pessoa Jurídica.");
        }
        this.nomeEmpresaEmissora = nomeEmpresaEmissora;
        this.taxaJurosAnualDebenture = taxaJurosAnualDebenture;
        this.percentualTributacaoPJ = percentualTributacaoPJ;
    }

    public String getNomeEmpresaEmissora() {
        return nomeEmpresaEmissora;
    }

    public void setNomeEmpresaEmissora(String nomeEmpresaEmissora) {
        this.nomeEmpresaEmissora = nomeEmpresaEmissora;
    }

    public double getTaxaJurosAnualDebenture() {
        return taxaJurosAnualDebenture;
    }

    public void setTaxaJurosAnualDebenture(double taxaJurosAnualDebenture) {
        this.taxaJurosAnualDebenture = taxaJurosAnualDebenture;
    }

    public double getPercentualTributacaoPJ() {
        return percentualTributacaoPJ;
    }

    public void setPercentualTributacaoPJ(double percentualTributacaoPJ) {
        this.percentualTributacaoPJ = percentualTributacaoPJ;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double taxaJurosMensal = this.taxaJurosAnualDebenture / 12.0;
        double saldoBrutoProjetado = getSaldo() * Math.pow((1 + taxaJurosMensal), numeroMeses);
        double rendimentoBruto = saldoBrutoProjetado - getSaldo();
        double impostoDevido = rendimentoBruto * percentualTributacaoPJ;
        return getSaldo() + rendimentoBruto - impostoDevido;
    }

    @Override
    public void simularPassagemDeMes() {
        double rendimentoMes = getSaldo() * (this.taxaJurosAnualDebenture / 12.0);
        setSaldo(getSaldo() + rendimentoMes);
    }
}
