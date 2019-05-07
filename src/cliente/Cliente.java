package cliente;

import interfaces.InterfaceServCli;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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

            serventeCliente.pedirCotacoes();
            
            System.out.println("Cliente Rodando");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
