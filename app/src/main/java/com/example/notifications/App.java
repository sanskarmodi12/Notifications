package com.example.notifications;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
// runs before our mainactivity
//usful since we are c reating notification channel
public class App extends Application {

    public static final String Channel_One_Id="Channel_one_id";
    public static final String Channel_Two_Id="Channel_two_id";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();

        NotificationChannel channelOne=new NotificationChannel(Channel_One_Id,"Channel_one", NotificationManager.IMPORTANCE_HIGH);
        channelOne.setDescription("audio descrpition");
        NotificationChannel channelTwo=new NotificationChannel(Channel_Two_Id,"Channel_two", NotificationManager.IMPORTANCE_DEFAULT);
        channelTwo.setDescription("vedio descrpition");
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        List<NotificationChannel> channels=new ArrayList<>();
        channels.add(channelOne);
        channels.add(channelTwo);
        manager.createNotificationChannels(channels);


    }
}
