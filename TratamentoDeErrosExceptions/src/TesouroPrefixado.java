public class TesouroPrefixado extends Investimento {
    private String nomeTitulo;
    private double taxaJurosAnual;
    private final double percentualImpostoRenda = 0.15;

    public TesouroPrefixado(Cliente cliente, double valorInicial, String nomeTitulo, double taxaJurosAnual) {
        super(cliente, valorInicial);
        if (!(cliente instanceof PessoaFisica)) {
            throw new IllegalArgumentException("Tesouro Prefixado é exclusivo para Pessoa Física.");
        }
        this.nomeTitulo = nomeTitulo;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public String getNomeTitulo() {
        return nomeTitulo;
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double taxaJurosMensal = this.taxaJurosAnual / 12.0;
        double saldoBrutoProjetado = getSaldo() * Math.pow((1 + taxaJurosMensal), numeroMeses);
        double rendimentoBruto = saldoBrutoProjetado - getSaldo();
        double impostoDevido = rendimentoBruto * percentualImpostoRenda;
        return getSaldo() + rendimentoBruto - impostoDevido;
    }

    @Override
    public void simularPassagemDeMes() {
        double rendimentoMes = getSaldo() * (this.taxaJurosAnual / 12.0);
        setSaldo(getSaldo() + rendimentoMes);
    }
}
