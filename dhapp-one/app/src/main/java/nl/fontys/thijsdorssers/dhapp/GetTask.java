package nl.fontys.thijsdorssers.dhapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;
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
 * Created by Thijs Dorssers on 12-11-2017.
 */

public class GetTask extends AsyncTask<String, Void, Void> {

    private Activity activity;
    private int id;

    public GetTask(Activity activity, int id) {
        this.activity = activity;
        this.id = id;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            final String link = "https://dhapp.mybluemix.net/api/Employees/" + id;
            // using a http url causes android security issues, because of the insecure url.
            // see AndroidManifest.xml for a kind of solution.
            // see https://developer.android.com/training/articles/security-config.html#CleartextTrafficPermitted

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

            JSONObject object = new JSONObject(jsonString.toString());
            final int objectId = object.getInt("id");
            final String lastName = object.getString("lastname");
            final String firstName = object.getString("firstname");

            final TextView text = (TextView) activity.findViewById(R.id.textView);

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    text.setText(objectId + ":" +firstName + " " + lastName);
                }
            });

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
            final TextView text = (TextView) activity.findViewById(R.id.textView);
            // Thread is a functional interface, thus next call is valid as well
            activity.runOnUiThread(new Thread() {
                @Override
                public void run() {
                    text.setText("not present");
                }
            });
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
