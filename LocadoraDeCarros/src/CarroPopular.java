public class CarroPopular extends Veiculo {
    Boolean airCondicionado;
    String categoria;


    public CarroPopular(String marca, String modelo, String placa, int ano, double valorLocacao) {
        super(marca, modelo, placa, ano, valorLocacao, );
    }

    public Boolean getAirCondicionado() {
        return airCondicionado;
    }

    public void setAirCondicionado(Boolean airCondicionado) {
        this.airCondicionado = airCondicionado;
    }

    public void setCategoria(String categoria) {
        this.categoria = "Popular";
    }
}
