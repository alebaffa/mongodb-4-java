package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ale on 18/10/2014.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        Template template = null;
        try {
            template = configuration.getTemplate("hello.tfl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Freemarker");
            template.process(helloMap, writer);

            System.out.println(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
