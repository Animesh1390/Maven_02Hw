package org.example;

import org.openqa.selenium.By;  // Marker interface for credentials used for authenticating a browser to a site
import org.openqa.selenium.WebDriver; //  References the WebDriver interface which is required to instantiate a new web browser
import org.openqa.selenium.chrome.ChromeDriver; // A WebDriver implementation that controls a Chrome browser running on the local machine.
import org.testng.annotations.AfterMethod;  //The annotated method will be run after each test method.
import org.testng.annotations.BeforeMethod; //Imported Before method for  It will call Every time before Test Method
import org.testng.annotations.Test; // imported for used to control the next method to be executed in the test script.

import java.text.SimpleDateFormat;

public class HomePage
{
    protected static WebDriver driver;
    // driver.findElement command is used to access any single element from web & here we created with .click
    public void ClickElement(By by)//
    {
        driver.findElement(by).click();//
    }

    public void EnterText(By by, String Text)
    {
        driver.findElement(by).sendKeys(Text); // .sendkeys is a method in Selinium that allows to type content automatically

    }
    // returns the innerText of an element,  Method created separate for reusability
    public String GetTextFromElement(By by)
    {
        return driver.findElement(by).getText(); // .getText returns the innerText of an element,


    }
    //The @BeforeMethod annotated method will be invoked before the execution of each test method where the test method is nothing but a test case
    
    @BeforeMethod
    public void OpenBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");

        //object created for Chrome Driver
        driver = new ChromeDriver();

        // for maximize screen
        driver.manage().window().maximize();

        // driver.get command is used for to open an Url and it will wait till whole page gets loaded
        driver.get("https://demo.nopcommerce.com/");
    }

    //This annotated method will be run after each test method.
    @AfterMethod
    public void CloseBroswer()  // to close the browser
    {
        driver.close();
    }

    @Test // annotated method will be run after each test method.
    public void Register()
    {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        System.out.println(timeStamp);

        ClickElement(By.className("ico-register"));

        ClickElement(By.id("gender-male"));

        // EnterText(Reusable method called)  for uniquely identify a web element with in the webpage by id , by class name , by xpath

        EnterText(By.id("FirstName"),"Animesh" );
        EnterText(By.id("LastName"),"Patel");
        EnterText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[1]"), "13");
        EnterText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[2]"), "Aug");
        EnterText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[3]"), "1990");

        EnterText(By.id("Email"), "animesh1390" +timeStamp + "@gmail.com" );
        EnterText(By.id("Company"),"AbcLtd");

        ClickElement(By.xpath("//input[@id='Newsletter']"));


        EnterText(By.id("Password"),"Animesh1234");
        EnterText(By.id("ConfirmPassword"),"Animesh1234");
        ClickElement(By.id("register-button"));


        String regMsg = GetTextFromElement(By.className("result"));

        System.out.println();// for better space in console

        // to print out result in console though stored variable
        System.out.println(regMsg);

    }

@Test //annotated method will be run after each test method.

    public void Product()
{
// ClickElement (Reusable method called)  for uniquely identify a web element with in the webpage by id , by class name , by xpath

    ClickElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));
    ClickElement(By.xpath("//h2[@class=\"title\"]//a [@title=\"Show products in category Desktops\"]"));
    String regMsg = GetTextFromElement(By.xpath("//h2[@class=\"product-title\"]//a[@href=\"/build-your-own-computer\"]"));
    // for better space in console
    System.out.println();

    // to print message in console
    System.out.println(regMsg);

    System.out.println();// for better space in console


}

@Test  //annotated method will be run after each test method.
    public void NewsComment()
{
    // ClickElement , EnterText (Reusable methods called)  for uniquely identify a web element with in the webpage by id , by class name , by xpath
    ClickElement(By.xpath("//div[@class=\"news-item\"]/div[3]//a[@href=\"/nopcommerce-new-release\"]"));
    EnterText(By.id("AddNewComment_CommentTitle"),"Hello Nop Commerce");
    EnterText(By.id("AddNewComment_CommentText"),"Nice Website");
    ClickElement(By.name("add-comment"));

    //Local variable regMsg introduced

    String regMsg = GetTextFromElement(By.xpath("//div[@class=\"result\"]"));
    System.out.println();  //  for better space in console

    // print out
    System.out.println(regMsg);
    System.out.println();// for better space on Console


}

@Test //annotated method will be run after each test method.

    public void HomePageCatagories()

    {
  // Local Variable regMsg Declared to store the value get from reusable method GetTextFromElement through xpath , id or by class

        String regMsg = GetTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));

        String regMsg1= GetTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/electronics\"]"));
        String regMsg3 = GetTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/apparel\"]"));
        String regMsg4 = GetTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/digital-downloads\"]"));
        String regMsg5 = GetTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/books\"]"));
        String regMsg6= GetTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/jewelry\"]"));
        String regMsg7= GetTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/gift-cards\"]"));

        System.out.println();  // for better space in console

        //Local variable regMsg introduced to store the find element through .gettext command

        System.out.println(regMsg + "   " + regMsg1 + "   "+regMsg3 + "   "+ regMsg4 +"   " + regMsg5 + "   " + regMsg6 + "   " + regMsg7);
        System.out.println();// for better space in console



    }

    @Test  //annotated method will be run after each test method.

    public void EmailFriend()
    {
        // Time Stamp method imported to print the time stamp to use email multiple times.

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        System.out.println(timeStamp); // to print the timestamp

        // ClickElement , EnterText (Reusable methods called)  for uniquely identify a web element with in the webpage by id , by class name ,x path

        ClickElement(By.xpath("//h2[@class=\"product-title\"]//a[@href=\"/apple-macbook-pro-13-inch\"]"));
        ClickElement(By.xpath("//div[@class=\"email-a-friend\"]"));
        EnterText(By.id("FriendEmail"),"animesh2142"+timeStamp+"@gmail.com");
        EnterText(By.id("YourEmailAddress"),"animesh1390"+timeStamp+"@gmail.com");
        EnterText(By.id("PersonalMessage"),"MacBook pro 13 ohh yeah ");
        ClickElement(By.name("send-email"));
        String regMsg = GetTextFromElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));

        System.out.println(); // for better space

        System.out.println(regMsg); // for Print Message In console

        System.out.println();// for better space in console


    }


}
