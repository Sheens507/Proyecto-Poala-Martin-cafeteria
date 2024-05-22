// java/com/example/proyectoprogressbar/Login.java
package com.example.proyectoprogressbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    // Arrays de ejemplo
    String[] users = {"user1", "user2", "user3"};
    String[] passwords = {"pass1", "pass2", "pass3"};

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
                    // Login exitoso
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    // Lanzar actividad Estudiante
                    Intent intent = new Intent(Login.this, SeleccionarComida.class);
                    startActivity(intent);
                } else {
                    // Login fallido
                    Toast.makeText(Login.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
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

