package com.codigo.smartstore.webapi;
// package com.codigo.smartstore.webapi;
//
// import org.junit.Before;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.mockito.ArgumentCaptor;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.TestConfiguration;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.context.web.WebAppConfiguration;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.web.context.WebApplicationContext;
//
//
// import com.codigo.smartstore.webapi.controllers.PagedController;
// import com.codigo.smartstore.webapi.repository.EmployeeRepository;
// import com.codigo.smartstore.webapi.services.CustomerService;
// import com.codigo.smartstore.webapi.services.ICustomerService;
//
//// import static io.reflectoring.paging.PageableAssert.*;
//// import static io.reflectoring.paging.SortAssert.*;
//
// import static com.codigo.smartstore.webapi.PageableAssert.*;
//
// import static org.mockito.Mockito.*;
// import static
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
// @RunWith(SpringRunner.class)
// @WebMvcTest(
// controllers = PagedController.class
// // If we exclude SpringDataWebAutoConfiguration, the Pageable parameter will
// not be resolved.
// // If we only exclude it on the Application class itself, the test will still
// work!!!
// // excludeAutoConfiguration = SpringDataWebAutoConfiguration.class
// )
// @WebAppConfiguration
//// @ContextConfiguration(classes = {
//// SpringMockMvcConfiguration.class
//// })
// class PagedControllerTest {
//
// @TestConfiguration
// protected static class Config {
//
// @Bean
// public ICustomerService languageService() {
// return Mockito.mock(CustomerService.class);
// }
// }
//
// @Autowired
// private PagedController languageApiController;
//
// @MockBean
// private EmployeeRepository characterRepository;
//
// @Autowired
// private MockMvc mockMvc;
//
// @Autowired
// private WebApplicationContext webApplicationContext;
//
// @Before
// public void setUp() {
//// mockMvc = MockMvcBuilders
//// .standaloneSetup(languageApiController)
//// .build();
//
// mockMvc = MockMvcBuilders
// .webAppContextSetup(webApplicationContext)
// .build();
// }
//
// @Test
// void evaluatesPageableParameter() throws Exception {
//
// mockMvc.perform(get("/characters/page")
// .param("page", "5")
// .param("size", "10")
// .param("sort", "id,desc") // <-- no space after comma!!!
// .param("sort", "name,asc")) // <-- no space after comma!!!
// .andExpect(status().isOk());
//
// ArgumentCaptor<Pageable> pageableCaptor =
// ArgumentCaptor.forClass(Pageable.class);
// verify(characterRepository).findAllPage(pageableCaptor.capture());
// PageRequest pageable = (PageRequest) pageableCaptor.getValue();
//
// assertThat(pageable).hasPageNumber(5);
// assertThat(pageable).hasPageSize(10);
// assertThat(pageable).hasSort("name", Sort.Direction.ASC);
// assertThat(pageable).hasSort("id", Sort.Direction.DESC);
// }
//
// @Test
// void evaluatesQualifier() throws Exception {
//
// mockMvc.perform(get("/characters/qualifier")
// .param("my_page", "5")
// .param("my_size", "10")
// .param("my_sort", "id,desc") // <-- no space after comma!!!
// .param("my_sort", "name,asc")) // <-- no space after comma!!!
// .andExpect(status().isOk());
//
// ArgumentCaptor<Pageable> pageableCaptor =
// ArgumentCaptor.forClass(Pageable.class);
// verify(characterRepository).findAllPage(pageableCaptor.capture());
// PageRequest pageable = (PageRequest) pageableCaptor.getValue();
//
// assertThat(pageable).hasPageNumber(5);
// assertThat(pageable).hasPageSize(10);
// assertThat(pageable).hasSort("name", Sort.Direction.ASC);
// assertThat(pageable).hasSort("id", Sort.Direction.DESC);
// }
//
// @Test
// void setsUpperPageLimit() throws Exception {
//
// mockMvc.perform(get("/characters/page")
// .param("size", "10000"))
// .andExpect(status().isOk());
//
// ArgumentCaptor<Pageable> pageableCaptor =
// ArgumentCaptor.forClass(Pageable.class);
// verify(characterRepository).findAllPage(pageableCaptor.capture());
// PageRequest pageable = (PageRequest) pageableCaptor.getValue();
//
// assertThat(pageable).hasPageSize(2_000);
// }
//
// @Test
// void evaluatesPageableDefault() throws Exception {
//
// mockMvc.perform(get("/characters/page"))
// .andExpect(status().isOk());
//
// ArgumentCaptor<Pageable> pageableCaptor =
// ArgumentCaptor.forClass(Pageable.class);
// verify(characterRepository).findAllPage(pageableCaptor.capture());
// PageRequest pageable = (PageRequest) pageableCaptor.getValue();
//
// assertThat(pageable).hasPageNumber(0);
// assertThat(pageable).hasPageSize(20);
// assertThat(pageable).hasSort("name", Sort.Direction.DESC);
// assertThat(pageable).hasSort("id", Sort.Direction.ASC);
// }
//
// @Test
// void returnsSlice() throws Exception {
//
// mockMvc.perform(get("/characters/slice")
// .param("page", "5")
// .param("size", "10")
// .param("sort", "id,desc") // <-- no space after comma!!!
// .param("sort", "name,asc")) // <-- no space after comma!!!
// .andExpect(status().isOk());
//
// ArgumentCaptor<Pageable> pageableCaptor =
// ArgumentCaptor.forClass(Pageable.class);
// verify(characterRepository).findAllSlice(pageableCaptor.capture());
// PageRequest pageable = (PageRequest) pageableCaptor.getValue();
//
// assertThat(pageable).hasPageNumber(5);
// assertThat(pageable).hasPageSize(10);
// assertThat(pageable).hasSort("name", Sort.Direction.ASC);
// assertThat(pageable).hasSort("id", Sort.Direction.DESC);
// }
//
// @Test
// void evaluatesSortParameter() throws Exception {
//
// mockMvc.perform(get("/characters/sorted")
// .param("sort", "id,desc") // <-- no space after comma!!!
// .param("sort", "name,asc")) // <-- no space after comma!!!
// .andExpect(status().isOk());
//
// ArgumentCaptor<Sort> sortCaptor = ArgumentCaptor.forClass(Sort.class);
// verify(characterRepository).findAllSorted(sortCaptor.capture());
// Sort sort = sortCaptor.getValue();
//
//// PageableAssert.assertThat(sort).hasSort("name", Sort.Direction.ASC);
//// assertThat(sort).hasSort("id", Sort.Direction.DESC);
// }
// }