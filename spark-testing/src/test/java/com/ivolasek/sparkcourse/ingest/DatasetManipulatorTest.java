package com.ivolasek.sparkcourse.ingest;

import static org.junit.Assert.*;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.Before;
import org.junit.Test;
import org.spark_project.guava.collect.ImmutableList;

import com.ivolasek.sparkcourse.ingest.dto.Survey;
import com.ivolasek.sparkcourse.ingest.support.SparkTestSupport;

public class DatasetManipulatorTest extends SparkTestSupport {

    /**
     * Run {@link DatasetManipulator#doSophisticatedCalculation(Dataset)} with test data.
     * @see SparkTestSupport
     * @throws Exception
     */
    @Test
    public void doSophisticatedCalculation() throws Exception {
        // Your code comes here...
//        assertEquals("Correctly calculated column value", ...);
    }

}