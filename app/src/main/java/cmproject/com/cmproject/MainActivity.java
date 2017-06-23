package cmproject.com.cmproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText email, password;
    private ProgressDialog pDialog;
//    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        btnRegister = (Button)findViewById(R.id.btnregister);







            }
}
