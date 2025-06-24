public class Aluno extends Usuario {
    private String matricula;

    public Aluno(String nome, String idUsuario, String matricula) {
        super(nome, idUsuario);
        this.matricula = matricula;
    }

    @Override
    public int getMaxEmprestimos() {
        return 3;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
