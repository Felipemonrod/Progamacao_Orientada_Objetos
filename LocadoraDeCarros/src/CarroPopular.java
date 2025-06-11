public class CarroPopular extends Veiculo {
    Boolean airCondicionado;

    public CarroPopular(String marca, String modelo, String placa, int ano, double valorLocacao, String categoria, double valorMulta, boolean disponivel, Boolean airCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, categoria, valorMulta, disponivel);
        this.airCondicionado = airCondicionado;
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

    public Boolean getAirCondicionado() {
        return airCondicionado;
    }

    public void setAirCondicionado(Boolean airCondicionado) {
        this.airCondicionado = airCondicionado;
    }

    @Override
    public String getCategoria() {
        return super.getCategoria();
    }
}
