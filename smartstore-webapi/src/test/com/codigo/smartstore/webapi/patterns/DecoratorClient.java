package com.codigo.smartstore.webapi.patterns;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class DecoratorClient {

	public static void main(final String[] args) {

		Computer mac = new MacComputer();
		mac.run();

		mac = new ComputerDecoratorCDROM(mac);
		mac.run();

		mac = new ComputerDecoratorHDD(mac);
		mac.run();

		final Pizza margherita = new Pizza();
		final Pizza withMozzarella = new PizzaWithMozzarella(margherita);

		final DecimalFormat df = new DecimalFormat("#,00 zł");
		for (final Pizza pizza : List.of(margherita, withMozzarella))
			System.out.println(String.format("%s costs %s.", pizza, df.format(pizza.getPrice())));
	}

	public void run() {

		System.out.println("Start computer");
	}
}

class Pizza {

	private static final BigDecimal BASE_PRICE = new BigDecimal(12);

	public BigDecimal getPrice() {

		return BASE_PRICE;
	}

	@Override
	public String toString() {

		return "Pizza";
	}
}

class PizzaWithMozzarella
		extends
		Pizza {

	private static final BigDecimal MOZZARELLA_PRICE = new BigDecimal(5);
	private final Pizza basePizza;

	public PizzaWithMozzarella(final Pizza basePizza) {

		this.basePizza = basePizza;
	}

	@Override
	public BigDecimal getPrice() {

		return this.basePizza.getPrice()
				.add(MOZZARELLA_PRICE);
	}
}

abstract class Computer {

	abstract public void run();
}

class MacComputer
		extends
		Computer {

	@Override
	public void run() {

		System.out.println("Start komputera MAC");
	}
}

abstract class ComputerDecorator
		extends
		Computer {

}

class ComputerDecoratorHDD
		extends
		Computer {

	private final Computer computer;

	public ComputerDecoratorHDD(final Computer computer) {

		this.computer = computer;
	}

	@Override
	public void run() {

		this.computer.run();
		System.out.println("Start with HDD");
	}
}

class ComputerDecoratorCDROM
		extends
		Computer {

	private final Computer computer;

	public ComputerDecoratorCDROM(final Computer computer) {

		this.computer = computer;
	}

	@Override
	public void run() {

		this.computer.run();
		System.out.println("Start with CDROM");
	}
}