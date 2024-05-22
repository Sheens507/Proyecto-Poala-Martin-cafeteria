package com.example.proyectoprogressbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EJECUTIVO extends AppCompatActivity {
    private TextView tv3;
    private CheckBox c1, c2, c3;
    private Button bttn, eco, eje, per, pagar;
    private float sum;
    private String resu = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejecutivo);

        c1 = findViewById(R.id.arrozM);
        c2 = findViewById(R.id.pescado);
        c3 = findViewById(R.id.camarones);
        tv3 = findViewById(R.id.resul);
        bttn = findViewById(R.id.agregar);
        eco = findViewById(R.id.economico);
        eje = findViewById(R.id.ejecutivo);
        per = findViewById(R.id.personal);
        pagar = findViewById(R.id.pagar);

        bttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sum = 0;
                if (c1.isChecked()) {
                    sum = sum + 9;
                }
                if (c2.isChecked()) {
                    sum = sum + 12;
                }
                if (c3.isChecked()) {
                    sum = sum + 10;
                }
                resu = "B/. " + sum;
                tv3.setText(resu);
            }
        });

        eco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EJECUTIVO.this, ECONOMICO.class);
                startActivity(intent);
            }
        });

        eje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EJECUTIVO.this, EJECUTIVO.class);
                startActivity(intent);
            }
        });
        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EJECUTIVO.this, SeleccionarComida.class);
                startActivity(intent);
            }
        });
        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aqui modificar
                Intent intent = new Intent(EJECUTIVO.this, PasarelaPago.class);
                intent.putExtra("SUMA_TOTAL", sum);
                startActivity(intent);
                startActivity(intent);
            }
        });
    }
}

