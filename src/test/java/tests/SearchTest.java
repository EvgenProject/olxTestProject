package tests;

import basicframe.BasicTestFrame;
import com.google.common.base.Verify;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BasicTestFrame {

    SearchPage searchPage = null;


    @Test(enabled = false)
    public void CheckAllFieldsByDefaultValue(){

        //Arrange
        searchPage = new SearchPage(driver);
        searchPage.acceptCookieAndCloseBar();

        //Assert1
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Рубрика").equals("Легковые автомобили"));

        //Assert2
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Марка").equals("Все"));

        //Assert3
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Район").equals("Район"));

        //Assert4
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Цена").equals("от (грн.) до (грн.)"));

        //Assert5
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Год выпуска").equals("от до"));

        //Assert6
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Пробег").equals("от до"));

        //Assert7
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Объем двигателя").equals("от до"));

        //Assert8
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Тип кузова").equals("Все"));

        //Assert9
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Вид топлива").equals("Все"));

        //Assert10
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Цвет").equals("Все"));

        //Assert11
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Коробка передач").equals("Все"));

        //Assert12
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Состояние машины").equals("Все"));

        //Assert13
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Доп. опции").equals("Все"));

        //Assert14
        Verify.verify(searchPage.getValuesFromSearchByTitle().get("Растаможена").equals("Все"));
    }

    @Test(enabled = true)
    public void TestData(){

        //Arrange
        searchPage = new SearchPage(driver);
        searchPage.acceptCookieAndCloseBar();

        searchPage.test();
    }
}
