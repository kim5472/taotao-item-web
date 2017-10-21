package com.taotao.item.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * 网页静态化处理Controller
 * @author Administrator
 *
 */
@Controller
public class HtmlGenController {
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@RequestMapping("genHtml")
	@ResponseBody
	public String genHtml() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException{
		// 生成动态页面
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		Template template = configuration.getTemplate("hello.ftl");
		Map data = new HashMap<>();
		data.put("hello", "spring freemarker test");
		Writer out = new FileWriter(new File("E:/eclipse/workspace/taotao-item-web/src/main/webapp/WEB-INF/ftl"));
		template.process(data, out);
		out.close();
		// 返回结果
		return "OK";
	}
}
