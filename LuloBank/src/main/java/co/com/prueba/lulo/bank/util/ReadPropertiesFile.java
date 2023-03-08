package co.com.prueba.lulo.bank.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ReadPropertiesFile {
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    private static String propertyFilePath = "./src/test/resources/config.properties";
    private static String url;
    private static ReadPropertiesFile instance;

    private static String APP_ID = "640768bf9985da2dc047cc6a";

    public static ReadPropertiesFile getInstance() throws IOException {
        if (instance == null) {
            instance = new ReadPropertiesFile();
            instance.loadData();
        }

        return instance;
    }

    public void loadData() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(propertyFilePath));
        url = properties.getProperty("url");
    }
     public String getUrl(){
        return url;
     }


}


