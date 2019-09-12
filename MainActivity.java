package com.knowledgesuttra.resourcefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText getURL;
    Button btn_go;
    WebView loadData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getURL = findViewById(R.id.edt_getURL);
        btn_go = findViewById(R.id.btn_finddata);
        loadData = findViewById(R.id.loadData);
        loadData.setVisibility(View.GONE);
        final String empty = "";
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = getURL.getText().toString();
                if (URL!=empty){
                    loadData.setVisibility(View.VISIBLE);
                    String finalURL = "view-source:"+ URL;
                    loadData.getSettings().setJavaScriptEnabled(true);
                    loadData.getSettings().setLoadWithOverviewMode(true);
                    loadData.getSettings().setUseWideViewPort(true);
                    loadData.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
                    loadData.setScrollbarFadingEnabled(false);
                    loadData.getSettings().setBuiltInZoomControls(true);
                    loadData.loadUrl(finalURL);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please Enter URL followed by HTTPS", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
