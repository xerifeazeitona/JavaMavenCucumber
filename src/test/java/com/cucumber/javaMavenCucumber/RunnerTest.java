package com.cucumber.javaMavenCucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		format = {"pretty", "json:target/json/output.json", "html:target/html/"},
		features = "src/test/resource"
		)
public class RunnerTest {

}
