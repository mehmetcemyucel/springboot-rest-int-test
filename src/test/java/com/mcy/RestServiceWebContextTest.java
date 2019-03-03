package com.mcy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


//ORT: 2.186 MS
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { McySbRestTestApplication.class })
@WebAppConfiguration
public class RestServiceWebContextTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mvc;

	@Before
	public void setup() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
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
