package nl.fontys.thijsdorssers.dhapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Thijs Dorssers on 12-11-2017.
 * still some android issues to be solved, like updating UI from async thread
 * See line 52, 55, 58
 * Possible solution, see GetTask where id is passed as parameter in the constructor
 */

public class PostTask extends AsyncTask<String, Void, Void> {

    private Activity activity;
    private Employee emp;

    public PostTask(Activity activity, Employee employee) {
        this.emp = employee;
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            String link = "https://dhapp.mybluemix.net/api/Employees/";
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            // by default the request is a GET request
            // hence we have to configure a POST request
            // POST should be used for creation, because posting the same object again
            // will result in a 500 response, which basically means an error
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept","application/json");
            conn.connect();

            // use a StringBuilder to build the json string
            final StringBuilder jsonBuildString = new StringBuilder();
            jsonBuildString.append("{")
                           .append("\"firstname\":\"").append(emp.getFirstName()).append("\",")
                           .append("\"lastname\":\"").append(emp.getLastName()).append("\",")
                           .append("\"salary\":\"").append(emp.getSalary())
                           .append("\"}");

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(jsonBuildString.toString());
            dos.flush();
            dos.close();

            final int responseCode = conn.getResponseCode();
            // returns 200 in case the post was successful i.e. an object with the same id
            // not yet exists, otherwise 500 in that case an object with the same id exists.

            final TextView text = (TextView) activity.findViewById(R.id.textView);
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    text.setText("Post executed: " + responseCode + jsonBuildString.toString());
                }
            });

            conn.disconnect();

        } catch (MalformedURLException e) {
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
