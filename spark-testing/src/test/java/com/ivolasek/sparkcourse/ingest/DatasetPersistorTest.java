package com.ivolasek.sparkcourse.ingest;

import org.junit.Test;

import com.ivolasek.sparkcourse.ingest.support.SparkTestSupport;

public class DatasetPersistorTest extends SparkTestSupport {
    /**
     * @see com.ivolasek.sparkcourse.ingest.support.ObscureDataFormat for assertions about correctly loaded test dataset.
     * @throws Exception
     */
    @Test
    public void persist() throws Exception {
        new DatasetPersistor("com.ivolasek.sparkcourse.ingest.support.ObscureDataFormat").persist(getTestDataset());
    }

}