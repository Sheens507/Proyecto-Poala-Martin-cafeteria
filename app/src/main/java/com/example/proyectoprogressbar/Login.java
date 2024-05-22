package com.example.proyectoprogressbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    String[] users = {"8-985-772", "8-968-248", "13-25-542"};
    String[] passwords = {"Holamartin", "Holapaola", "hot123"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validateLogin(username, password)) {
                    Toast.makeText(Login.this, "Inicio de Sesión Exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, ECONOMICO.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Contraseña Incorrecta o Cédula", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(username) && passwords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}

