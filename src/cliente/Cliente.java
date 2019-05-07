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
            Registry servicoNomes = LocateRegistry.getRegistry(1099);

            //Vincula a referencia do servidor
            InterfaceServCli interfaceServidor = (InterfaceServCli) servicoNomes.lookup("ReferenciaServenteServidorCli");

            //Cria servente do cliente com a referencia do servidor
            ServenteCliente serventeCliente = new ServenteCliente(interfaceServidor);

            System.out.println("Cliente Rodando\n");

            System.out.println("Pedindo listagem dos transfers: \n");
            serventeCliente.pedirListaTransfers();

            TimeUnit.SECONDS.sleep(2);

            serventeCliente.pedirCotacao(1);

            TimeUnit.SECONDS.sleep(2);

            serventeCliente.pedirReservaTransfer(2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
