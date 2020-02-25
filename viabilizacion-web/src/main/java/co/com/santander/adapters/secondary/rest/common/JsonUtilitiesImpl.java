package co.com.santander.adapters.secondary.rest.common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class JsonUtilitiesImpl implements JsonUtilities {

    /*
    method that help to get property in any level, example country.direction return
    String json for direction, if not exist return exception
     */
    @Override
    public String getObjectWithKey(String nameObject, String jsonString) {
        try {
            String list[] = nameObject.split("\\.");
            String result = jsonString;
            for (String item : list) {
                result = getObjectToString(item, result);
            }
            return result;
        } catch (JSONException ex) {
            return "";
        }
    }

    /*
method that help to get property in any level, example country.directions, direction return
String property for direction, if not exist return exception
 */
    @Override
    public String getPropertyObjectWithKey(String nameObject, String property, String jsonString) {
        try {
            String list[] = nameObject.split("\\.");
            String result = jsonString;
            for (String item : list) {
                result = getObjectToString(item, result);
            }
            return getProperty(property, result);
        } catch (JSONException ex) {
            return "";
        }

    }

    @Override
    public List<String> getValuesForGivenKey(String nameObject, String nameArray, String nameKey, String jsonString) {
        try {
            String object = getObjectWithKey(nameObject, jsonString);
            JSONObject jsonObject = getJsonObject(object);
            JSONArray jsonArray = (JSONArray) jsonObject.get(nameArray);
            return IntStream.range(0, jsonArray.length())
                    .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(nameKey))
                    .collect(Collectors.toList());
        } catch (JSONException ex) {
            return new ArrayList<>();
        }

    }

    private String getObjectToString(String name, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.getJSONObject(name).toString();
    }

    private JSONObject getJsonObject(String jsonString) {
        return new JSONObject(jsonString);
    }


    private String getProperty(String name, String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.getString(name);
    }
}
