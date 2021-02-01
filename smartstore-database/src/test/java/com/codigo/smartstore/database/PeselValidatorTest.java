// package com.codigo.smartstore.database;
//
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;
//
// import java.util.Set;
//
// import javax.validation.ConstraintViolation;
// import javax.validation.Validation;
// import javax.validation.Validator;
// import javax.validation.ValidatorFactory;
//
// import org.junit.BeforeClass;
// import org.junit.Rule;
// import org.junit.jupiter.api.Test;
//
// import junit.framework.Assert;
//
// public class PeselValidatorTest {
//
// private static Validator validator;
//
// @BeforeClass
// public static void setup() {
//
// final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
// PeselValidatorTest.validator = factory.getValidator();
// }
//
// @Test
// // @Repeat(times = 100000)
// public void testEmailExistsIncorrect() throws NullPointerException,
// IllegalArgumentException, Exception {
//
// final PeselNumber pesel = new PeselNumber(
// "79062601652");
//
// final Set<ConstraintViolation<PeselIdentity>> violations =
// PeselValidatorTest.validator.validate(pesel);
//
// Assert.assertEquals(0, violations.size());
// }
//
// @Rule
// public RepeatRule rule = new RepeatRule();
//
// @Test
// @Repeat(times = 100000)
// public void shouldBeValidTrue() throws Exception {
//
// final PeselValidator val = new PeselValidator("95101399913");
// assertTrue(val.);
// }
//
// @Test
// @Repeat(times = 100000)
// public void shouldBeValidFalse() throws Exception {
//
// final PeselValidator val = new PeselValidator("95101399910");
// assertFalse(val.isValid());
// }
//
// @Test()
// @Repeat(times = 100000)
// public void shouldThrowNullPointerException() throws NullPointerException {
//
// Throwable thw = null;
//
// try {
//
// new PeselValidator(null);
// } catch (final Throwable ex) {
//
// thw = ex;
// }
//
// assertNotNull(thw);
// assertEquals(NullPointerException.class, thw.getClass());
// }
//
// @Test()
// @Repeat(times = 100000)
// public void sholudThrowException() throws IllegalArgumentException {
//
// Throwable thw = null;
//
// try {
//
// new PeselValidator("23");
// } catch (final Throwable ex) {
//
// thw = ex;
// }
//
// assertNotNull(thw);
// assertEquals(IllegalArgumentException.class, thw.getClass());
// }
// }
