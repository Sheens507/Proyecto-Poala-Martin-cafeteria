
package com.example.proyectoprogressbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionarComida extends AppCompatActivity {

    private Spinner spinnerProteina, spinnerCarbohidratos, spinnerAcompanamiento, spinnerBebida;
    private TextView textResult;
    private Button pagar;
    private float sum;


    // Arrays de ejemplo con sus respectivos valores, incluyendo la opción predeterminada
    private String[] proteinas = {"-- Seleccionar", "Pollo - 3.25", "Carne - 4.00", "Pescado - 5.00"};
    private String[] carbohidratos = {"-- Seleccionar", "Arroz - 2.50", "Pasta - 3.00", "Pan - 1.25"};
    private String[] acompanamientos = {"-- Seleccionar", "Ensalada - 2.00", "Papas Fritas - 2.75", "Verduras - 2.00"};
    private String[] bebidas = {"-- Seleccionar", "Agua - 1", "Jugo - 1.50", "Refresco - 1.50"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_comida);

        spinnerProteina = findViewById(R.id.spinner_proteina);
        spinnerCarbohidratos = findViewById(R.id.spinner_carbohidratos);
        spinnerAcompanamiento = findViewById(R.id.spinner_acompanamiento);
        spinnerBebida = findViewById(R.id.spinner_bebida);
        Button buttonCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);
        pagar = findViewById(R.id.pagar);

        // Configurar adaptadores para los spinners
        setUpSpinner(spinnerProteina, proteinas);
        setUpSpinner(spinnerCarbohidratos, carbohidratos);
        setUpSpinner(spinnerAcompanamiento, acompanamientos);
        setUpSpinner(spinnerBebida, bebidas);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float total = calculateTotal();
                textResult.setText("Total: B/. " + total);
            }
        });

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aqui modificar
                Intent intent = new Intent(SeleccionarComida.this, PasarelaPago.class);
                intent.putExtra("SUMA_TOTAL", sum);
                startActivity(intent);
                startActivity(intent);
            }
        });
    }

    private void setUpSpinner(Spinner spinner, String[] items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private float calculateTotal() {
        float total = 0;

        total += getValueFromSelection(spinnerProteina);
        total += getValueFromSelection(spinnerCarbohidratos);
        total += getValueFromSelection(spinnerAcompanamiento);
        total += getValueFromSelection(spinnerBebida);

        return total;
    }

    private float getValueFromSelection(Spinner spinner) {
        String selectedItem = (String) spinner.getSelectedItem();
        if (selectedItem.equals("-- Seleccionar")) {
            return 0;
        }
        String[] parts = selectedItem.split(" - ");
        return Float.parseFloat(parts[1]);
    }


}
