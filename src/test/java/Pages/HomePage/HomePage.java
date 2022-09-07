package Pages.HomePage;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@DefaultUrl("page:base.url")
public class HomePage extends PageObject {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @FindBy(id = "MainNav-Package")
    public WebElementFacade AccountPageLink;

    @FindBy(id = "chevron-header")
    public WebElementFacade welcomeUserChevron;



    @FindBy(id = "MainNav-Store")
    public WebElementFacade store;

    @FindBy(className = "menu__header")
    public List<WebElementFacade> productName;

    @FindBy(className ="menu__link" )
    public List<WebElementFacade> productVariety;



    public WebElementFacade findProduct(String productCategory,String productBrand) {

       if(productName.stream().filter(element -> element.getText().equalsIgnoreCase(productCategory)).findAny().get().isDisplayed())
       {
           return productVariety.stream().filter(element -> element.getText().equalsIgnoreCase(productBrand)).findAny().get();
       }
       else return null;
    }


}



