package com.ivolasek.sparkcourse.ingest;

import org.junit.Test;

import com.ivolasek.sparkcourse.ingest.support.SparkTestSupport;

public class DatasetPersistorTest extends SparkTestSupport {
    @Test
    public void persist() throws Exception {
        // See DatasetPersistor and fill in your testing code there
        new DatasetPersistor("com.ivolasek.sparkcourse.ingest.support.ObscureDataFormat").persist(getTestDataset());
    }

}