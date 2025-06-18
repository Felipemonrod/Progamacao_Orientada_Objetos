import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Instanciar objetos de PessoaFisica e PessoaJuridica
        System.out.println("--- Criando Clientes ---");
        PessoaFisica pf1 = new PessoaFisica("Alice Silva", "alice.silva@email.com", "111.222.333-44");
        PessoaJuridica pj1 = new PessoaJuridica("Empresa ABC Ltda.", "contato@empresaabc.com", "00.111.222/0001-33");

        System.out.println("Cliente Pessoa Física: " + pf1.getNome() + " (" + pf1.getIdentificadorDocumento() + ")");
        System.out.println("Cliente Pessoa Jurídica: " + pj1.getNome() + " (" + pj1.getIdentificadorDocumento() + ")");

        // 2. Criar uma CarteiraInvestimentos para cada cliente
        System.out.println("\n--- Criando Carteiras de Investimento ---");
        CarteiraInvestimentos carteiraPF = new CarteiraInvestimentos(pf1);
        CarteiraInvestimentos carteiraPJ = new CarteiraInvestimentos(pj1);
        System.out.println("Carteira criada para " + carteiraPF.getCliente().getNome());
        System.out.println("Carteira criada para " + carteiraPJ.getCliente().getNome());

        // 3. Criar instâncias dos diferentes produtos de investimento e adicionar à carteira
        System.out.println("\n--- Adicionando Investimentos ---");

        // Investimentos para Pessoa Física (pf1)
        TesouroPrefixado tesouroPF = null;
        AcaoBolsa acaoPF = null;
        FundoInvestimento fundoPF = null;

        try {
            tesouroPF = new TesouroPrefixado(pf1, 10000.0, "Tesouro Prefixado 2029", 0.10);
            carteiraPF.adicionarInvestimento(tesouroPF);

            acaoPF = new AcaoBolsa(pf1, 5000.0, "VALE3", "Vale S.A.", 8.50);
            carteiraPF.adicionarInvestimento(acaoPF);

            fundoPF = new FundoInvestimento(pf1, 7500.0, "Fundo Renda Fixa Top", "12.345.678/0001-99", 0.015);
            carteiraPF.adicionarInvestimento(fundoPF);

            // Teste de restrição de tipo de cliente (deve lançar IllegalArgumentException)
            System.out.println("\n--- Tentando adicionar investimento inválido (Tesouro para PJ) ---");
            try {
                TesouroPrefixado tesouroInvalido = new TesouroPrefixado(pj1, 100.0, "Tesouro PJ", 0.05);
                carteiraPJ.adicionarInvestimento(tesouroInvalido);
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO ESPERADO: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao inicializar investimento para Pessoa Física: " + e.getMessage());
        }

        // Investimentos para Pessoa Jurídica
        Debenture debenturePJ = null;
        FundoInvestimento fundoPJ = null;

        try {
            debenturePJ = new Debenture(pj1, 20000.0, "Debenture XYZ Corp", 0.12, 0.20);
            carteiraPJ.adicionarInvestimento(debenturePJ);

            fundoPJ = new FundoInvestimento(pj1, 15000.0, "Fundo Corporativo Alpha", "98.765.432/0001-11", 0.01);
            carteiraPJ.adicionarInvestimento(fundoPJ);

            // Teste de restrição de tipo de cliente (deve lançar IllegalArgumentException)
            System.out.println("\n--- Tentando adicionar investimento inválido (Debênture para PF) ---");
            try {
                Debenture debentureInvalida = new Debenture(pf1, 100.0, "Debenture PF", 0.08, 0.10);
                carteiraPF.adicionarInvestimento(debentureInvalida);
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO ESPERADO: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao inicializar investimento para Pessoa Jurídica: " + e.getMessage());
        }


        System.out.println("\n--- Demonstrando Aplicação e Resgate ---");
        if (tesouroPF != null) {
            tesouroPF.aplicar(500.0);
            tesouroPF.resgatar(200.0);
            tesouroPF.resgatar(20000.0);
        }
        if (acaoPF != null) {
            acaoPF.aplicar(1000.0);
            acaoPF.resgatar(500.0);
        }

        // 5. Simular a passagem de alguns meses e exibir saldos e patrimônio total
        System.out.println("\n--- Simulação de Meses ---");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- Mês " + i + " ---");
            carteiraPF.simularPassagemDeMesTodosInvestimentos();
            carteiraPJ.simularPassagemDeMesTodosInvestimentos();

            System.out.println("\nPatrimônio Total de " + pf1.getNome() + ": " + String.format("%.2f", carteiraPF.calcularValorTotalInvestido()));
            System.out.println("Patrimônio Total de " + pj1.getNome() + ": " + String.format("%.2f", carteiraPJ.calcularValorTotalInvestido()));
        }

        // Testar calcularSaldoProjetado para alguns investimentos
        System.out.println("\n--- Testando Saldo Projetado ---");
        if (tesouroPF != null) {
            System.out.println("Saldo Projetado Tesouro Prefixado (6 meses): " + String.format("%.2f", tesouroPF.calcularSaldoProjetado(6)));
        }
        if (acaoPF != null) {
            System.out.println("Saldo Projetado Ação Bolsa (12 meses): " + String.format("%.2f", acaoPF.calcularSaldoProjetado(12)));
        }
        if (fundoPJ != null) {
            System.out.println("Saldo Projetado Fundo Investimento (3 meses): " + String.format("%.2f", fundoPJ.calcularSaldoProjetado(3)));
        }
        if (debenturePJ != null) {
            System.out.println("Saldo Projetado Debênture (9 meses): " + String.format("%.2f", debenturePJ.calcularSaldoProjetado(9)));
        }

        scanner.close();
    }
}
