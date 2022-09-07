package Core.Util;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Iterator;

public class BrowserStackDriver implements DriverSource {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    private String username, authkey;
    Util env=new Util();

    @Override
    public WebDriver newDriver() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        //env.incremental();
        String environment=System.getProperty("browserstack");

        Iterator it = environmentVariables.getKeys().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            if (environment != null && key.startsWith("browserstack." + environment)) {
                capabilities.setCapability(key.replace("browserstack." + environment + ".", ""), environmentVariables.getProperty(key));
            }
        }

        try {
            username = ""; //replace with your username be sure to encode @ with %40
            authkey = "";
            String url = "https://" + username + ":" + authkey + "@hub-cloud.browserstack.com"
                    + "/wd/hub";
            //env.incremental1();
            return new RemoteWebDriver(new URL(url), capabilities);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    @Override
    public boolean takesScreenshots() {
        return false;
    }
}
