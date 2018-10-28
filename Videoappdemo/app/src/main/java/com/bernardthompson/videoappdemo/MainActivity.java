package com.bernardthompson.videoappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView testVideo = findViewById(R.id.videoView);

        MediaController videoTool = new MediaController(this);
        videoTool.setAnchorView(testVideo);

        testVideo.setMediaController(videoTool);
        testVideo.start();

        testVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.air_trek_nglish_dub_commercial_480x642);
    }
}
