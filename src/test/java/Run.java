import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = ".", tags="@search", plugin = {"pretty", "html:target/tsr/tsr.html"})
public class Run extends AbstractTestNGCucumberTests {
}
