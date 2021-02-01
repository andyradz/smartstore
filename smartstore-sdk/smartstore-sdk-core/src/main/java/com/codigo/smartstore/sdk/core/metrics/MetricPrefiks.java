package com.codigo.smartstore.sdk.core.metrics;

import java.util.EnumSet;
import java.util.Set;

/**
 * Definicje prefiksów miar układu SI
 *
 * @author dp0470
 *
 */
enum MetricPrefiks {

	YOTTA("Y", "yotta"),
	ZETTA("Z", "zetta"),
	EKSA("E", "exa"),
	PETA("P", "peta"),
	TERA("T", "tera"),
	GIGA("G", "giga"),
	MEGA("M", "mega"),
	KILO("k", "kilo"),
	HECTO("h", "hecto"),
	DECA("d", "deca"),
	DEFAULT("", ""),
	DECI("d", "deci"),
	CENTI("c", "centi"),
	MILLI("m", "milli"),
	MICRO("μ", "micro"),
	NANO("n", "nano"),
	PICO("p", "pico"),
	FEMTO("f", "femto"),
	ATTO("a", "atto"),
	ZEPTO("z", "zepto"),
	YOCTO("y", "yocto");

	public static Set<MetricPrefiks> getPrefiks() {

		return EnumSet.allOf(MetricPrefiks.class);
	}

	private final String symbol;
	private final String name;

	private MetricPrefiks(final String symbol, final String name) {

		this.symbol = symbol;
		this.name = name;
	}

	public String getSymbol() {

		return this.symbol;
	}

	public String getName() {

		return this.name;
	}

}