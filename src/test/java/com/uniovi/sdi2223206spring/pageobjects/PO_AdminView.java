package com.uniovi.sdi2223206spring.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO_AdminView extends PO_NavView {
    static public void fillAdminForm(WebDriver driver,
                                     List<Integer> positionsToClick) {
        List<WebElement> checkBoxs = driver
                .findElements(By.name("checkbox[]"));
        for (int i = 0; i < checkBoxs.size(); i++)
            if (positionsToClick.contains(i))
                checkBoxs.get(i).click();

        driver.findElement(By.id("deleteButton")).click();
    }
}
