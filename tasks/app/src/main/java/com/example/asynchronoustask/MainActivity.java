package com.example.asynchronoustask;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView txtmarq;
    Button btnstart, btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtmarq = findViewById(R.id.txtmarquee);
        btnstart = findViewById(R.id.buttonstart);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleAsyncTask task = new ExampleAsyncTask();
                task.execute();
            }
        });
        btnstop = findViewById(R.id.buttonstop);
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtmarq.setSelected(false);
                txtmarq.setVisibility(View.INVISIBLE);
            }
        });
    }
    private class ExampleAsyncTask extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getBaseContext(),"Asynchronous Task Started!!!!!!!!",Toast.LENGTH_SHORT).show();
        }
        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtmarq.setVisibility(View.VISIBLE);
            txtmarq.setSelected(true);
        }
    }
}