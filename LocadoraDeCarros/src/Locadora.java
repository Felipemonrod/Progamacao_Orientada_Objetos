import java.util.ArrayList;

public class Locadora {
    String nome;
    String endereco;
    String telefone;
    private ArrayList<Veiculo> listaCarros;
    private ArrayList<Pessoa> clientes;
    private ArrayList<Emprestimo> emprestimos;
    private boolean ativo;

    public Locadora(String nome, String endereco, String telefone, ArrayList<Veiculo> listaCarros, ArrayList<Pessoa> clientes, ArrayList<Emprestimo> emprestimos, boolean ativo) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.listaCarros = listaCarros;
        this.clientes = clientes;
        this.emprestimos = emprestimos;
        this.ativo = ativo;
    }

    public void realizaEmprestimo(Pessoa cliente, Veiculo veiculo){

        if (!veiculo.isDisponivel()) {
            System.out.println("Erro: O veículo " + veiculo.getModelo() + " não está disponível.");
            return;
        }

        if (cliente instanceof PessoaFisica) {
            for (Emprestimo emprestimo : this.emprestimos) {
                if (emprestimo.getCliente() == cliente && emprestimo.isAtivo()) {
                    System.out.println("Erro: Cliente " + cliente.getNome() + " já possui um empréstimo ativo.");
                    return;
                }
            }
        }

        Emprestimo novoEmprestimo = new Emprestimo(cliente, veiculo);
        this.emprestimos.add(novoEmprestimo);

        veiculo.setDisponivel(false);
        System.out.println("Empréstimo realizado com sucesso!");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Veiculo> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(ArrayList<Veiculo> listaCarros) {
        this.listaCarros = listaCarros;
    }

    public ArrayList<Pessoa> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Pessoa> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
