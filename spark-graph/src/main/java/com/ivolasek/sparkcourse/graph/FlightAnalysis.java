package com.ivolasek.sparkcourse.graph;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.graphframes.GraphFrame;

/**
 */
public class FlightAnalysis {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("FlightAnalysis").getOrCreate();

        Dataset<Row> flights = spark.read()
                .option("inferSchema", true)
                .csv(args[0])
                .withColumnRenamed("_c6", "src")
                .withColumnRenamed("_c8", "dst")
                .withColumnRenamed("_c16", "distance");

        Dataset<Row> airports = flights.select("src").withColumnRenamed("src", "id").distinct();
        Dataset<Row> edges = flights.select("src", "dst", "distance").distinct();

        edges.show();


        GraphFrame graph = GraphFrame.apply(airports, edges);
        // Your code comes here...
//        2. Find airports with the highest number of incoming flights.
//        3. Compute a PageRank for all airports and print the top most important airports according to PageRank.
//        4. Find airports that you can travel between in a cycle: Airport1 -> Airpot2 -> Airport1 and the total travel distance is greater than 10300 miles.
    }
}