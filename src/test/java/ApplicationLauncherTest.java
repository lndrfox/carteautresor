import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class for ApplicationLauncher
 */
class ApplicationLauncherTest {

    @Test
    void endToEndTest(){
        String[] args = new String[]{"./resources/input.txt"};
        ApplicationLauncher.main(args);

        File createdFile = new File("./resources/created.txt");
        assertTrue(createdFile.exists(),"No output file was created.");

        File expectedOutput = new File("./resources/output.txt");

        try {
            assertTrue(FileUtils.contentEquals(createdFile,expectedOutput),"the created output file did not match the expected" +
                    "content.");
        } catch (IOException e) {
            fail("Unexpected exception encountered while testing : " + e.getMessage());
        }

    }

}
