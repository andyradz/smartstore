package com.codigo.smartstore.webapi;
// package java.com.codigo.smartstore.webapi;
//
// import static org.mockito.BDDMockito.given;
// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
// import java.util.Optional;
//
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
// import com.codigo.smartstore.webapi.domain.Customer;
// import com.codigo.smartstore.webapi.services.CustomerService;
//
//// @ContextConfiguration(classes = {AppConfig.class, DatabaseConfig.class})
//// @AutoConfigureMockMvc
//// @ContextConfiguration(classes = {BirthdayInfoController.class,
//// BasicBirthdayService.class})
//// @WebMvcTest
//// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @AutoConfigureMockMvc
// @ExtendWith(MockitoExtension.class)
// public class CustomerRestControllerUnitTest {
//
// private static final String APPLICATION_JSON_PATCH_JSON =
// "application/json-patch+json";
//
// @Autowired
// private MockMvc mvc;
//
// @MockBean
// private CustomerService mockCustomerService;
//
// // @Autowired
// // ApplicationContext context;
//
// @Test
// @Disabled
// public void whenCustomerCreated_then201ReturnedWithNewCustomerLocation()
// throws Exception {
//
// final Map<String, Boolean> communicationPreferences = new HashMap<>();
// communicationPreferences.put("post", true);
// communicationPreferences.put("email", true);
// final Customer customer = new Customer(
// "001-555-1234",
// asList("Milk", "Eggs"),
// communicationPreferences);
//
// final Customer persistedCustomer = Customer.fromCustomer(customer);
// persistedCustomer.setId(1L);
//
// given(this.mockCustomerService.createCustomer(customer)).willReturn(persistedCustomer);
//
// final String createCustomerRequestBody = "{" + "\"telephone\":
// \"001-555-1234\",\n"
// + "\"favorites\": [\"Milk\", \"Eggs\"],\n"
// + "\"communicationPreferences\": {\"post\":true, \"email\":true}\n"
// + "}";
// this.mvc.perform(
// MockMvcRequestBuilders.post("/customers")
// .contentType(MediaType.APPLICATION_JSON)
// .content(createCustomerRequestBody))
// .andExpect(status().isCreated())
// .andExpect(redirectedUrlPattern("http://*/customers/7"));
// }
//
// @Test
// public void givenNonExistentCustomer_whenPatched_then404Returned() throws
// Exception {
//
// final Optional<Customer> emptyCustomer = null;
//
// given(this.mockCustomerService.findCustomer(1L)).willReturn(emptyCustomer);
//
// final String patchInstructions =
// "[{\"op\":\"replace\",\"path\":/telephone\",\"value\":\"001-555-5678\"}]";
// this.mvc.perform(
// MockMvcRequestBuilders.patch("/customers/1")
// .contentType(APPLICATION_JSON_PATCH_JSON)
// .content(patchInstructions))
// .andExpect(status().isNotFound());
// }
// }
//////
////// @Test
////// public void givenExistingCustomer_whenPatched_thenReturnPatchedCustomer()
//// throws Exception {
////// Map<String, Boolean> communicationPreferences = new HashMap<>();
////// communicationPreferences.put("post", true);
////// communicationPreferences.put("email", true);
////// Customer customer = new Customer("1", "001-555-1234", asList("Milk",
//// "Eggs"), communicationPreferences);
//////
////// given(mockCustomerService.findCustomer("1")).willReturn(Stream.of(customer));
//////
////// String patchInstructions = "[{\"op\":\"replace\",\"path\":
//// \"/telephone\",\"value\":\"001-555-5678\"}]";
////// mvc.perform(MockMvcRequestBuilders.patch("/customers/1")
////// .contentType(APPLICATION_JSON_PATCH_JSON)
////// .content(patchInstructions))
////// .andExpect(status().isOk())
////// .andExpect(jsonPath("$.id", is("1")))
////// .andExpect(jsonPath("$.telephone", is("001-555-5678")))
////// .andExpect(jsonPath("$.favorites", is(asList("Milk", "Eggs"))))
////// .andExpect(jsonPath("$.communicationPreferences",
//// is(communicationPreferences)));
////// }
////// }