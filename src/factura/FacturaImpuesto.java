package factura;

import interfaces.Agencia;

public class FacturaImpuesto extends Factura {
    private double costoUnidad;
    private int cantidadUnidades;

    public FacturaImpuesto(Agencia agencia, String concepto, double costoUnidad, int cantidadUnidades) {
        super(agencia, concepto);
        this.costoUnidad = costoUnidad;
        this.cantidadUnidades = cantidadUnidades;
        this.monto = this.calcularMonto();
    }

    public double calcularMonto() {
        return costoUnidad * cantidadUnidades;
    }
}