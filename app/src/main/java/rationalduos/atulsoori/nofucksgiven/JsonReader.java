package rationalduos.atulsoori.nofucksgiven;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.Buffer;
import java.nio.charset.Charset;

/**
 * Created by ravio on 6/26/2016.
 */
public class JsonReader extends JSONObject {
    JSONObject json;
    JsonReader(FileInputStream input) throws JSONException, IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(input,Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        json = new JSONObject(jsonText);
        input.close();
    }
    JsonReader(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        json = new JSONObject(jsonText);
        is.close();
    }
    public JSONObject getJson()
    {
        return json;
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
     public String toString()
     {
         return json.toString();
     }

}
