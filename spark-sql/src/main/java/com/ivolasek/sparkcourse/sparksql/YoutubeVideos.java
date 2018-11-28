package com.ivolasek.sparkcourse.sparksql;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import scala.Tuple2;

/**
 * Reads trending YouTube videos and categories, flattens nested categories JSON structure to a form of an ordinary table
 * and retrieves top 10 most popular categories.
 *
 * Parses tags out of the video dataset and stores them as a separate dataset in Avro format.
 */
public class YoutubeVideos {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("YoutubeVideos").master("local[*]").getOrCreate();

        // Your code comes here...
    }
}
