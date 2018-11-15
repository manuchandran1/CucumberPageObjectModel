package com.qa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/shify/Documents/Workspace2/CucumberPageObjectModel/src/main/java/com/qa/features/freecrm.feature", //path of feature file
		glue = {"com/qa/stepdefinitions"}, //path of the stepDefinition files
		format= {"pretty","html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, // generate different types of report: html, json, junit xml output etc.
		monochrome = true, // display the console output in a readable format
		strict = true, //check if any step is not defined in  step definition file 
		dryRun = false // checks if the mapping is proper between feature file and step definition
		//,tags = {"~@SmokeTest", "~@End2End","~@RegressionTest" }
		// OR: tags = {"@SmokeTest, @End2End"} ---> Execute all the tests tagged as  SmokeTest OR @End2End
		// AND: tags = {"@SmokeTest" , "@End2End"} ---> Execute all the tests tagged as  SmokeTest AND @End2End
		// Ignore: tags = {"~@SmokeTest" , "~@End2End"} ---> Execute all the tests tagged as  SmokeTest AND @End2End
		
		)

public class TestRunner {
	
}
