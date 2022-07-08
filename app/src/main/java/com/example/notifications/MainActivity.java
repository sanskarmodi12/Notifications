package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText text_title,text_message;
    Button bt1,bt2;

    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        bt1=(Button) findViewById(R.id.onebt);
        bt2=(Button) findViewById(R.id.twobt);

        text_message=(EditText)findViewById(R.id.text_message);
        text_title=(EditText)findViewById(R.id.text_title);

//        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,App.Channel_One_Id);
        bt1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String title=text_title.getText().toString();
                String message=text_message.getText().toString();
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,App.Channel_One_Id);
                builder
                        .setSmallIcon(R.drawable.ic_baseline_notification_important_24)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();
                manager.notify(1, builder.build());


            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=text_title.getText().toString();
                String message=text_message.getText().toString();

                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,App.Channel_Two_Id);
                builder
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .build();
                manager.notify(2, builder.build());

            }
        });

    }
}