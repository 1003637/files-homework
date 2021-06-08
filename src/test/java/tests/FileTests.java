package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.*;
import static utils.Zip.unzip;

public class FileTests {

    @Test
    public void verifyTxtFile() throws IOException {
        String txtFilePath = "./src/test/resources/files/test_1.txt";
        String expectedData = "\"Fear is the path to the dark side. Fear leads to anger; anger leads to hate; hate leads to suffering. I sense much fear in you.\" — Yoda";
        String actualData = readTextFromPath(txtFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    public void verifyPdfFile() throws IOException {
        String pdfFilePath = "./src/test/resources/files/test_2.pdf";
        String expectedData = "\"Fear is the path to the dark side. Fear leads to anger; anger leads to hate; hate leads to suffering. I sense much fear in you.\" — Yoda";
        assertThat(getPDF(pdfFilePath), PDF.containsText(expectedData));
    }

    @Test
    public void verifyXLSXFile() throws IOException {
        String xlsxFilePath = "./src/test/resources/files/test_3.xlsx";
        String expectedData = "\"Fear is the path to the dark side. Fear leads to anger; anger leads to hate; hate leads to suffering. I sense much fear in you.\" — Yoda";
        assertThat(readXLSXFile(xlsxFilePath), containsString(expectedData));
    }

    @Test
    public void verifyXLSFile() throws IOException {
        String xlsFilePath = "./src/test/resources/files/test_6.xls";
        String expectedData = "\"Fear is the path to the dark side. Fear leads to anger; anger leads to hate; hate leads to suffering. I sense much fear in you.\" — Yoda";
        assertThat(getXLS(xlsFilePath), XLS.containsText(expectedData));
    }

    @Test
    public void verifyDOCXFile() throws IOException {
        String docxFilePath = "./src/test/resources/files/test_4.docx";
        String expectedData = "\"Fear is the path to the dark side. Fear leads to anger; anger leads to hate; hate leads to suffering. I sense much fear in you.\" — Yoda";
        String actualData = readDocxFile(docxFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    public void verifyDOCFile() throws IOException {
        String docFilePath = "./src/test/resources/files/test_5.doc";
        String expectedData = "\"Fear is the path to the dark side. Fear leads to anger; anger leads to hate; hate leads to suffering. I sense much fear in you.\" — Yoda";
        String actualData = readDocFile(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    public void verifyZipFile() throws ZipException, IOException {
        String zipFilePath = "./src/test/resources/files/test_5.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String unzipFilePath = "./src/test/resources/files/unzip/test_5.txt";
        String zipPass = "";
        String expectedData = "\"Fear is the path to the dark side. Fear leads to anger; anger leads to hate; hate leads to suffering. I sense much fear in you.\" — Yoda";

        unzip(zipFilePath, unzipFolderPath, zipPass);
        String actualData = readTextFromPath(unzipFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
