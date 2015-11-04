package com.fearlesschen.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int NORMAL_ACTIVITY = 2015;
    private Button btnDialogActivity;
    private Button btnTransparentActivity;
    private Button btnNormalActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String userName = savedInstanceState.getString("userName");
            Log.i(TAG, userName);
        }
        Log.i(TAG, "onCreate");

        btnDialogActivity = (Button) findViewById(R.id.btnDialogActivity);
        btnDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
            }
        });

        btnTransparentActivity = (Button) findViewById(R.id.btnTransparentActivity);
        btnTransparentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TransparentActivity.class));
            }
        });

        btnNormalActivity = (Button) findViewById(R.id.btnNormalActivity);
        btnNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, NormalActivity.class), NORMAL_ACTIVITY);
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        String userName = "Michael Jordan";
        outState.putString("userName", userName);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NORMAL_ACTIVITY) {
            Log.i(TAG, "NormalActivity return result:" + resultCode);
            Log.i(TAG, "NormalActivity return userName:" + data.getStringExtra("userName"));
        }
    }
}

