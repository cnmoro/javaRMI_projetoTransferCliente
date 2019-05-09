package cliente;

import interfaces.InterfaceServCli;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;
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

            System.out.println("Cliente Rodando\n");

            //TimeUnit.SECONDS.sleep(4);
            System.out.println("Pedindo listagem dos transfers: \n");
            serventeCliente.pedirListaTransfers();

            TimeUnit.SECONDS.sleep(2);

            System.out.println("Pedindo cotação do transfer 1 \n");
            serventeCliente.pedirCotacao(1, ClienteManager.clienteId);

            //System.out.println("Pedindo cotação do transfer 2: \n");
            //serventeCliente.pedirCotacao(2);
            TimeUnit.SECONDS.sleep(15);

            serventeCliente.pedirReservaTransfer(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
