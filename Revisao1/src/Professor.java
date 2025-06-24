public class Professor extends Usuario{
    private String departamento;

    public Professor(String nome, String idUsuario, String departamento) {
        super(nome, idUsuario);
        this.departamento = departamento;
    }

    @Override
    public int getMaxEmprestimos() {
        return 5;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
