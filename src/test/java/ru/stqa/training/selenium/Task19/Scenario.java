package ru.stqa.training.selenium.Task19;

import org.junit.Test;
import ru.stqa.training.selenium.Task19.Pages.MainPage;
import ru.stqa.training.selenium.Task19.Pages.PurchasePage;
import ru.stqa.training.selenium.Task19.Pages.TrashCanPage;
import ru.stqa.training.selenium.TestBase;

/**
 * Created by amil on 5/24/2017.
 */
public class Scenario extends TestBase{

    int goodsCounter=0;
    int ducksToAdd = 3;

    @Test
    public void lastTask() throws InterruptedException
    {
        MainPage mainPage = new MainPage();
        PurchasePage purchasePage = new PurchasePage();
        TrashCanPage trashCanPage = new TrashCanPage();

       for(int i=0; i<this.ducksToAdd; i++){
           mainPage.open();
           mainPage.clickToPurchase();
           purchasePage.addDuck();
           goodsCounter++;
           assert(mainPage.checkCart(goodsCounter));
       }

        mainPage.goToTrashCan();
        trashCanPage.emptyTrashCan();






    }


}
