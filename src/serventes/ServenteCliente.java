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
    public void receberNotificacao(String mensagem) throws RemoteException {
        System.out.println("Notificação recebida: " + mensagem + "\n");
    }

    @Override
    public void receberCotacao(String cotacao) throws RemoteException {
        System.out.println("Cotação recebida: \n" + cotacao);
    }

    @Override
    public void receberConfirmacaoReserva(String mensagem) throws RemoteException {
        System.out.println("Tentativa de reserva: " + mensagem + "\n");
    }

    @Override
    public void receberListagemTransfers(String cotacoes) throws RemoteException {
        System.out.println("Transfers disponíveis: \n" + cotacoes);
    }

    public void pedirListaTransfers() throws RemoteException {
        this.interfaceServer.exibirTransfers(this);
    }

    public void pedirReservaTransfer(int id) throws RemoteException {
        this.interfaceServer.reservarTransfer(id, this);
    }

    public void pedirCotacao(int id) throws RemoteException {
        this.interfaceServer.realizarCotacao(id, this);
    }

}
