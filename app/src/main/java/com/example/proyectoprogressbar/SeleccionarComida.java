// java/com/example/proyectoprogressbar/SeleccionarComida.java
package com.example.proyectoprogressbar;

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

    // Arrays de ejemplo con sus respectivos valores, incluyendo la opción predeterminada
    private String[] proteinas = {"-- Seleccionar", "Pollo - 100", "Carne - 150", "Pescado - 200"};
    private String[] carbohidratos = {"-- Seleccionar", "Arroz - 50", "Pasta - 60", "Pan - 40"};
    private String[] acompanamientos = {"-- Seleccionar", "Ensalada - 20", "Papas Fritas - 80", "Verduras - 30"};
    private String[] bebidas = {"-- Seleccionar", "Agua - 0", "Jugo - 50", "Refresco - 70"};

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

        // Configurar adaptadores para los spinners
        setUpSpinner(spinnerProteina, proteinas);
        setUpSpinner(spinnerCarbohidratos, carbohidratos);
        setUpSpinner(spinnerAcompanamiento, acompanamientos);
        setUpSpinner(spinnerBebida, bebidas);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = calculateTotal();
                textResult.setText("Total: " + total);
            }
        });
    }

    private void setUpSpinner(Spinner spinner, String[] items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private int calculateTotal() {
        int total = 0;

        total += getValueFromSelection(spinnerProteina);
        total += getValueFromSelection(spinnerCarbohidratos);
        total += getValueFromSelection(spinnerAcompanamiento);
        total += getValueFromSelection(spinnerBebida);

        return total;
    }

    private int getValueFromSelection(Spinner spinner) {
        String selectedItem = (String) spinner.getSelectedItem();
        if (selectedItem.equals("-- Seleccionar")) {
            return 0;
        }
        String[] parts = selectedItem.split(" - ");
        return Integer.parseInt(parts[1]);
    }
}
