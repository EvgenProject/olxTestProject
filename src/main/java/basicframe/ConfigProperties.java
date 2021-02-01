package basicframe;

import com.google.common.base.Strings;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConfigProperties {

    private static Properties PROPERTIES = null;

    static {
        PROPERTIES = new Properties();
        URL propertyUrl = java.lang.ClassLoader.getSystemResource("appconfig");
        try{
            PROPERTIES.load(propertyUrl.openStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return Strings.nullToEmpty(PROPERTIES.getProperty(key, null));
    }
}

