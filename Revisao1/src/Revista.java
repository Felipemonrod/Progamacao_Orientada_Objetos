public class Revista extends Publicacao {
    private int numeroEdicao;

    public Revista(String titulo, String autor, int anoPublicado, int numeroEdicao) {
        super(titulo, autor, anoPublicado);
        this.numeroEdicao = numeroEdicao;
    }

    @Override
    public double calcularMultaAtraso(int diasAtraso) {
        return 0;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }
}
