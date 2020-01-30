package dk.byggeweb.infrastructure.test.testdata;

import javax.xml.bind.JAXB;
import java.io.File;

public abstract class JaxbDataReader {
    public static <T> T getData(String partialFilePath, Class<? extends T> type) {
        String filePath = "resources/testdata/" + partialFilePath;
        File in = new File(filePath);
        return (T) JAXB.unmarshal(in, type);
    }
}
