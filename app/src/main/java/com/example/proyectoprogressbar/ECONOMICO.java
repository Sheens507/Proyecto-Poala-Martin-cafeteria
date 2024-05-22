package com.example.proyectoprogressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
public class ECONOMICO extends AppCompatActivity {
    private TextView tv3;
    private CheckBox ck1, ck2, ck3, ck4;
    private Button btn;
    private float sum;
    private String resu = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ck1 = (CheckBox) findViewById(R.id.arrozP);
        ck2 = (CheckBox) findViewById(R.id.arrozGuandu);
        ck3 = (CheckBox) findViewById(R.id.chuletaC);
        tv3 = findViewById(R.id.resul);
        btn = findViewById(R.id.agregar);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sum = 0;
                if (ck1.isChecked() == true) {
                    sum = (float) (sum + 4.5);
                }
                if (ck2.isChecked() == true) {
                    sum = sum + 5;
                }
                if (ck3.isChecked() == true) {
                    sum = (float) (sum + 3.5);
                }
                resu = "B/. " + sum;
                tv3.setText(resu);
            }
   });
}
}