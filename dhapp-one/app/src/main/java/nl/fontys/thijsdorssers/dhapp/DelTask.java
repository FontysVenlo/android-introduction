package nl.fontys.thijsdorssers.dhapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Thijs Dorssers on 12-11-2017.
 * still some android issues to be solved, like updating UI from async thread
 * see line 44.
 * Possible solution, see GetTask where id is passed as parameter in the constructor
 */

public class DelTask extends AsyncTask<String, Void, Void> {

    private Activity activity;
    private int id;

    public DelTask(Activity activity, int id) {
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

            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            // by default the request is a GET request
            // hence we have to configure a DELETE request
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept","application/json");
            conn.connect();

            final int responseCode = conn.getResponseCode();

            final TextView text = (TextView) activity.findViewById(R.id.textView);
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    text.setText("DELETE executed: " + responseCode);
                }
            });

            //text.setText("DELETE executed: " + responseCode);
            conn.disconnect();

        } catch (NumberFormatException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
