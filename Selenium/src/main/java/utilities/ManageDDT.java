package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{

    @DataProvider(name = "data-provider-textForSearch")
    public Object[][] getDataObjectText() {
        return getDataFromCSVColumn(getData("DDTFile_TextSearch"));
    }

    @DataProvider(name = "data-provider-resolutions")
    public Object[][] getDataObjectResolution() {
        return getDataFromCSV(getData("DDTFile_Resolutions"));
    }

    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static Object[][] getDataFromCSVColumn(String filePath) {
        Object[][] data = new Object[3][1];
        List<String> csvData = readCSV(filePath);
        for (int i=0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i);
        }
        return data;
    }

    public static Object[][] getDataFromCSV(String filePath) {
        Object[][] data = new Object[2][2];
        List<String> csvData = readCSV(filePath);
        for (int i=0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

}