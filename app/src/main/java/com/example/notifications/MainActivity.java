package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText text_title,text_message;
    Button bt1,bt2;

    public static final String MESSAGE_KEY = "MESSAGE_KEY";

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

    public void onb1(View v)
    {
        String title=text_title.getText().toString();
        String message=text_message.getText().toString();



        Intent contentIntent = new Intent(this, MainActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity(
                this, 0, contentIntent,PendingIntent.FLAG_MUTABLE);

        Intent actionIntent = new Intent(this, SecondActivity.class);
        actionIntent.putExtra(MESSAGE_KEY, message);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_MUTABLE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,App.Channel_One_Id);
        builder
                .setSmallIcon(R.drawable.ic_baseline_notification_important_24)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(contentPendingIntent)
                .addAction(R.mipmap.ic_launcher, "Show Toast", actionPendingIntent)
                .setColor(Color.BLUE)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        manager.notify(1, builder.build());
    }
}