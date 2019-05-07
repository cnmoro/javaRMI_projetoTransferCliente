package serventes;

import interfaces.InterfaceCli;
import interfaces.InterfaceServCli;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author cnmoro
 */
public class ServenteCliente extends UnicastRemoteObject implements InterfaceCli {

    InterfaceServCli interfaceServer;

    public ServenteCliente(InterfaceServCli interfaceServer) throws RemoteException {
        this.interfaceServer = interfaceServer;
    }

    @Override
    public void receberNotificacao(String interesse) throws RemoteException {

    }

    @Override
    public void adicionarInteresse(String interesse) throws RemoteException {

    }

    @Override
    public void receberConfirmacaoReserva(String mensagem) throws RemoteException {
        System.out.println("Tentativa de reserva: " + mensagem);
    }

    @Override
    public void receberCotacoes(String cotacoes) throws RemoteException {
        System.out.println("Cotações recebidas: \n" + cotacoes);
    }

    public void pedirCotacoes() throws RemoteException {
        this.interfaceServer.exibirCotacoes(this);
    }

    public void pedirReservaTransfer(int id) throws RemoteException {
        this.interfaceServer.reservarTransfer(id, this);
    }

}
