package com.example.proyectoprogressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ECONOMICO extends AppCompatActivity {
    private TextView tv3;
    private CheckBox ck1, ck2, ck3;
    private Button btn, eco, eje, per;
    private float sum;
    private String resu = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.economico);

        ck1 = findViewById(R.id.arrozP);
        ck2 = findViewById(R.id.arrozG);
        ck3 = findViewById(R.id.chuletaY);
        tv3 = findViewById(R.id.resul);
        btn = findViewById(R.id.agregar);
        eco = findViewById(R.id.economico);
        eje = findViewById(R.id.ejecutivo);
        per = findViewById(R.id.personal);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sum = 0;
                if (ck1.isChecked()) {
                    sum = (float) (sum + 4.5);
                }
                if (ck2.isChecked()) {
                    sum = sum + 3;
                }
                if (ck3.isChecked()) {
                    sum = sum + 4;
                }
                resu = "B/. " + sum;
                tv3.setText(resu);
            }
        });

        eco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ECONOMICO.this, ECONOMICO.class);
                startActivity(intent);
            }
        });

        eje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ECONOMICO.this, EJECUTIVO.class);
                startActivity(intent);
            }
        });
        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ECONOMICO.this, SeleccionarComida.class);
                startActivity(intent);
            }
        });
    }
}
