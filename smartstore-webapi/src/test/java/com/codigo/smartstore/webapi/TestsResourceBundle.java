// package com.codigo.smartstore.webapi;
//
// import static org.hamcrest.CoreMatchers.instanceOf;
// import static org.hamcrest.MatcherAssert.assertThat;
//
// import java.text.MessageFormat;
// import java.time.LocalDate;
// import java.util.Locale;
// import java.util.ResourceBundle;
//
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
//
// public class TestsResourceBundle {
//
// @Test
// void testOpenFile() {
//
// final var bundle = ResourceBundle.getBundle("messages",
// Locale.forLanguageTag("PL_pl"));
// var message = bundle.getString("label");
//
// System.out.println(message);
//
// final var pattern = "On {0}\n";
// final var formatter = new MessageFormat(
// pattern,
// Locale.UK);
//
// message = formatter.format(
// new Object[] {
// LocalDate.now() });
//
// System.out.println(message);
// }
//
// @Test
// @DisplayName("Test klasy Integer")
// void testIntegerClass() {
//
// final var numeric = Integer.MAX_VALUE;
//
// System.out.println("Andrzej jest super");
// assertThat(numeric, instanceOf(Integer.class));
// }
//
// @Test
// @DisplayName("Test klasy Integer")
// void testBooleanClass() {
//
// final var logic = false;
//
// System.out.println("Ola jest super");
// assertThat(logic, instanceOf(Boolean.class));
// }
//
// }