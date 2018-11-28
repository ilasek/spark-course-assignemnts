package com.ivolasek.sparkcourse.streaming;

import java.io.IOException;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;

/**
 * <p>This sample code demonstrates Spark streaming capabilities by performing a sentiment analysis on a live stream of
 * tweets containing a word sick.</p>
 */
public class SocketStreaming {

    /**
     * Spark Streaming demo.
     * @param args This code doesn't take any arguments.
     * @throws IOException in case of a missing secrets/twitter.properties file.
     */
    public static void main(String[] args) throws StreamingQueryException {
        SparkSession spark = SparkSession.builder().appName("SocketStreaming")
                .master("local[*]")
                .getOrCreate();

        Dataset<Row> lines = spark
                .readStream()
                .format("socket")
                .option("host", "localhost")
                .option("port", 9999)
                .load();

        // Your code comes here...
        // Use the Tweet class to encode Tweets in JSON (add the current timestamp to it as a createdDate.
        // Send the JSON encoded tweets to Kafka to a topic tweets.
    }
}
