public class AcaoBolsa extends Investimento {
    private String codigoAcao;
    private String nomeEmpresa;
    private double taxaCorretagemFixaMensal;
    private final double valorizacaoMensalMedia = 0.008;

    public AcaoBolsa(Cliente cliente, double valorInicial, String codigoAcao, String nomeEmpresa, double taxaCorretagemFixaMensal) {
        super(cliente, valorInicial);
        this.codigoAcao = codigoAcao;
        this.nomeEmpresa = nomeEmpresa;
        this.taxaCorretagemFixaMensal = taxaCorretagemFixaMensal;
    }

    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public double getTaxaCorretagemFixaMensal() {
        return taxaCorretagemFixaMensal;
    }

    public void setTaxaCorretagemFixaMensal(double taxaCorretagemFixaMensal) {
        this.taxaCorretagemFixaMensal = taxaCorretagemFixaMensal;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double saldoBrutoProjetado = getSaldo() * Math.pow((1 + valorizacaoMensalMedia), numeroMeses);
        double totalTaxasCorretagem = taxaCorretagemFixaMensal * numeroMeses;
        return Math.max(0, saldoBrutoProjetado - totalTaxasCorretagem);
    }

    @Override
    public void simularPassagemDeMes() {
        double saldoAtual = getSaldo();
        double valorizacao = saldoAtual * valorizacaoMensalMedia;
        double novoSaldo = saldoAtual + valorizacao - taxaCorretagemFixaMensal;
        setSaldo(Math.max(0, novoSaldo));
    }
}
