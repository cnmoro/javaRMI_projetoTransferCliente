package cliente;

import java.util.Random;

/**
 *
 * @author cnmoro
 */
public class ClienteManager {

    public static int clienteId;

    public static void criaId() {
        Random r = new Random();
        clienteId = r.nextInt((9999 - 1) + 1) + 1;
    }
}
