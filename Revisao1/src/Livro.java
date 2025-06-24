public class Livro extends Publicacao{
    private String edicao;

    public Livro(String titulo, String autor, int anoPublicado, String edicao) {
        super(titulo, autor, anoPublicado);
        this.edicao = edicao;
    }

    @Override
    public double calcularMultaAtraso(int diasAtraso) {
        return diasAtraso * 2.5;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
}
