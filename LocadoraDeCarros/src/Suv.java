public class Suv extends Veiculo {
    int tamanoPortaMala;
    String tipoTracao;
    String combustivel;


    public Suv(String marca, String modelo, String placa, int ano, double valorLocacao, String categoria, double valorMulta, boolean disponivel, int tamanoPortaMala, String tipoTracao, String combustivel) {
        super(marca, modelo, placa, ano, valorLocacao, categoria, valorMulta, disponivel);
        this.tamanoPortaMala = tamanoPortaMala;
        this.tipoTracao = tipoTracao;
        this.combustivel = combustivel;
    }

    @Override
    public double calcularValorFinal(int numeroRenovacoes) {
        double valorTotal = getValorLocacao();
        int renovacoesPagas = 0;

        if (numeroRenovacoes > 1) { // Popular tem 1 renovação grátis
            renovacoesPagas = numeroRenovacoes - 1;
        }

        valorTotal += renovacoesPagas * getValorMulta();
        return valorTotal;
    }

    public int getTamanoPortaMala() {
        return tamanoPortaMala;
    }

    public void setTamanoPortaMala(int tamanoPortaMala) {
        this.tamanoPortaMala = tamanoPortaMala;
    }

    public String getTipoTracao() {
        return tipoTracao;
    }

    public void setTipoTracao(String tipoTracao) {
        this.tipoTracao = tipoTracao;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
}
