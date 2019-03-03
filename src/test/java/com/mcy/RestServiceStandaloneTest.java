package com.mcy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


// ORT: 556 MS
public class RestServiceStandaloneTest {

	@InjectMocks
	private RestService restService;

	@Mock
	private SecondService service;

	private MockMvc mvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(service.getValue()).thenReturn("service");
		mvc = MockMvcBuilders.standaloneSetup(restService).build();
	}

	@Test
	public void test() throws Exception {
		String requestBodyJson = "{ \"requestValue1\":\"val1\", \"requestValue2\":\"2\" }";

		MvcResult result = mvc
				.perform(post("/post-service").content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		MockHttpServletResponse response = result.getResponse();
		String responseMessage = response.getContentAsString();
		assertThat(responseMessage).isEqualTo("{\"responseValue1\":\"val1service\",\"responseValue2\":2}");
	}

}
