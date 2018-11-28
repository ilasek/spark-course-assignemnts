/*
 * Copyright © 2017 Merck Sharp & Dohme Corp., a subsidiary of Merck & Co., Inc.
 * All rights reserved.
 */
package com.ivolasek.sparkcourse.streaming;

import static org.apache.spark.sql.functions.expr;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class SentimentAnalysis {

    public static void main(String[] args) throws StreamingQueryException {
        SparkSession spark = SparkSession.builder().appName("SentimentAnalysis")
                .master("local[*]")
                .getOrCreate();

        // You can use the sentiment static dataset to join it with the stream
        // Load sentiment dataset
        String[] schema = {"word", "sentiment"};
        Dataset<Row> sentiments = spark.read()
                .option("header", "false")
                .option("delimiter", "\t")
                .option("inferSchema", "true")
                .csv("spark-streaming/data/sentiment.tsv")
                .toDF(schema);
        sentiments.registerTempTable("sentiments");

        // Your code comes here....
        // Read data from the tweets topic, compute the sentiment for each tweet and print it to console

        // Print incoming tweets together with their sentiment score
    }
}
