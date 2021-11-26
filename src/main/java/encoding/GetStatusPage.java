package encoding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class GetStatusPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[2]")
    WebElement jsonResponceButon;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/div[2]/pre[2]/code/button")
    WebElement copyJsonToClipboardButton;

    public void switchResponceFrameToJson(){
        jsonResponceButon.click();
    }

    public String getResponceFrameText() throws IOException, UnsupportedFlavorException {
        copyJsonToClipboardButton.click();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }
}
