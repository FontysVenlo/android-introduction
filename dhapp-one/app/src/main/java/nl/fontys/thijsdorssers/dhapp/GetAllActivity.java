package nl.fontys.thijsdorssers.dhapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GetAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);

        new GetAllTask(this).execute();
    }
}
