package com.tengen.weekone;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSpark {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldSpark.class, "/");

		Spark.get("/", new Route() {

			public Object handle(Request arg0, Response arg1) {

				StringWriter writer = new StringWriter();
				try {
					Template helloTemplate = configuration
							.getTemplate("Hello.ftl");

					Map<String, Object> helloMap = new HashMap<String, Object>();
					helloMap.put("name", "Alessandro");

					helloTemplate.process(helloMap, writer);

					System.out.println(writer);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				return writer;
			}
		});
	}

}
