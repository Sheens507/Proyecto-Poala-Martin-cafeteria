package com.example.proyectoprogressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PasarelaPago extends AppCompatActivity {

    private float sumaTotal, Comida;
    private TextView textViewSubTotal, textViewTotalFinal;
    private RadioGroup radioGroup;
    private Button buttonCalcular, buttonpagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasarela_pago);

        textViewSubTotal = findViewById(R.id.textViewSumaTotal);
        textViewTotalFinal = findViewById(R.id.totalfinal);
        radioGroup = findViewById(R.id.radioGroup);
        buttonCalcular = findViewById(R.id.buttonCal);
        buttonpagar = findViewById(R.id.pagofinal);

        // Recuperar el valor de la suma total del Intent
        Intent intent = getIntent();
        sumaTotal = intent.getFloatExtra("SUMA_TOTAL", 0);
        textViewSubTotal.setText("B/. " + sumaTotal);
        Comida=sumaTotal;

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar la opción seleccionada en el RadioGroup
                float cargoDelivery = 0;
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                if (radioButtonId == R.id.radioButton) {
                    sumaTotal = Comida;
                    cargoDelivery = 2.50f;
                    sumaTotal += cargoDelivery;
                }else if (radioButtonId == R.id.radioButton2) {
                    sumaTotal = Comida;
                    cargoDelivery = 0;
                    sumaTotal += cargoDelivery;
                }


                // Mostrar el total final en el TextView
                textViewTotalFinal.setText("B/. " + sumaTotal);
            }
        });
        buttonpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PasarelaPago.this, "Pedido Realizado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PasarelaPago.this, ECONOMICO.class);
                startActivity(intent);
            }
        });
    }
}
