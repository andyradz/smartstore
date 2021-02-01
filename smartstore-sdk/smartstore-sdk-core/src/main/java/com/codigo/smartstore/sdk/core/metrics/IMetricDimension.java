package com.codigo.smartstore.sdk.core.metrics;

public interface IMetricDimension {

	String getUnitName();

	String getUnitSymbol();

	String getDimensionSymbol();

	String getQuantityName();
}

// Unit name Unit symbol Dimension symbol Quantity name Definition
// second //[n 1] s T time The duration of 9192631770 periods of the radiation
// corresponding to the transition between the two hyperfine levels of the
// ground state of the caesium-133 atom.
// metre m L length The distance travelled by light in vacuum in
// 1
///
// 299792458
// second.
// kilogram
// [n 2] kg M mass The kilogram is defined by setting the Planck constant h
// exactly to 6.62607015×10−34 J⋅s (J = kg⋅m2⋅s−2), given the definitions of the
// metre and the second.[1]
// ampere A I electric current The flow of
// 1
///
// 1.602176634×10−19
// times the elementary charge e per second.
// kelvin K Θ thermodynamic
// temperature The kelvin is defined by setting the fixed numerical value of the
// Boltzmann constant k to 1.380649×10−23 J⋅K−1, (J = kg⋅m2⋅s−2), given the
// definition of the kilogram, the metre, and the second.
// mole mol N amount of
// substance The amount of substance of exactly 6.02214076×1023 elementary
// entities.[n 3] This number is the fixed numerical value of the Avogadro
// constant, NA, when expressed in the unit mol−1 and is called the Avogadro
// number.
// candela cd J luminous
// intensity The luminous intensity, in a given direction, of a source that
// emits monochromatic radiation of frequency 5.4×1014 hertz and that has a
// radiant intensity in that direction of
// 1
///
// 683
// watt per steradian.