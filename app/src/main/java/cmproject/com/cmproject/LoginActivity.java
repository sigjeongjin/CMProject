package cmproject.com.cmproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    CheckBox autoLogin;
    Button btnLogin, btnRegister;
    EditText email, password;
    //  SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        btnRegister = (Button)findViewById(R.id.btnregister);
        autoLogin = (CheckBox)findViewById(R.id.checkbox);

//        db =(SQLiteDatabase)findViewById(R.id.SQLiteDatabase);
    }
}


