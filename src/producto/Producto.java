package producto;

import interfaces.Item;

public class Producto implements Item{
	
	private String nombre;
	private int stock;
	private double precioBase;
	final private double iva = 1.21;
	
	public Producto(String nombre, Double precioBase, int stock) {
		this.nombre = nombre;
		this.stock = stock;
		this.precioBase = precioBase;
	}
	
	public int getStock() {
		return stock;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public double getMonto() {
		return precioBase * iva;
	}
	
	public void registrar() {
		if(stock > 0) {
			stock--;
		}else {
	        throw new IllegalStateException("No hay stock disponible para el producto: " + nombre);
	    }
	}
	
}
