package com.codigo.smartstore.webapi.patterns;

public class AbstractFactory {

	public static void main(final String[] args) {

		createEquipment(new EconomyCarEquipmentFactory());
		createEquipment(new ComfortCarEquipmentFactory());
	}

	private static void createEquipment(final CarEquipmentFactory carEquipmentFactory) {

		final Engine engine = carEquipmentFactory.createEngine();
		engine.produceEngine();

		final Light light = carEquipmentFactory.createLight();
		light.produceLight();

		final Tire tire = carEquipmentFactory.createTire();
		tire.produceTire();
	}
}

interface Engine {

	void produceEngine();
}

interface Light {

	void produceLight();
}

interface Tire {

	void produceTire();
}

interface CarEquipmentFactory {

	Engine createEngine();

	Light createLight();

	Tire createTire();
}

class EconomyCarEquipmentFactory
	implements CarEquipmentFactory {

	@Override
	public Engine createEngine() {

		return new PetrolEngine();
	}

	@Override
	public Light createLight() {

		return new Halogen();
	}

	@Override
	public Tire createTire() {

		return new BudgetTire();
	}
}

class PetrolEngine
	implements Engine {

	@Override
	public void produceEngine() {

		System.out.println("Producing petrol engine.");
	}
}

class Halogen
	implements Light {

	@Override
	public void produceLight() {

		System.out.println("Producing halogen light.");
	}
}

class BudgetTire
	implements Tire {

	@Override
	public void produceTire() {

		System.out.println("Producing budget tire.");
	}
}

class ComfortCarEquipmentFactory
	implements CarEquipmentFactory {

	@Override
	public Engine createEngine() {

		return new HybridEngine();
	}

	@Override
	public Light createLight() {

		return new LedLight();
	}

	@Override
	public Tire createTire() {

		return new PremiumTire();
	}
}

class HybridEngine
	implements Engine {

	@Override
	public void produceEngine() {

		System.out.println("Producing hybrid engine.");
	}
}

class LedLight
	implements Light {

	@Override
	public void produceLight() {

		System.out.println("Producing led light.");
	}
}

class PremiumTire
	implements Tire {

	@Override
	public void produceTire() {

		System.out.println("Producing premium tire.");
	}
}

abstract class ReportManufactur {

	// private final ReportFactory factory;

	public ReportManufactur() {

		// this.factory = factory;
	}

	protected abstract Report build(ReportFormat format);

	public Report make(final ReportFormat format) {

		final Report report = this.build(format);
		// jakies operacje na raporcie
		return report;
	}
}

class ReportManufacturEuropean
		extends
		ReportManufactur {

	@Override
	protected Report build(final ReportFormat format) {

		return null;
	}
}

class ReportManufacturAmerican
		extends
		ReportManufactur {

	@Override
	protected Report build(final ReportFormat format) {

		return null;
	}
}

enum ReportFormat {
	PDF,
	DOC,
	TXT,
	CSV
}

// TA fabryka do dziedziczenia i rozszerzenia
class ReportFactory {

	public Report createRaport(final ReportFormat format) {

		switch (format) {

		case PDF -> {

			return new PDFReport();
		}

		case DOC -> {

			return new DOCReport();
		}

		case TXT -> {

			return new TXTReport();
		}

		case CSV -> {

			return new CSVReport();
		}

		default -> throw new IllegalArgumentException("Unexpected value: " + format);
		}
	}
}

interface Report {
}

class PDFReport
	implements Report {
}

class DOCReport
	implements Report {
}

class CSVReport
	implements Report {
}

class TXTReport
	implements Report {
}