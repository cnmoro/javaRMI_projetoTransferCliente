package cliente;

import interfaces.InterfaceServCli;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import serventes.ServenteCliente;

/**
 *
 * @author cnmoro
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            ClienteManager.criaId();

            Registry servicoNomes = LocateRegistry.getRegistry(1099);

            //Vincula a referencia do servidor
            InterfaceServCli interfaceServidor = (InterfaceServCli) servicoNomes.lookup("ReferenciaServenteServidorCli");

            //Cria servente do cliente com a referencia do servidor
            ServenteCliente serventeCliente = new ServenteCliente(interfaceServidor);

            Scanner input = new Scanner(System.in);

            //Mostar menu de opções
            while (true) {
                System.out.println("\n-- Opções --");
                System.out.println(
                        "Escolha:\n"
                        + "  1) Consultar lista de transfers\n"
                        + "  2) Realizar cotação\n"
                        + "  3) Reservar transfer\n"
                );

                int opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {
                    case 1:
                        serventeCliente.pedirListaTransfers();
                        break;
                    case 2:
                        System.out.println("Insira o número do transfer: ");
                        int numTransferCotacao = input.nextInt();
                        serventeCliente.pedirCotacao(numTransferCotacao, ClienteManager.clienteId);
                        break;
                    case 3:
                        System.out.println("Insira o número do transfer: ");
                        int numTransferReserva = input.nextInt();
                        serventeCliente.pedirReservaTransfer(numTransferReserva);
                        break;
                    default:
                        System.out.println("Opção inválida\n");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
