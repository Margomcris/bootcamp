package com.ListaCompra;

import java.math.BigDecimal;

public class Producto {	
	    public String name;
	    public BigDecimal price;
	    public Impuesto impuesto;
	    Producto(String name, BigDecimal price, Impuesto impuesto) {
	        this.name = name;
	        this.price = price;
	        this.impuesto = impuesto;
	    }
	    
	    public enum Impuesto {
	        SUPERREDUCED(4), REDUCED(10), NORMAL(21);
	        public int percent;
	        private Impuesto(int percent) {
	            this.percent = percent;
	        }
	        public int getPercent() {
	            return percent;
	        }
	    }

}
