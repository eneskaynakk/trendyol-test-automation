package utility;

import io.qameta.allure.Allure;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotSendEmail extends Utility{

    public static void screenshotMailer(WebElement element){
        try {
            File screenshot = ScreenshotSendEmail.takeScreenshot();
            sendingMail(screenshot);

            try (FileInputStream screenshotStream = new FileInputStream(screenshot)) {
                Allure.addAttachment("Screenshot", screenshotStream);
            }
        } catch (IOException | EmailException ex) {
            ex.printStackTrace();
        }
        Assert.fail("Öge Bulunamadı: " + element.toString());
    }


    public static File takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        Path screenshotDir = Paths.get("src/test/java/screenshots");
        if (!Files.exists(screenshotDir)) {
            Files.createDirectories(screenshotDir);
        }
        String fileName = "screenshot_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".png";
        Path destination = screenshotDir.resolve(fileName);
        Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        return destination.toFile();
    }

    public static void sendingMail(File screenshotFile) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("your_email", "demo123"));
        email.setSSLOnConnect(true);
        email.setFrom("your_email", "Test Automation");
        email.setSubject("Selenium Test Raporu");
        email.setMsg("Test basarisiz oldu. Ekteki ekran görüntüsüne bakabilirsiniz.");

        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(screenshotFile.getAbsolutePath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Hata Ekran Görüntüsü");
        attachment.setName(screenshotFile.getName());
        email.attach(attachment);

        email.addTo("send_email");
        email.send();
    }
}
