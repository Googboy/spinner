package com.example.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private TextView textView;
    private String[] items = {"China","America","London","Franch","Asuia","England"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinnner);
        textView = (TextView) findViewById(R.id.spinner_label);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);//设置没有展开前的UI类型
        spinner.setAdapter(adapter);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//设置点击选择的方式

        spinner.setOnItemSelectedListener(this);//设置Spinner点击触发的callback函数
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textView.setText(items[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textView.setText("");
    }
}
