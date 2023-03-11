package com.example.conversionmonnaie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button btnConvert;
    TextView firstCurrency;
    TextView secondCurrency;
    Spinner listCurrency;
    EditText currency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnConvert=findViewById(R.id.convertBtn);
        firstCurrency=findViewById(R.id.firstCurrency);
        secondCurrency=findViewById(R.id.secondCurrency);
        listCurrency = findViewById(R.id.listMonnaie);
        currency = findViewById(R.id.currency);

        String[] arraySpinner = new String[] {
                "DH", "EURO", "DOLLAR"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listCurrency.setAdapter(adapter);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double prix = Double.parseDouble(currency.getText().toString());

                if(listCurrency.getSelectedItem()=="DH")
                {
                    firstCurrency.setText((prix*0.096)+"$");
                    secondCurrency.setText((prix*0.090)+"€");
                }
                if(listCurrency.getSelectedItem()=="EURO")
                {
                    firstCurrency.setText((prix*11.08)+"DH");
                    secondCurrency.setText((prix*1.06)+"$");
                }
                if(listCurrency.getSelectedItem()=="DOLLAR")
                {
                    firstCurrency.setText((prix*10.41)+"DH");
                    secondCurrency.setText((prix*0.94)+"€");
                }
            }
        });

    }
}