abstract public class Publicacao {
    private String titulo;
    private String autor;
    private int anoPublicado;
    private boolean disponivel;

    public Publicacao(String titulo, String autor, int anoPublicado) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = anoPublicado;
        this.disponivel = true;
    }

    abstract public double calcularMultaAtraso(int diasAtraso);

    abstract public String getTipo();

    public boolean emprestar(){
        if (disponivel){
            disponivel = false;
            return true;
        }
        return false;
    };

    public boolean devolver(){
        if (!disponivel){
            disponivel = true;
            return true;
        }
        return  false;
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(int anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public boolean isDisponivel() {
        return disponivel;
    }


}
