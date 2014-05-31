package com.tengen.weekone;

import spark.Spark;

public class StopSpark {

	public static void main(String[] args) {
		Spark.stop();
		System.out.println("Spark stopped");

	}

}
