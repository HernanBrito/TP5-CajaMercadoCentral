package caja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import agencia.AgenciaDummy;
import factura.FacturaImpuesto;
import factura.FacturaServicio;
import producto.Producto;
import producto.ProductoDeCooperativa;

class CajaTest {
    private Producto arroz;
    private Producto detergente;
    private Caja caja;
    private ProductoDeCooperativa carne;
    private FacturaImpuesto facturaImpuesto;
    private FacturaServicio facturaServicio;
    private AgenciaDummy agencia;
    
    @BeforeEach
    public void setUp() {
        agencia = new AgenciaDummy();
        caja = new Caja();
        
        arroz = new Producto("Arroz", 100d, 10);
        
        detergente = new Producto("Detergente",150d,5);
        
        carne = new ProductoDeCooperativa("Carne", 200d, 8);
        // Configurar facturas
        facturaImpuesto = new FacturaImpuesto(agencia, "Impuesto municipal", 50, 3);
        facturaServicio = new FacturaServicio(agencia, "Servicio de luz", 350);
    }
    
    @Test
    void testAgregarItem() {
        caja.agregarItem(arroz);
        caja.agregarItem(carne);
        assertEquals(2, caja.getCantidadDeItems());
    }
    
    @Test
    void testGetMontoConProductos() {
        caja.agregarItem(arroz);
        caja.agregarItem(detergente);
        
        double expected = (100 * 1.21) + (150 * 1.21);
        assertEquals(expected, caja.getMonto(), 0.001);
    }
    
    @Test
    void testGetMontoConProductoDeCooperativa() {
        caja.agregarItem(carne);
        
        double expected = (200 * 1.21) * 0.9;
        assertEquals(expected, caja.getMonto(), 0.001);
    }
    
    @Test
    void testGetMontoConFacturas() {
        caja.agregarItem(facturaImpuesto);
        caja.agregarItem(facturaServicio);
        
        double expected = (50 * 3) + 350;
        assertEquals(expected, caja.getMonto(), 0.001);
    }
    
    @Test
    void testGetMontoMezclado() {
        caja.agregarItem(arroz);
        caja.agregarItem(facturaServicio);
        caja.agregarItem(carne);
        
        double expected = (100 * 1.21) + 350 + ((200 * 1.21) * 0.9);
        assertEquals(expected, caja.getMonto(), 0.001);
    }
    
    @Test
    void testRegistrarProductos() {
        caja.agregarItem(arroz);
        caja.agregarItem(detergente);
        caja.registrar();
        
        assertEquals(9, arroz.getStock());
        assertEquals(4, detergente.getStock());
    }
    
    @Test
    void testRegistrarFacturas() {
        caja.agregarItem(facturaImpuesto);
        caja.agregarItem(facturaServicio);
        
        assertEquals(2 , caja.getCantidadDeItems());
        //assertDoesNotThrow(() -> caja.registrar());
    }
    
    @Test
    void testInformarTotal() {
        caja.agregarItem(arroz);
        caja.agregarItem(facturaServicio);
        
        String expected = "Monto total de la transacción es: " + ((100 * 1.21) + 350);
        assertEquals(expected, caja.informarTotal());
    }
    
    @Test
    void testCajaVacia() {
        assertEquals(0, caja.getMonto(), 0.001);
        assertEquals("Monto total de la transacción es: 0.0", caja.informarTotal());
    }
}