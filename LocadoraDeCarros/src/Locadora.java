public class Locadora {
    String nome;
    String endereco;
    String telefone;
    String[] listaCarros; // provavel poli
    String[] clientes; // provavel poli
    int[] emprestimos; // provavel poli

    public Locadora(String nome, String endereco, String telefone, String[] listaCarros, String[] clientes, int[] emprestimos) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.listaCarros = listaCarros;
        this.clientes = clientes;
        this.emprestimos = emprestimos;
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

    public String[] getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(String[] listaCarros) {
        this.listaCarros = listaCarros;
    }

    public String[] getClientes() {
        return clientes;
    }

    public void setClientes(String[] clientes) {
        this.clientes = clientes;
    }

    public int[] getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(int[] emprestimos) {
        this.emprestimos = emprestimos;
    }
}
