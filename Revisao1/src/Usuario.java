import java.util.ArrayList;
import java.util.List;

abstract public class Usuario {
    private String nome;
    private String idUsuario;
    private List<Publicacao> pubEmprestadas = new ArrayList<>();

    public Usuario(String nome, String idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
    }

    abstract public int getMaxEmprestimos();

    public boolean podeEmprestar(){
        if (pubEmprestadas.size() <= getMaxEmprestimos()){
            return true;
        }
        return  false;
    }

    public void adicionarEmprestimo(Publicacao publicacao){
        pubEmprestadas.add(publicacao);
    }

    public void removerEmprestimo(Publicacao publicacao){
        pubEmprestadas.remove(publicacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Publicacao> getPubEmprestadas() {
        return pubEmprestadas;
    }

    public void setPubEmprestadas(List<Publicacao> pubEmprestadas) {
        this.pubEmprestadas = pubEmprestadas;
    }
}
