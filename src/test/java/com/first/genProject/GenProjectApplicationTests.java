package com.first.genProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.genProject.service.AiService;

@SpringBootTest(properties = "spring.ai.openai.api-key=test-api-key")
class GenProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private AiService AIService;
	@Test
	void TestTemplateRender() {
		var Result=this.AIService.ChatTemplate();
		System.out.println(Result);

}
}
