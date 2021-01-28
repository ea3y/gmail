package com.selenium.web.common;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Listener implements TestWatcher {


  private static final Logger LOGGER = Logger.getLogger(Listener.class.getName());
  private List<TestResultStatus> testResultsStatus = new ArrayList<>();

  private enum TestResultStatus {
    SUCCESSFUL, ABORTED, FAILED, DISABLED;
  }

  @Override
  public void testFailed(ExtensionContext context, Throwable cause) {
    LOGGER.info("Test Failed: " + context.getDisplayName());
    testResultsStatus.add(TestResultStatus.FAILED);
    byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    saveScreenshot(screenshot);
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }
}
