package producto;

public class ProductoDeCooperativa extends Producto {
	
	public ProductoDeCooperativa(String nombre, Double precioBase, int stock){
		super(nombre, precioBase, stock);
	}
	@Override
	public double getMonto() {
		return super.getMonto() * 0.9;
	}
}
