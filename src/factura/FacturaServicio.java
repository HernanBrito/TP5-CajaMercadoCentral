package factura;

import interfaces.Agencia;

public class FacturaServicio extends Factura {
    private double valorFijo;
    public FacturaServicio(Agencia agencia, String concepto, double valorFijo) {
        super(agencia, concepto);
        this.valorFijo = valorFijo;
    }
    
    @Override
    public double getMonto() {
    	return this.valorFijo;
    }

    @Override
    public void registrar() {
        agencia.registrarPago(this);
    }
}