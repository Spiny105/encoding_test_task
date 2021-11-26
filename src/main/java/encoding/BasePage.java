package encoding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(xpath = "//*[@id=\"ssr-main\"]/div/header/div[2]/div/div/div/button/div[2]")
    protected WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"AppSearch\"]/div/div[1]/input")
    protected WebElement searchField;

    public void search(String request){
        while (!searchField.isDisplayed()) {
            searchButton.click();
        }
        searchField.sendKeys(request);
    }
}
