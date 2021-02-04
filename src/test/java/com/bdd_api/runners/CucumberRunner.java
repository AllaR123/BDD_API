package com.bdd_api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,

        features = {"src/test/recources/features"
        },
        glue = "com/bdd_api/step_defitions",
        dryRun = false
)
public class CucumberRunner {


}
