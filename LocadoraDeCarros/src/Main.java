import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locadora locadora = new Locadora("Goiano's Rent a Car", "Morrinhos, GO", "(64) 99999-9999");

        criarDadosIniciais(locadora);

        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarVeiculo(scanner, locadora);
                        break;
                    case 2:
                        cadastrarCliente(scanner, locadora);
                        break;
                    case 3:
                        realizarEmprestimo(scanner, locadora);
                        break;
                    case 4:
                        finalizarEmprestimo(scanner, locadora);
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido para a opção.");
                scanner.nextLine();
                opcao = -1;
            }
            pressioneEnterParaContinuar(scanner);
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- SISTEMA DE LOCADORA DE VEÍCULOS ---");
        System.out.println("1. Cadastrar Novo Veículo");
        System.out.println("2. Cadastrar Novo Cliente");
        System.out.println("3. Realizar Empréstimo");
        System.out.println("4. Finalizar Empréstimo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarVeiculo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Cadastro de Veículo ---");
        System.out.print("Digite a marca: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo: ");
        String modelo = scanner.nextLine();
        
        CarroPopular novoCarro = new CarroPopular(marca, modelo, "XYZ-1234", 2024, 100.0, 50.0, true);
        locadora.getListaCarros().add(novoCarro);

        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void cadastrarCliente(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.print("Tipo de cliente (1 - Física, 2 - Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        
        if (tipo == 1) {
            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();
            PessoaFisica novoCliente = new PessoaFisica(nome, "Telefone", "Endereço", cpf);
            locadora.getClientes().add(novoCliente);
        } else {
            System.out.print("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();
            
            PessoaJuridica novoCliente = new PessoaJuridica(nome, "Telefone", "Endereço", cnpj, "Representante");
            locadora.getClientes().add(novoCliente);
        }
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void realizarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Realizar Empréstimo ---");

        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < locadora.getClientes().size(); i++) {
            System.out.println(i + " - " + locadora.getClientes().get(i).getNome());
        }
        System.out.print("Escolha o cliente pelo número: ");
        int clienteIndex = scanner.nextInt();

        System.out.println("\nVeículos disponíveis:");
        ArrayList<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo v : locadora.getListaCarros()) {
            if (v.isDisponivel()) {
                disponiveis.add(v);
            }
        }

        for (int i = 0; i < disponiveis.size(); i++) {
            System.out.println(i + " - " + disponiveis.get(i).getModelo() + " (" + disponiveis.get(i).getCategoria() + ")");
        }
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum carro disponível no momento.");
            return;
        }
        System.out.print("Escolha o veículo pelo número: ");
        int veiculoIndex = scanner.nextInt();
        scanner.nextLine();

        Pessoa clienteEscolhido = locadora.getClientes().get(clienteIndex);
        Veiculo veiculoEscolhido = disponiveis.get(veiculoIndex);
        locadora.realizaEmprestimo(clienteEscolhido, veiculoEscolhido);
    }

    private static void finalizarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Finalizar Empréstimo ---");

        ArrayList<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo e : locadora.getEmprestimos()) {
            if (e.isAtivo()) {
                ativos.add(e);
            }
        }

        if (ativos.isEmpty()) {
            System.out.println("Nenhum empréstimo ativo para finalizar.");
            return;
        }

        System.out.println("Empréstimos Ativos:");
        for (int i = 0; i < ativos.size(); i++) {
            Emprestimo e = ativos.get(i);
            System.out.println(i + " - Cliente: " + e.getCliente().getNome() + " | Veículo: " + e.getVeiculo().getModelo());
        }
        System.out.print("Escolha o empréstimo para finalizar: ");
        int emprestimoIndex = scanner.nextInt();

        System.out.print("Digite o número de renovações realizadas: ");
        int renovacoes = scanner.nextInt();
        scanner.nextLine();

        Emprestimo emprestimoEscolhido = ativos.get(emprestimoIndex);
        double valorFinal = emprestimoEscolhido.getVeiculo().calcularValorFinal(renovacoes);

        System.out.println("------------------------------------");
        System.out.printf("Valor total do aluguel: R$ %.2f\n", valorFinal);
        System.out.println("------------------------------------");

        emprestimoEscolhido.finalizar();
        emprestimoEscolhido.getVeiculo().setDisponivel(true);
        System.out.println("Empréstimo finalizado e veículo agora está disponível.");
    }

    private static void criarDadosIniciais(Locadora locadora) {
        locadora.getListaCarros().add(new CarroPopular("Fiat", "Mobi", "ABC-1111", 2023, 90.0, 45.0, true));
        locadora.getListaCarros().add(new Suv("Jeep", "Compass", "DEF-2222", 2024, 180.0, 90.0, 510, "4x4", "Diesel"));
        locadora.getListaCarros().add(new Luxo("Mercedes", "C180", "GHI-3333", 2025, 450.0, 200.0, 6, 455, true));

        locadora.getClientes().add(new PessoaFisica("Marcel", "(64) 1111-1111", "Rua A", "111.111.111-11"));
        locadora.getClientes().add(new PessoaJuridica("IF Goiano", "(64) 2222-2222", "Rodovia BR", "22.222.222/0001-22", "Prof. Alan"));
    }

    private static void pressioneEnterParaContinuar(Scanner scanner) {
        System.out.print("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
}