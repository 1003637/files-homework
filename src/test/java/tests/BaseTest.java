package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public void setUp(){
        Configuration.downloadsFolder = "downloads";
        Configuration.startMaximized = true;
    }
}
