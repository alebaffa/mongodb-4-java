package com.tengen.weekone;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * First test with Java and MongoDB
 * 
 */
public class App {
	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient(new ServerAddress(
					"localhost", 27017));
			DB database = mongoClient.getDB("test");
			DBCollection collection = database.getCollection("things");
			DBObject document = collection.findOne();
			System.out.println("the document is: \n" + document);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
