package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='cookie-close abs cookiesBarClose']")
    protected WebElement acceptCookieAndCloseButton;

    @FindBy(xpath = "//a[@id='choosecat']")
    protected WebElement headingList;

    @FindBy(xpath = "//a[@id='choosecat'] | //li[@class='grid-li']/ul/li")
    protected List<WebElement> fieldsFromFilterForm;

    @FindBy(xpath = "//div[@class='filter-headline']")
    protected List<WebElement> listTitlesFromFilterForm;

    @FindBy(xpath = "//div[@class='filter-headline']/following-sibling::div")
    protected List<WebElement> listDefaultValueFromFilterForm;


    public void acceptCookieAndCloseBar(){

        if(acceptCookieAndCloseButton.isDisplayed()){
            acceptCookieAndCloseButton.click();
        }
    }

    public Map <String, String> getValuesFromSearchByTitle(){

        return createdMapWithStringData(getTextElementFromList(listTitlesFromFilterForm),
                getTextElementFromList(listDefaultValueFromFilterForm));
    }

    public Map <String, WebElement> getWebElementsFromSearchByTitle(){

        return createdMapWithWebElements(getTextElementFromList(listTitlesFromFilterForm), listDefaultValueFromFilterForm);
    }

    public void getAllBrands(){
        WebElement element = driver.
                findElement(By.xpath(getXpathByWebElement(listTitlesFromFilterForm.get(1))
                + "/parent::li[@class='subcategory']//span[@class='icon down abs']"));
        element.click();
    }

}
