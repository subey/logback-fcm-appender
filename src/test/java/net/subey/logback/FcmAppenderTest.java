package net.subey.logback;

import ch.qos.logback.classic.LoggerContext;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class FcmAppenderTest {
    private static Logger logger = LoggerFactory.getLogger(FcmAppenderTest.class);

    @Test
    public void testAppend() {
        logger.error("Test msg");
    }

}