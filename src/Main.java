import controller.QualidadeArController;
import model.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QualidadeArController controller = new QualidadeArController();
        Usuario usuarioAtual = null;

        while (true) {
            System.out.println("\n=== VigiAr ===");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Registrar medição");
            System.out.println("3. Listar usuários");
            System.out.println("4. Listar medições");
            System.out.println("5. Listar alertas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Grupo de risco? (true/false): ");
                    boolean risco = scanner.nextBoolean();
                    scanner.nextLine();
                    usuarioAtual = new Usuario(nome, idade, risco);
                    controller.cadastrarUsuario(nome, idade, risco);
                    break;
                case 2:
                    if (usuarioAtual == null) {
                        System.out.println("Cadastre um usuário primeiro.");
                        break;
                      }
                    System.out.print("Localização: ");
                    String local = scanner.nextLine();
                    System.out.print("PM2.5: ");
                    double pm25 = scanner.nextDouble();
                    scanner.nextLine();
                    controller.registrarMedicao(usuarioAtual, local, pm25);
                    break;
                case 3:
                    controller.listarUsuarios();
                    break;
                case 4:
                    controller.listarMedicoes();
                    break;
                case 5:
                    controller.listarAlertas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
