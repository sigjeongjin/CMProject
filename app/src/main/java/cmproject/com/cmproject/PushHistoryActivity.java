package cmproject.com.cmproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PushHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_history);

        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedInputStream buf = null;

        
    }

}
