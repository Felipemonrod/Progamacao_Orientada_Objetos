public class Luxo extends Veiculo{
    int quantidadeAirBag;
    int tamanhoPortaMala;
    boolean gpsIntegrado;


    public Luxo(String marca, String modelo, String placa, int ano, double valorLocacao, String categoria, double valorMulta, boolean disponivel, int quantidadeAirBag, int tamanhoPortaMala, boolean gpsIntegrado) {
        super(marca, modelo, placa, ano, valorLocacao, categoria, valorMulta, disponivel);
        this.quantidadeAirBag = quantidadeAirBag;
        this.tamanhoPortaMala = tamanhoPortaMala;
        this.gpsIntegrado = gpsIntegrado;
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

    public int getQuantidadeAirBag() {
        return quantidadeAirBag;
    }

    public void setQuantidadeAirBag(int quantidadeAirBag) {
        this.quantidadeAirBag = quantidadeAirBag;
    }

    public int getTamanhoPortaMala() {
        return tamanhoPortaMala;
    }

    public void setTamanhoPortaMala(int tamanhoPortaMala) {
        this.tamanhoPortaMala = tamanhoPortaMala;
    }

    public boolean isGpsIntegrado() {
        return gpsIntegrado;
    }

    public void setGpsIntegrado(boolean gpsIntegrado) {
        this.gpsIntegrado = gpsIntegrado;
    }

    @Override
    public String getCategoria() {
        return super.getCategoria();
    }
}
