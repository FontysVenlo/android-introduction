package nl.fontys.thijsdorssers.dhapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE_NAME = "nl.fontys.dos.send_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendGetRequest(View view) {
        final TextView idEntry = (TextView) findViewById(R.id.idEntry);
        int id = Integer.parseInt(idEntry.getText().toString());
        new GetTask(this, id).execute();
    }

    public void sendPostRequest(View view) {
        final EditText editFirstname = findViewById(R.id.editFirstname);
        String firstName = editFirstname.getText().toString();

        final EditText editLastname = findViewById(R.id.editLastname);
        String lastName = editLastname.getText().toString();

        final EditText editSalary = findViewById(R.id.editSalary);
        String salary = editSalary.getText().toString();
        new PostTask(this, new Employee(firstName,lastName,salary)).execute();
    }

    public void sendDelRequest(View view) {
        final TextView idEntry = (TextView) findViewById(R.id.editDelId);
        int id = Integer.parseInt(idEntry.getText().toString());
        new DelTask(this, id).execute();
    }

    public void getAllRequest(View view) {
        Intent receiveActivity = new Intent(this, GetAllActivity.class);
        receiveActivity.putExtra(EXTRA_MESSAGE_NAME, "Hallo");
        startActivity(receiveActivity);
    }
}
