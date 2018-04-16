package com.example.lenovo.la3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_exit,btn_submit,btn_reset,btn_hapus,btn_about;
    EditText edit_input;
    TextView layar;
    String info;
    ImageButton imgbtn_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = getApplicationContext().getResources().getString(R.string.info);
        btn_exit = findViewById(R.id.exit);
        btn_submit = findViewById(R.id.submit);
        btn_reset = findViewById(R.id.reset);
        btn_hapus = findViewById(R.id.hapus);
        btn_about = findViewById(R.id.about);
        imgbtn_web = findViewById(R.id.webview);
        edit_input = findViewById(R.id.edit);
        layar = findViewById(R.id.layar);

        btn_submit.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);
        btn_about.setOnClickListener(this);
        imgbtn_web.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.submit:
                String ref = layar.getText().toString();
                layar.setText(ref + edit_input.getText().toString());
                edit_input.setText("");
                break;
            case R.id.reset:
                layar.setText("");
                edit_input.setText("");
                break;
            case R.id.hapus:
                layar.setText("");
                break;
            case R.id.webview:
                Intent i = new Intent( MainActivity.this, webview.class);
                startActivity(i);
                break;
            case R.id.about:
                AlertDialog.Builder about = new AlertDialog.Builder(MainActivity.this);
                about.setMessage(info).setCancelable(false).setPositiveButton("Lanjut", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = about.create();
                dialog.setTitle("Tentang Aplikasi");
                dialog.show();
                TextView textView = (TextView)dialog.findViewById(android.R.id.message);
                textView.setTextSize(15);
                break;
            case R.id.exit:
                AlertDialog.Builder exit = new AlertDialog.Builder(MainActivity.this);
                exit.setMessage(info).setCancelable(false).setPositiveButton("Lanjut", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        MainActivity.super.finish();

                    }
                })
                .setNegativeButton("tidak", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                }
            });
                AlertDialog Exit = exit.create();
                Exit.setTitle("keluar?");
                Exit.show();
                break;
        }
    }

}
