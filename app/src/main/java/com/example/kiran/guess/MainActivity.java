package com.example.kiran.guess;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bYes, bNo;
    String res = "";
    int iter = 1;
    int a[][] = new int[][]{{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31},
            {2, 3, 6, 7, 10, 11, 14, 15, 18, 19, 22, 23, 26, 27, 30, 31},
    {4, 5, 6, 7, 12, 13, 14, 15, 20, 21, 22, 23, 28, 29, 30, 31},
    {8, 9, 10, 11, 12, 13, 14, 15, 24, 25, 26, 27, 28, 29, 30, 31},
    {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bYes = findViewById(R.id.bYes);
        bNo = findViewById(R.id.bNo);
        getAlertDialog();
        buttonFunc();
    }
    public void getAlertDialog(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Select a date from the calendar(1-31) and i will guess that date");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        })
                .show();
    }

    public void buttonFunc(){
        bYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res + 1;
                if(iter == 5){
                    getResult();
                    return;
                }
                for(int i = 0; i <= 15; i += 1){
                    int j = 2*i + 1;
                    String id = "tv" + j;
                    TextView tv = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
                    tv.setText(String.valueOf(a[iter][i]));
                }
                iter++;

            }
        });
        bNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = res + 0;
                if(iter == 5){
                    getResult();
                    return;
                }
                for(int i = 0; i <= 15; i += 1){
                    int j = 2*i + 1;
                    String id = "tv" + j;
                    TextView tv = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
                    tv.setText(String.valueOf(a[iter][i]));
                }
                iter++;
            }
        });
    }
    public void getResult(){
        int ans = 0;
        for(int i = 0; i < res.length(); i++){
            ans += (res.charAt(i)-'0') * Math.pow(2, i);
        }
        res = "";
        iter = 1;
        String msg;
        if(ans == 0)
            msg = "Invalid number selection select a number between (1-31)";
        else
            msg = "Your number is " + ans;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setCancelable(true);
        builder.show();
        for(int i = 0; i <= 15; i += 1){
            int j = 2*i + 1;
            String id = "tv" + j;
            TextView tv = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            tv.setText(String.valueOf(a[0][i]));
        }

    }


}
