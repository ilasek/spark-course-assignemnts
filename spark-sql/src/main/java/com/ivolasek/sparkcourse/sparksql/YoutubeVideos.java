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

        // Fix following line to really read the JSON. See the hint in README.md
        Dataset<Row> categories = spark.read().json("spark-sql/data/US_category_id.json");

        Dataset<Row> videos = spark.read().parquet("spark-sql/data/USVideos.parquet");
        videos.show();

        // Fill in the code of this method
        Dataset<Row> flatCategories = flattenCategories(categories);

        videos.createOrReplaceTempView("videos");
        flatCategories.createOrReplaceTempView("categories");

        // Write a query to show top 10 most viewed categories
        spark.sql("").show();

        // Fill in the code of this method to normalize tags
        normalizeTags(videos);
        // Write results (normalized tags) into spark-sql/data/Tags.avro in AVRO format.

        // At the end we will store categories as a single line JSON for the next exercise.
        categories.write().mode(SaveMode.Overwrite).json("spark-sql/data/categories_single_line.json");
    }

    /**
     * Transforms nested structures from snippet to a flat table.
     * https://stackoverflow.com/questions/38753898/how-to-flatten-a-struct-in-a-spark-dataframe/43355059#43355059
     *
     * @param categories Categories dataset with nested data
     * @return Flattened categories
     */
    private static Dataset<Row> flattenCategories(Dataset<Row> categories) {
        Dataset<Row> flatCategories = categories;
        // Your code comes here - transform categories dataset to the flat structure.
        // Hint you can reference nested columns as snippet.assignable, snippet.channelId, snippet.title

        return flatCategories;
    }

    /**
     * Extracts tags from a tags column and stores them in a separate Dataset together with video_id.
     *
     * @param videos Videos with tags embedded in a tag column
     * @return Table with tag and video_id columns
     */
    private static Dataset<Row> normalizeTags(Dataset<Row> videos) {
        Dataset<Row> normalizedTags = videos;
        // Your code comes here. Normalize tags as per README.md

        return normalizedTags;
    }
}
