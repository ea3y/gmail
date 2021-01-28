package com.selenium.web.common;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ScreenAllureExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Path path = Objects.requireNonNull(Screenshots.takeScreenShotAsFile()).toPath();
        createAttachedScreen(path);
    }

    @Attachment("{0}")
    private byte[] createAttachedScreen(Path path) {
        byte[] result;
        if (Objects.isNull(path)) {
            result = "Cannot attach file".getBytes();
        } else {
            try {
                result = Files.readAllBytes(path);
            } catch (IOException e) {
                result = ("Some problem when attach file:" + e.getMessage()).getBytes();
            }
        }
        return result;
    }
}
