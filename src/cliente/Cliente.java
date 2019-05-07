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
            
            serventeCliente.pedirCotacoes();
            
            TimeUnit.SECONDS.sleep(3);
            
            serventeCliente.pedirReservaTransfer(1);
            
            TimeUnit.SECONDS.sleep(2);
            
            serventeCliente.pedirCotacoes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
