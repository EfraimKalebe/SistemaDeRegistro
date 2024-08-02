import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeRegistro {
    private ArrayList<Cliente> clientes;

    public SistemaDeRegistro(){
        clientes = new ArrayList<>();
    }
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso! ");

    }

    public void removerCliente(String nome){
        Cliente clienteARemover = null;
        for (Cliente cliente: clientes){
            if ( cliente.getNome().equalsIgnoreCase(nome)) {
                clienteARemover = cliente;

            }
        }

        if (clienteARemover != null){
            clientes.remove(clienteARemover);
            System.out.println("Cliente removido com sucesso!");
        }else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente registrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }


    public static void main(String[] args) {
        SistemaDeRegistro sistema = new SistemaDeRegistro();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Adcionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção:  ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nome, email, telefone);
                    sistema.adicionarCliente(novoCliente);
                    break;
                case 2:
                    System.out.print("Nome do cliente a remover: ");
                    String nomeParaRemover = scanner.nextLine();
                    sistema.removerCliente(nomeParaRemover);
                    break;
                case 3:
                    sistema.listarClientes();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}