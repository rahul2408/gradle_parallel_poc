package serenityAction;

import Pages.HomePage.HomePage;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;


public class homePageAction extends UIInteractions {

    HomePage homePage;





    public void opens_ais_home_page() {

        homePage.open();
    }




}
