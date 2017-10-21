package com.taotao.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestFreemarker {
	
	@Test
	public void testFreemarker()throws Exception{
		// 1创建一个模板文件
		// 2创建一个Configuration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 3设置模板所在的路径
		configuration.setDirectoryForTemplateLoading(new File("E:/eclipse/workspace/taotao-item-web/src/main/webapp/WEB-INF/ftl"));
		// 4设置模板的字符集 一般UTF-8
		configuration.setDefaultEncoding("utf-8");
		// 5使用Configuration对象加载一个模板文件，需要指定模板文件的文件名
		Template template = configuration.getTemplate("student.ftl");
		// 6创建一个数据集，可以是pojo，也可以是map（推荐使用map）
		Map data = new HashMap<>();
		data.put("hello", "hello freemarker");
		Student student = new Student(1,"小米",12,"northSHanghai");
		data.put("student", student);
		data.put("date", new Date());
		
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student(1,"小米",12,"northSHanghai"));
		stuList.add(new Student(2,"小米",12,"northSHanghai"));
		stuList.add(new Student(3,"小米",12,"northSHanghai"));
		stuList.add(new Student(4,"小米",12,"northSHanghai"));
		stuList.add(new Student(5,"小米",12,"northSHanghai"));
		stuList.add(new Student(6,"小米",12,"northSHanghai"));
		
		data.put("stuList", stuList);
		
		// 7创建一个writer对象，指定输出文件的路径和文件名
		Writer out = new FileWriter(new File("D:/temp/out/student.html"));
		// 8使用模板对象的process方法输出文件
		template.process(data, out);
		// 9关闭流
		out.close();
	}
}
