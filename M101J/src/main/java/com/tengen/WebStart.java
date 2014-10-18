package com.tengen;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.StringWriter;

import static spark.Spark.get;

/**
 * Created by ale on 18/10/2014.
 */
public class WebStart {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(WebStart.class, "/");
        StringWriter writer = new StringWriter();
        MongoClient client = null;
        try {
            client = new MongoClient(new ServerAddress("localhost", 27017));
        }catch (IOException e){
            e.printStackTrace();
        }

        DB db = client.getDB("test");
        DBCollection things = db.getCollection("things");

        get("/hello", (req, res) -> {
            Template template = null;
            try {
                template = configuration.getTemplate("hello.tfl");
                DBObject document = things.findOne();
                template.process(document, writer);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return writer;
        });
    }
}
