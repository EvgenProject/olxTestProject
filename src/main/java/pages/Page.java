package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public abstract class Page {

    protected WebDriver driver = null;
    protected Actions doAction = null;
    protected JavascriptExecutor js = null;

    public Page(WebDriver driver){
        this.driver = driver;
        this.doAction = new Actions(driver);
        this.js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextElement(WebElement element){

        return element.getText();
    }

    public List<String> getTextElementFromList(List<WebElement> listOfElements){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < listOfElements.size(); i++){
            list.add(listOfElements.get(i).getText());
        }
        return list;
    }


    public Map <String, String> createdMapWithStringData(List<String> firstList, List<String> secondList){
        Map<String, String> mapList = new HashMap();

        for (int i = 0; i < firstList.size(); i++){
            mapList.put(firstList.get(i), secondList.get(i).replace("\n", " "));
        }
        return mapList;
    }


    public Map <String, WebElement> createdMapWithWebElements(List<String> firstList, List<WebElement> secondList){
        Map<String, WebElement> mapList = new HashMap();

        for (int i = 0; i < firstList.size(); i++){
            mapList.put(firstList.get(i), secondList.get(i));
        }
        return mapList;
    }

    protected String getXpathByWebElement(WebElement element){
        List<String> elementList = Arrays.asList(element.toString().split(" "));
        String xpath = " ";

        for(int i = 0; i < elementList.size() - 1; i++){
            if (elementList.get(i).equals("xpath:")) xpath = elementList.get(i+1);
        }
        return xpath.substring(0, xpath.length()-1);
    }
}
