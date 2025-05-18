package factura;

import interfaces.Agencia;
import interfaces.Item;

public abstract class Factura implements Item {
    protected Agencia agencia;
    protected String concepto;
    protected double monto;

    public Factura(Agencia agencia, String concepto) {
        this.agencia = agencia;
        this.concepto = concepto;
    }
    
    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public void registrar() {
        agencia.registrarPago(this);
    }
    
    
}
