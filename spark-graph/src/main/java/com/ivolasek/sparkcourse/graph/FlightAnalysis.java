package com.ivolasek.sparkcourse.graph;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.graphframes.GraphFrame;

import static org.apache.spark.sql.functions.desc;

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

        // Get airports as vertices and tracks together with distance as edges.
        // Then construct a graph and compute all nrequired Graph statistics.
    }
}