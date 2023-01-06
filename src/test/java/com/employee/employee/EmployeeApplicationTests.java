package com.employee.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes ={EmployeeApplication.class})

//@ActiveProfiles("test")
@WebAppConfiguration
class EmployeeApplicationTests {
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@Sql(scripts={"classpath:insert_test.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	public void testGetEmployee()
			throws Exception {
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/employees")
				).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}


}
