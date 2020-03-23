package co.com.santander.adapters.secondary.rest.common;

import co.com.santander.adapters.secondary.rest.common.dto.ResponseDto;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class JsonUtilitiesImpl implements JsonUtilities {

    private static final Logger log= LoggerFactory.getLogger(JsonUtilitiesImpl.class);

    /*
    method that help to get property in any level, example country.direction return
    String json for direction, if not exist return exception
     */
    @Override
    public String getObjectWithKey(String nameObject, String jsonString) {
        try {
            String list[] = nameObject.split("\\.");
            if(list.length == 0){
                list[0] = nameObject;
            }
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
            JSONArray jsonArray = new JSONArray();
            try{
                jsonArray = (JSONArray) jsonObject.get(nameArray);
            }catch (ClassCastException exc){
                jsonArray.put(jsonObject.get(nameArray));
            }
            return extractListJsonArray(jsonArray, nameKey);
        } catch (JSONException ex) {
            return new ArrayList<>();
        }
    }

    private List<String> extractListJsonArray(JSONArray jsonArray, String nameKey){
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(nameKey))
                .collect(Collectors.toList());
    }

    @Override
    public String getValueForGivenKey(String nameObject, String nameKey, String jsonString) {
        try {
            String object = getObjectWithKey(nameObject, jsonString);
            log.info(object);
            JSONObject jsonObject = getJsonObject(object);
            Object valor = jsonObject.get(nameKey);
            return (String) valor;
        } catch (JSONException ex) {
            return "";
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
    @Override
    public ResponseDto getGeneralResponse(String json){
        ResponseDto respuesta = new Gson().fromJson(json, ResponseDto.class);
        return respuesta;
    }
}
