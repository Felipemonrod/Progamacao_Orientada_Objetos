public class Emprestimo {
    private Pessoa cliente;
    private Veiculo veiculo;
    private int numeroRenovacoes;
    private boolean ativo;

    public Emprestimo(Pessoa cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.numeroRenovacoes = 0;
        this.ativo = true;        
    }

    public void registrarRenovacao() {
        this.numeroRenovacoes++;
    }

    public void finalizar() {
        this.ativo = false;
    }

    public Pessoa getCliente() {
        return this.cliente;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public int getNumeroRenovacoes() {
        return this.numeroRenovacoes;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}