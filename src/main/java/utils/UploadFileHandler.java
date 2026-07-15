package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;

public class UploadFileHandler {

    public void uploadResume() {

        try {
            // Convert project-relative path to absolute path
            String filePath = Paths.get("src", "test", "resources", "Ashutosh_Behera_Resume.pdf")
                                   .toAbsolutePath()
                                   .toString();

            System.out.println("-----Uploading file: " + filePath + "-----");

            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            Robot robot = new Robot();

            // Small delay to ensure the file dialog is active
            robot.delay(1000);

            // Ctrl + V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(500);

            // Press Enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("-----File Uploaded Successfully -----");

        } catch (AWTException e) {
            System.out.println("-----File Upload Failed -----");
            e.printStackTrace();
        }
    }
}