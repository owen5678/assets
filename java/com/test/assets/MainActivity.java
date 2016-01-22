package com.test.assets;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
private String TAG ="Assets Testing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                Log.i(TAG,"Start app");
        Button a= (Button) findViewById(R.id.button1);
        a.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
                Log.i(TAG,"Start click");
                AssetManager am = null;
                InputStream inputStream =null;
                try {
                    String[] files = getAssets().list("second");
                    for (int i=0;i<files.length;i++){
                        Log.i(TAG, "file :" + files[i]);
                    }
                }catch (Exception e){
                }

                am = getAssets();
                Log.i(TAG,"open File");
                try {
                    //inputStream = am.open("1");
                    //inputStream = am.open("first/first_1");
                    inputStream =am.open("second/second_first/second_first_1");
                }catch (Exception e){
                    e.getStackTrace();
                    Log.i(TAG,"Fail to open");
                }
                String len;
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    Log.i(TAG, "Start reading");
                    while ((len = br.readLine()) != null) {
                        Log.i(TAG,"File :" +len);
                    }
                    inputStream.close();
                }catch ( Exception e){
                    e.getStackTrace();
                    Log.i(TAG, "Fail to read");
                }
            }
        });

    }
}
