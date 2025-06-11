public class PessoaJuridica extends Pessoa {
    String nomeRepresentante;
    String Cnpj;

    public PessoaJuridica(String nome, String telefone, String endereco, String nomeRepresentante, String Cnpj) {
        super(nome, telefone, endereco);
        this.nomeRepresentante = nomeRepresentante;
        this.Cnpj = Cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }
}
