package co.com.santander.adapters.secondary.rest.common;

import java.util.List;

public interface JsonUtilities {
    public String getObjectWithKey(String nameObject, String jsonString);

    public String getPropertyObjectWithKey(String nameObject, String property, String jsonString);

    public List<String> getValuesForGivenKey(String nameObject, String nameArray, String nameKey, String jsonString);

    public String getValueForGivenKey(String nameObject, String nameKey, String jsonString);
}

