package com.ListaCompra;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ListaCompra.Producto.Impuesto;


public class ListaCompraApplication {

	public static void main(String[] args) {
		List<Producto> carroCompra = List.of(
				new Producto("Clothes", new BigDecimal("15.90"),Impuesto.NORMAL),
				new Producto("Bread", new BigDecimal("1.5"),Impuesto.SUPERREDUCED),
				new Producto("Meat", new BigDecimal("13.99"),Impuesto.REDUCED),
				new Producto("Cheese", new BigDecimal("3.59"),Impuesto.SUPERREDUCED),
				new Producto("Coke", new BigDecimal("1.89"),Impuesto.REDUCED),
				new Producto("Whiskey", new BigDecimal("19.90"),Impuesto.NORMAL));
		
		
		Object listaC =  carroCompra.stream()
				.filter(p -> p.name.startsWith("C"))
				.map(s -> s.name)
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println("Lista de productos por C" + listaC);
		
		
		
		BigDecimal total =  carroCompra.stream()
				.map (x -> x.price.add(x.price.multiply((new BigDecimal (x.impuesto.getPercent()).divide(new BigDecimal(100))))))
				//.reduce(BigDecimal.ZERO,BigDecimal::add);
				.reduce(BigDecimal.ZERO, BigDecimal ::add);
	
		System.out.println("Total " + total);
				
				
	}
	
}
