
import com.codeborne.selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.testng.annotations.BeforeTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest  {
    File doc = new File ("src/main/resources/Document.pdf");


    @Test
    public void base_test() throws Exception {
        open("http://spci-2-2-0-test.ci.sdlabs.de/cirrus/");
        $(By.xpath("//button[contains(text(),'Login')]")).click();
        $(By.xpath("//input[@formcontrolname='accountId']")).setValue("signdoc");
        $(By.xpath("//input[@formcontrolname='credentials']")).setValue("dbr");
        $(By.xpath("//input[@formcontrolname='password']")).setValue("2beChanged!");
        $(By.xpath("//button[.='Sign in']")).click();
        $(By.xpath("//a[contains(text(),'Signing packages')]")).click();
        $(By.xpath("//button[@class='btn btn-light']")).click();
        $(By.xpath("//button[@id='recipients_btn_add_me']")).click();
        $(By.xpath("//label[@for='recipients-auto-prepare']")).click();
        $(By.xpath("//input[@type='file']")).uploadFile(doc);
        $(By.xpath("//button[contains(.,'NEXT')]")).click();

        Thread.sleep(3000);
        $(By.xpath("//button[contains(.,'FINISH')]")).click();
        Thread.sleep(3000);

    }

}
