package agencia;

import factura.Factura;
import interfaces.Agencia;

public class AgenciaDummy implements Agencia {

    public void registrarPago(Factura factura) {
        System.out.println("Registrando pago en agencia: " + factura);
    }
}

