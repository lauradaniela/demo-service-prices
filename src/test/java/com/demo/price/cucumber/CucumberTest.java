package com.demo.price.cucumber;



import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/demo/price/cucumber/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.demo.price.cucumber.stepDefs")
public class CucumberTest {
}
