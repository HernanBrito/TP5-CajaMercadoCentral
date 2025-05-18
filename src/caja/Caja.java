package caja;

import java.util.List;

import interfaces.Item;

import java.util.ArrayList;

public class Caja implements Item{
	private List<Item> items = new ArrayList<>();
	
    public void agregarItem(Item item) {
        items.add(item);
    }
    
    public int getCantidadDeItems() {
    	return items.size();
    }
    
    public double getMonto() {
        double total = 0;
        for (Item item : items) {
            total += item.getMonto();
        }
        return total;
    }
    
    public void registrar() {
        for (Item item : items) {
            item.registrar();
        }
    }
    
    
    //Lo pense como void pero hago que retorne un string para testear
    //La idea principal es que le informe al cliente el total y que el cliente se encargue de la logica de pago
    //o lo que se vaya a manejar
    public String informarTotal() {
    	return ("Monto total de la transacción es: " + this.getMonto());
    }
    
}
