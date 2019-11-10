package utils;

import org.junit.Assert;
import org.junit.Test;
import pageElements.LocatorHelper;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegressionTestSuit extends  Hooks{
    private LocatorHelper helper=new LocatorHelper();

    @Test
    public void searchTest(){
        helper.search("laptop");
        helper.clickOnSearch();
      String actualTitle= helper.getTitle();
      System.out.println(actualTitle);
       String currentUrl=helper.getUrl();
       System.out.println(currentUrl);
        Assert.assertEquals("https://www.currys.co.uk/gbuk/computing/laptops/laptops/315_3226_30328_xx_xx/xx-criteria.html",currentUrl);
    }
    @Test
    public void selectRelevanceTest(){
        helper.search("laptop");
        helper.slectRelevance();
    }
    @Test
    public void addToTheBasketTest(){
        helper.search("laptop");
        helper.selectAnyProduct();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //helper.getProductInBasket();
    }
    @Test
    public void priceFilterTest() {
        String priceRange = "£299.00 - £499.00";
        List<String> expectedPrice = Arrays.asList(priceRange.replace("£", "").split("-"));
        Double min = Double.parseDouble(expectedPrice.get(0));
        Double max = Double.parseDouble(expectedPrice.get(1));

        helper.search("laptop");
        helper.clickOnSearch();
       String actualUrl= helper.getUrl();
        helper.selectPrice(priceRange);
       List<Double> actualPricelist= helper.getAllPrices();
        helper.selectAnyProduct();
        helper.addProductToBasket();

        Assert.assertEquals("https://www.currys.co.uk/gbuk/computing/laptops/laptops/315_3226_30328_xx_xx/xx-criteria.html",actualUrl);
    }
    @Test
    public void selectProductByBrandTest(){
        String brand = " HP ";
        String priceRange = "£299.00 - £499.00";
        helper.search("laptop");
        helper.clickOnSearch();
        helper.selectPrice(priceRange);
       // helper.selectBrand(brand);
        helper.selectAnyProduct();
        helper.addProductToBasket();
        helper.continueToBasket();

    }
    @Test
    public void selectProductFromDepartmentTest(){
        String searchtearm ="cable";
        helper.search(searchtearm);
        helper.selectDepartmentFromsggetion(searchtearm);
        helper.addProductToBasket();
        helper.continueToBasket();
        helper.getProductInBasket();
        String actualTitle= helper.getTitle();
       // Assert.assertEquals("cable",actualTitle);

    }
    @Test
    public void selectFromSuggetionTest(){
        String searchterm = "cable";
        helper.search(searchterm);
        helper.selectFromsuggetions(searchterm);
        helper.clickOnSearch();
    }

}
/*
 public void suggestedProductSearchTest() {
        String searchTerm = "cable";
        helper.enterSearchItem(searchTerm);
        helper.selectProductsFromSuggestions(searchTerm);

        String actual = helper.getThumbNail();
        assertThat(actual, is(equalToIgnoringCase(searchTerm)));

 */
