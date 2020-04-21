package nl.fontys.thijsdorssers.dhapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dos on 16/12/2017.
 */

public class GetAllTask extends AsyncTask<String, Void, Void> {

    private Activity activity;

    public GetAllTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            final String link = "https://dhapp.mybluemix.net/api/Employees/";

            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // by default the request is a GET request
            conn.connect();

            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            StringBuilder outPutString = new StringBuilder();

            JSONArray jsonArray = new JSONArray(jsonString.toString());
            for (int i=0; i<jsonArray.length(); i++) {
                final int id = jsonArray.getJSONObject(i).getInt("id");
                final String lastName = jsonArray.getJSONObject(i).getString("lastname");
                final String firstName = jsonArray.getJSONObject(i).getString("firstname");
                final String objectLine = id + ":" +firstName + " " + lastName + "\n"; // \n inserts a new line
                outPutString.append(objectLine);
            }

            final TextView text = (TextView) activity.findViewById(R.id.getAllView);
            final String outPutStringFinal = outPutString.toString();

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    text.setText(outPutStringFinal);
                }
            });

            conn.disconnect();

        } catch (NumberFormatException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
