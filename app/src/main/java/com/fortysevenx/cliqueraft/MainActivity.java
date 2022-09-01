package com.fortysevenx.cliqueraft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button toast,notf,dialogb,com;
    TextView t,d,t3;
    Dialog dial;
    NotificationCompat.Builder builder;

    String CHANNEL_ID = "channel_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.inputf);
        toast = (Button) findViewById(R.id.toast);
        notf = (Button)findViewById(R.id.notf);
        t = (TextView) findViewById(R.id.textView);
        com = (Button) findViewById(R.id.complete);
        dialogb = (Button) findViewById(R.id.dialog);
        t3 = (TextView) findViewById(R.id.textView3);


        dial = new Dialog(this);



        dial.setContentView(R.layout.dialog);
        d=(TextView) dial.findViewById(R.id.textView2) ;
        dial.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dilogbc));
        dial.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dial.setCancelable(true);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("NOTIFICATION","NEW NOTIFICATION",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals(""))
                    t.setText("Input Field is Required");
                else
                Toast.makeText(MainActivity.this, input.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        notf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals(""))
                    t.setText("Input Field is Required");
                else {
                    builder = new NotificationCompat.Builder(MainActivity.this, "NOTIFICATION");
                    builder.setContentTitle(input.getText());
                    builder.setContentText("Above is the text in inputfield");
                    builder.setSmallIcon(R.drawable.ic_baseline_bolt_24);
                    builder.setAutoCancel(false);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                    managerCompat.notify(1, builder.build());
                }
            }
        });

        dialogb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals(""))
                    t.setText("Input Field is Required");
                else {
                d.setText(input.getText());
                dial.show();
            }}
        });

        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals(""))
                    t.setText("Input Field is Required");
                else {

                    t3.setText("C O M P L E T E D");
                }
            }
        });

    }


}