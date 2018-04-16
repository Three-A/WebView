package com.example.lenovo.la3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class webview extends AppCompatActivity {
    Spinner spinner;
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        spinner = (Spinner) findViewById(R.id.spinner1);
        web = (WebView) findViewById(R.id.webview);

        web.loadUrl("file:///android_asset/html/webview2.html");
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String kata = String.valueOf(adapterView.getSelectedItem());
                        if (i != 0) {
                            Toast.makeText(getApplicationContext(),
                                    "Anda memilih website 1" +
                                            kata, Toast.LENGTH_SHORT).show();
                        }
                        if (i == 1) {
                            web.loadUrl("file:///android_asset/html/webview1.html");
                        } else if (i==2) {
                            web.loadUrl("file:///android_asset/html/webview3.html");
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
}}


