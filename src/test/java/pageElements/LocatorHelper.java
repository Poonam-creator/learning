package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Hooks;
import utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;

public class LocatorHelper extends Hooks {

    public void search(String item){
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys(item);
    }
    public void clickOnSearch(){
        driver.findElement(By.xpath("//span[@class='dc-button-text']")).click();
    }
   public String getUrl(){
       return driver.getCurrentUrl();
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String selectAnyProduct(){
        List<WebElement> productwebelements = driver.findElements(By.className("productTitle"));
        if(productwebelements.size() == 0){
            fail("no product available for serch");
        }
        int productCount = productwebelements.size();
        int randomNumber = new RandomNumberGenerator().generateRandomNumber(productCount);
        String productselected = productwebelements.get(randomNumber).getText();
        productwebelements.get(randomNumber).click();
        return productselected;
    }

    public void selectPrice(String priceRange){
            int counter =0;
        List<WebElement> filters = driver.findElements(By.className("dc-checkbox-label"));
        for(WebElement filter : filters){
            if(filter.getText().equalsIgnoreCase(priceRange)){
                counter++;
                filter.click();
                break;
            }
        }
        if(counter == 0){
            fail("price range not found");
        }

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public List<Double> getAllPrices() {
        List<Double> collectedPrices = new ArrayList<>();

        List<WebElement> pricesOfWebElements = driver.findElements(By.className("price"));
        for (WebElement priceWebelement : pricesOfWebElements) {
            String priceInString = priceWebelement.getText().replace("£", "");
            Double priceInDouble = Double.parseDouble(priceInString);
            collectedPrices.add(priceInDouble);
        }
        if(collectedPrices.size() == 0){
            fail("nothing collected may b product = 0");
        }
        return collectedPrices;
    }

    public void selectBrand(String brand){
        int counter = 0;
        //List<WebElement> brandWebelements = driver.findElements(By.className("dc-filter__option-list"));
        List<WebElement> brandWebelements = driver.findElements(By.xpath("//ul[@class ='dc-filter__option-list']//li/descendant::div[class='dc-checkbox-label']"));
        for(WebElement brandWebelement :brandWebelements){
            if(brandWebelement.getText().equalsIgnoreCase(brand))
            counter++;
            brandWebelement.click();
            break;
        }
        if(counter == 0){
            fail("No match found for" + brand);
        }
    }
    public void slectRelevance(){
        driver.findElement(By.className("dc-select-selected")).click();
    }
    public void addProductToBasket() {
        driver.findElement(By.xpath("//div[@id='product-actions']//button[@class='Button-hYXUXp fIBPaH'][contains(text(),'Add to basket')]")).click();
    }
    public void continueToBasket(){
        driver.findElement(By.xpath("//button[@class='Button-hYXUXp sc-htoDjs fFDyiO']")).click();
    }
    public String getProductInBasket(){
        return driver.findElement(By.className("vertical-rhythm-medium sc-ifAKCX eozVKh")).getText();

    }
    public void selectDepartmentFromsggetion(String item){
        driver.findElement(By.className("dc-search-suggestions")).click();
    }
    public String getPageTitle(){
        return driver.findElement(By.className("pageTitle")).getText();

    }
    public void selectFromsuggetions( String item){
        List<WebElement> suggetionsOfwebelements = driver.findElements(By.className("dc-search-suggestions__suggestion dc-search-suggestions__suggestion--term"));
        int countOfsuggetions = suggetionsOfwebelements.size();

        if(countOfsuggetions == 0){
            fail("i have no suggetions for" + item );

            }
        int randomNumber = new RandomNumberGenerator().generateRandomNumber(countOfsuggetions);
        String suggetionSelected = suggetionsOfwebelements.get(randomNumber).getText();
        suggetionsOfwebelements.get(randomNumber).click();

    }
}
/*
public void selectFromSuggestions(String item, By by) {
        List<WebElement> suggestionsElemets = driver.findElements(by);
        int listSize = suggestionsElemets.size();
        if (listSize == 0) {
            fail("I dont have any suggestion for u" + item);
        }

        int randomIndex = new RandomNumberHelper().generateRandomNumber(listSize);
        WebElement selectedElement = suggestionsElemets.get(randomIndex);

        String selectedSuggestio = selectedElement.getText();
        selectedElement.click();
    }
 */
