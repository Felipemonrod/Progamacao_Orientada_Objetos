public  class Emprestimo {
    private Pessoa cliente;
    private Veiculo veiculo;
    private int numeroRenovacoes;
    private boolean ativo;

    public Emprestimo(Pessoa cliente, Veiculo veiculo, int numeroRenovacoes, boolean ativo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.numeroRenovacoes = numeroRenovacoes;
        this.ativo = ativo;
    }

    public void registrarRenovacao() {
        this.numeroRenovacoes++;
    }

    public void finalizar() {
        this.ativo = false;
    }
}