package com.ivolasek.sparkcourse.wordcount;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.List;

/**
 * Computes number of severities of log messages in data/sample.log file.
 *
 * Example output:
 * <pre>
 *     [(WARNING,235), (ERROR,253), (DEBUG,252), (INFO,260)]
 * </pre>
 *
 * @author Ivo Lasek
 */
public class LogAnalysis {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("LogAnalysis").master("local[*]").getOrCreate();

        JavaRDD<String> logFile = spark.read().textFile("spark-introduction/data/sample.log").javaRDD();

//        List<Tuple2<String, Integer>> counts = logFile
//                .... Your code comes here....
//                .collect();

//        System.out.println(counts);
    }
}
