package jumpers.delta.sistemasparainter.net.appdelta.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anderson on 04/06/2017.
 */

public class ClienteSingleton {

    private static ClienteSingleton instance = null;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    private String idCliente;

    private ClienteSingleton () {}

    public static ClienteSingleton getInstance () {
        if (instance == null)
            instance = new ClienteSingleton();
        return instance;

    }


}
