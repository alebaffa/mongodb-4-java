package com.tengen;
import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
       MongoClient client = new MongoClient(new ServerAddress("localhost",27017));
       DB db = client.getDB("test");
       DBCollection things = db.getCollection("things");
        DBCursor cursor = things.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }

    }
}
