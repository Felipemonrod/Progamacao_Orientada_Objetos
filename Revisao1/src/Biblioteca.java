import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Publicacao> publicacoes = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Biblioteca(List<Publicacao> publicacao, List<Usuario> usuarios) {
        this.publicacoes = publicacoes;
        this.usuarios = usuarios;
    }

    public void adicionarPublicacao(Publicacao publicacao){
        publicacoes.add(publicacao);
    }

    public void adcionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }



    public Publicacao  busarPublicacao (String titulo){
        for (Publicacao publicacao: this.publicacoes){
            if (publicacao.getTitulo().equalsIgnoreCase(titulo)){
                return publicacao;
            }
        }
        return null;
    }

    public Usuario buscarUsuario (String IdUsuario){
        for (Usuario usuario  : this.usuarios){
            if (usuario.getIdUsuario().equals(IdUsuario)){
                return usuario;
            }
        }
        return null;
    }

    public boolean realizarEmprestimo(String idUsuario, String tituloPublicado){
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            System.out.println("Erro: Usuário com ID '" + idUsuario + "' não encontrado.");
            return false; // Cláusula de guarda
        }

//        Publicacao publicacao = buscarPublicacao(tituloPublicacao);
//        if (publicacao == null) {
//            System.out.println("Erro: Publicação com título '" + tituloPublicacao + "' não encontrada.");
//            return false; // Cláusula de guarda
//        }
//
//        if (!publicacao.isDisponivel()) {
//            System.out.println("Erro: A publicação '" + publicacao.getTitulo() + "' não está disponível para empréstimo.");
//            return false; // Cláusula de guarda
//        }

        if (!usuario.podeEmprestar()) {
            System.out.println("Erro: O usuário '" + usuario.getNome() + "' atingiu o limite máximo de empréstimos.");
            return false; // Cláusula de guarda
        }

        // Se chegou até aqui, todas as condições de guarda foram satisfeitas
        if (publicacao.emprestar()) { // Este if é para a ação final, não uma guarda de erro de entrada
            usuario.adicionarEmprestimo(publicacao);
            System.out.println("Empréstimo realizado com sucesso para o usuário '" + usuario.getNome() + "' da publicação '" + publicacao.getTitulo() + "'.");
            return true;
        } else {
            // Isso seria um cenário de falha inesperada, se emprestar() tivesse lógicas adicionais
            System.out.println("Erro interno: Não foi possível emprestar a publicação '" + publicacao.getTitulo() + "'.");
            return false;
        }
    }
}
