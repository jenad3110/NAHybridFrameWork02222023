package com.tutorialsninja.tests;

import com.tutorialsninja.qa.base.CommonAPI;
import com.tutorialsninja.qa.pages.LandingPage;
import com.tutorialsninja.qa.pages.TabletPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TabletPageTest extends CommonAPI {
    public static Logger log = LogManager.getLogger(TabletPageTest.class.getName());


    @Test(enabled = false)
    public void clickTabletButton() {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.clickTabletButton();

    }


    @Test
    public void clickSamsungGalaxyTabText() {

        LandingPage landingPage = new LandingPage(getDriver());

        landingPage.clickTabletButton();

        TabletPage tabletPage = new TabletPage(getDriver());

        tabletPage.clickSamsungGalaxyTabText();
        log.debug("clickSamsungGalaxyTabText");

    }


}
