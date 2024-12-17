package General;

import org.openqa.selenium.By;

public class Elements {
    //ApparelsPage
    public static final By ChildElementShoe = By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1) > i:nth-child(1)");
    public static final By appsNaccs = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > section:nth-child(1) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)");
    public static final By tShirts = By.cssSelector("li:nth-child(2) a:nth-child(1) img:nth-child(1)");
    public static final By shoes = By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > a:nth-child(1)");
    public static final By sortDropdown = By.cssSelector("#sort");
    public static final By productList = By.cssSelector(".thumbnails.grid.row.list-inline");
    public static final By productItems = By.cssSelector(".col-md-3.col-sm-6.col-xs-12");
    public static final By outOfStockPrdct = By.cssSelector("span.nostock");
    public static final By addToCartBtn = By.cssSelector("a.productcart[title='Add to Cart']");
    public static final By mediumShirt = By.cssSelector("#option351");
    public static final By innerBtn = By.cssSelector(".cart");
    public static final By shoeQuantity = By.cssSelector("#product_quantity");
    public static final By productDescriptionLocator1 = By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > a:nth-child(1)");
    public static final By productDescriptionLocator2 = By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > a:nth-child(1)");

    //HomePage
    public static By loginbtn = By.xpath("//a[normalize-space()='Login or register']");
    public static By homepagebtn = By.xpath("//a[@class='active menu_home']");
    public static By doveProducts = By.xpath("//img[@alt='Dove']");
    public static By sortbyDovePage = By.xpath("//select[@id='sort']");
    public static By listOfSortedItems = By.xpath("//div[@class='contentpanel']//div[1]//div[2]//a[1]//img[1]");
    public static By addToCartButtonPrdct = By.xpath("//a[normalize-space()='Add to Cart']");
    public static By itemQuantity = By.xpath("//input[@id='cart_quantity77']");
    public static By itemTotalAmount = By.xpath("//td[@class='align_right'][normalize-space()='$6.00']");
    public static final By cartBtn = By.xpath("//a[contains(@href, 'rt=checkout/cart')]");


    //LoginPage
    public static By usernameLocator = By.xpath("//input[@id='loginFrm_loginname']");
    public static By passwordLocator = By.xpath("//input[@id='loginFrm_password']");
    public static By lgnButton = By.xpath("//button[@title='Login']");

    //MenPage
    public static final By menSectionLink = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=product/category&path=58']");
    public static final By productNames = By.xpath("//a[@class='prdocutname']");
    public static final By addToCartButtonOnProductPage = By.xpath("//a[contains(@class, 'cart')]");
    public static final By cartProductNames = By.xpath("//table[@class='table table-striped table-bordered']//td[@class='align_left']//a");
    public static int MenitemsAddedToCartCount = 0;

    //LoginSetupPage
    public static final By username = By.id("user-name");
    public static final By password = By.id("password");
    public static final By lgnButtonSetup = By.id("login-button");
}
