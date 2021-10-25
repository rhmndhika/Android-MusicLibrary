package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_login extends AppCompatActivity {
    private EditText username;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) this.findViewById(R.id.username);
        btnLogin = (Button) this.findViewById(R.id.bntLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this , Library.class);

                String Username = username.getText().toString();
                if (Username.length() == 0) {
                    username.setError("Harap Diisi");
                }else{
                    intent.putExtra("Input", Username);
                    startActivityForResult(intent,1);
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(),"Hello " + Username,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}