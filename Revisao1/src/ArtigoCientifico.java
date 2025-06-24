public class ArtigoCientifico extends Publicacao{
    private String nomeConferencia;
    private String dai;

    public ArtigoCientifico(String titulo, String autor, int anoPublicado, String nomeConferencia, String dai) {
        super(titulo, autor, anoPublicado);
        this.nomeConferencia = nomeConferencia;
        this.dai = dai;


    }

    @Override
    public double calcularMultaAtraso(int diasAtraso) {
        double multaBase = diasAtraso * 5;
        if (multaBase > 50.0){
            return 50.0;
        }
        return multaBase;
    }

    @Override
    public String getTipo() {
        return "Artigo Cientifico";
    }

    public String getNomeConferencia() {
        return nomeConferencia;
    }

    public void setNomeConferencia(String nomeConferencia) {
        this.nomeConferencia = nomeConferencia;
    }

    public String getDai() {
        return dai;
    }

    public void setDai(String dai) {
        this.dai = dai;
    }
}
