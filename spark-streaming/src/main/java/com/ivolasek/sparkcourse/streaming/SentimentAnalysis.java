/*
 * Copyright © 2017 Merck Sharp & Dohme Corp., a subsidiary of Merck & Co., Inc.
 * All rights reserved.
 */
package com.ivolasek.sparkcourse.streaming;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;


/**
 * This class represents a Spark streaming job computing sentiment analysis for each incoming tweet. Results are
 * printed to the console.
 */
public class SentimentAnalysis {

    public static void main(String[] args) throws StreamingQueryException {
        SparkSession spark = SparkSession.builder().appName("SentimentAnalysis")
                .master("local[*]")
                .getOrCreate();

        Dataset<Row> tweets = spark.readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "tweets")
                .load();

        // Load sentiment dataset
        String[] schema = {"word", "sentiment"};
        Dataset<Row> sentiments = spark.read()
                .option("header", "false")
                .option("delimiter", "\t")
                .option("inferSchema", "true")
                .csv("spark-streaming/data/sentiment.tsv")
                .toDF(schema);
        sentiments.createOrReplaceTempView("sentiments");

        StreamingQuery query = tweets
                // Your code comes here...
                // Join streaming dataset tweets with the static dataset sentiments and compute a sentiment score
                // for each incoming tweet as a SUM of all words from the tweet found in the sentiment dataset.

                .writeStream()
                .outputMode("update")
                .option("truncate", false)
                .format("console")
                .start();

        query.awaitTermination();
    }
}
