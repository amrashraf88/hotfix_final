package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/main/resources/Features",
        glue = "StepDefinitions",
        tags = "@Regression",
        plugin = {
           "pretty",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"
       }
)

public class TestRunner{
}
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
//        features = {"src/main/resources/Features"},
//        glue = {"StepDefinitions"}
//)
//public class TestRunner {
//}
