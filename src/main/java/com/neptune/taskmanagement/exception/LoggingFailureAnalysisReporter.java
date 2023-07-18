package com.neptune.taskmanagement.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalysisReporter;

public final class LoggingFailureAnalysisReporter implements FailureAnalysisReporter {

    private static final Log logger = LogFactory.getLog(LoggingFailureAnalysisReporter.class);

    public LoggingFailureAnalysisReporter() {
    }

    public void report(FailureAnalysis analysis) {
        if(logger.isDebugEnabled()){
            logger.debug("Application failed", analysis.getCause());
        }

        if(logger.isErrorEnabled()){
            logger.error("Error");
        }
    }
}
