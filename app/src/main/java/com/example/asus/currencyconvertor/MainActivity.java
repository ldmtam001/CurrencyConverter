package com.example.asus.currencyconvertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Spinner fromCurr;
    private Spinner toCurrency;
    private Button convert;
    private Button chuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.tvResult);
        fromCurr =(Spinner)findViewById(R.id.snFromCurrency);
        toCurrency =(Spinner)findViewById(R.id.snToCurrency);
        convert = (Button)findViewById(R.id.btnConvert);
        chuyen = (Button)findViewById(R.id.button2);

        addDataToSpinner();

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncGetCurrencyConvert(fromCurr.getSelectedItem().toString().substring(0,3)
                        ,toCurrency.getSelectedItem().toString().substring(0,3)
                        ,result).execute();
            }
        });

        chuyen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

    private void addDataToSpinner() {
        List<String> list = new ArrayList<>();
        list.add("JPY - Đồng Yên Nhật");
        list.add("CAD - Đồng Canada");
        list.add("AUD - Đô La Úc");
        list.add("USD - Đô La Mỹ");
        list.add("EUR - Đồng Euro");
        list.add("GBP - Bảng Anh");
        list.add("CNY - Đồng Nhân Dân Tệ");
        list.add("SGD - Đô La Singapore");
        list.add("HKD - Đô La Hồng Kông");
        list.add("VND - Việt Nam Đồng");
        list.add("CHF - Đồng Franc Thụy Sĩ");


        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        fromCurr.setAdapter(adapter);
        toCurrency.setAdapter(adapter);
    }

}
