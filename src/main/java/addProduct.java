import com.sun.tools.javac.Main;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class addProduct {
    WebDriver driver;
    String BASE_URL = "https://www.akakce.com/";
    String searchBar = "//input[@id='q']";
    String searchButton = "//button[@title='Ara']";
    String itemList = "//ul[@id='CPL']/li";
    String uruneGitButton = "//li[1]//span[@class='bt_v8']";
    String takipEtButton = "//div[@id='ntf_w']//span[@class='ufo_v8']";
    String unFollowButton = "//div[@id='ntf_w']//span[@class='ufo_v8 a']";
    String mail = "//input[@id='life']";
    String pwd = "//input[@id='lifp']";
    String loginButton ="//input[@id='lfb']";
    String profile = "//a[@id='H_a_v8']";
    String myList ="//a[@id='HM_f_v8']";
    String singInButton = "//div[@id='H_rl_v8']//a[2]";
    public String text1 = "";
    String myListItems = "//form[@class='fl_w']//li";


    public void waitElement(String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public void clickElement(String element) {

        driver.findElement(By.xpath(element)).click();
    }
    public void sendKeys(String element,String text){

        driver.findElement(By.xpath(element)).sendKeys(text);
    }
    public void pageDown(){
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.tagName("body")), Keys.PAGE_DOWN).perform();
    }

    public void setDriver() {
        driver = new ChromeDriver();
    }

    public void goPage() throws InterruptedException{
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        SearchContext searchContext = driver.findElement(By.xpath("//efilli-layout-dynamic")).getShadowRoot();
        searchContext.findElement(By.cssSelector("div[id='59e066d1-086d-4238-a9a7-b31ba072937c']")).click();
    }

    public void searchItem() throws InterruptedException{
        waitElement(searchBar);
        clickElement(searchBar);
        sendKeys(searchBar,"iphone");
        Thread.sleep(1000);
        clickElement(searchButton);
    }


    public void getItemList() throws InterruptedException{
        waitElement(uruneGitButton);
        int itemListCount = (int) driver.findElements(By.xpath(itemList)).stream().count();
        Random random = new Random();
        int randomNum = random.nextInt(itemListCount)+1;
        String element = "//ul[@id='CPL']/li["+randomNum+"]";
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li["+(randomNum)+"]//span[@class='bt_v8']")).click();
        text1= driver.findElement(By.xpath("//div[@class='pdt_v8']//h1")).getText();

    }

    public void addToList()throws InterruptedException{
        pageDown();
        Thread.sleep(5000);

        String status = (driver.findElement(By.xpath("//div[@id='ntf_w']/span[1]")).getText()).substring(0,6);

       if(status.equals("Takip ")){waitElement(takipEtButton);clickElement(takipEtButton);System.out.println("Ürün Takip Listesine Eklendi.");}
      else {System.out.println("Ürün Takip Listesine Zaten Eklenmiş.");}


    }
    public void loginPage() throws InterruptedException{
        Thread.sleep(2000);
        waitElement(singInButton);
        clickElement(singInButton);
        waitElement(pwd);
        clickElement(mail);
        sendKeys(mail,"ufuk.testv1@gmail.com");
        clickElement(pwd);
        sendKeys(pwd,"11034Asd");
        clickElement(loginButton);


    }
    public void myListPage() throws InterruptedException{
        waitElement(myList);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(profile))).perform();
        clickElement(myList);
        driver.findElements(By.xpath(myListItems));
        int itemListCount = (int) driver.findElements(By.xpath(myListItems)).stream().count();
        String text2 = driver.findElement(By.xpath("//h3[@class='pn_v8']")).getText();
        //System.out.println(text1 + text2);
        for(int i=1;i<=itemListCount;i++){
            if(text1.equals(driver.findElement(By.xpath("//form[@class='fl_w']//li["+i+"]//a//span//h3")).getText())){
                System.out.println("Ürünün Listede Olduğu Doğrulanmıştır.");
                break;
            }


        }

    }









}