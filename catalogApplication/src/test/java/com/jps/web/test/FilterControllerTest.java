package com.jps.web.test;

import org.junit.jupiter.api.Test;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jps.model.Product;
import com.jps.model.Seller;
import com.jps.service.ProductService;
import com.jps.web.FilterController;

@WebMvcTest(FilterController.class)
@AutoConfigureMockMvc
public class FilterControllerTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	ProductService productService;

	@Test
	void getProductByBrandName() throws Exception {
		//String json = " {\"id\":1L,\"brand\":\"Lee\",\"sellers\":[{\"id\":456,\"sellerName\":\"ram\"}]}";

		String json = " {\"id\":1L,\"brand\":\"Lee\",\"sellers\":[{\"id\":456,\"sellerName\":\"ram\"}]}";
		// when(productService.getProductByBrand(products.getBrand())).thenReturn((List<Product>)
		// products);
		mockMvc.perform(get("/v1/products/Lee").content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}
