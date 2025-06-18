import java.util.ArrayList;
import java.util.List;

public class CarteiraInvestimentos {
    private Cliente cliente;
    private List<Investimento> investimentos;

    public CarteiraInvestimentos(Cliente cliente) {
        this.cliente = cliente;
        this.investimentos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void adicionarInvestimento(Investimento investimento) {
        if (!this.cliente.getIdentificadorDocumento().equals(investimento.getCliente().getIdentificadorDocumento())) {
            throw new IllegalArgumentException("O investimento não pertence a este cliente.");
        }
        this.investimentos.add(investimento);
    }

    public double calcularValorTotalInvestido() {
        double total = 0;
        for (Investimento inv : investimentos) {
            total += inv.getSaldo();
        }
        return total;
    }

    public void simularPassagemDeMesTodosInvestimentos() {
        for (Investimento inv : investimentos) {
            inv.simularPassagemDeMes();
        }
    }
}
