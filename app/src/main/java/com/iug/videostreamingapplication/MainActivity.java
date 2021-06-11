package com.iug.videostreamingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class MainActivity extends AppCompatActivity {
    PlayerView playerView;
    PlayerView playerViewTwo;
    PlayerView playerViewThree;
    PlayerView playerViewFour;


    SimpleExoPlayer player;
    SimpleExoPlayer playertwo;
    SimpleExoPlayer playerthree;
    SimpleExoPlayer playerFour;


    String url = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";
    String url2 = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";
    String url3 = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";
    String url4 = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";

    private  boolean playWhenReady = true;
    private  boolean playWhenReady_2 = true;
    private  boolean playWhenReady_3 = true;
    private  boolean playWhenReady_4 = true;


    private int currentWindow = 0;
    private int currentWindow_2 = 0;
    private int currentWindow_3 = 0;
    private int currentWindow_4 = 0;

    private  long playPackPosition =  0;
    private  long playPackPosition_2 =  0;
    private  long playPackPosition_3=  0;
    private  long playPackPosition_4=  0;


    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;


    private boolean isClikable_1 = false;
    private boolean isClikable_2 = false;
    private boolean isClikable_3 = false;
    private boolean isClikable_4 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerView = findViewById(R.id.video_viewOne);
        playerViewTwo = findViewById(R.id.video_viewTwo);
        playerViewThree = findViewById(R.id.video_viewThree);
        playerViewFour = findViewById(R.id.video_viewFour);

        btnOne = findViewById(R.id.btn_click);
        btnTwo = findViewById(R.id.btn_click_two);
        btnThree = findViewById(R.id.btn_click_three);
        btnFour = findViewById(R.id.btn_click_four);
    }

    public  void initVideo () {

        if (isClikable_1) {
            System.out.println("clickable one");
            player = ExoPlayerFactory.newSimpleInstance(this);

            playerView.setPlayer(player);

            Uri uri = Uri.parse(url);
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, "exoplayer-codelab");
            MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);

            player.setPlayWhenReady(playWhenReady);
            player.seekTo(currentWindow, playPackPosition);
            player.prepare(mediaSource, false, false);
            isClikable_1 = false;
        }else if (isClikable_2) {
            System.out.println("clickable two");
            playertwo = ExoPlayerFactory.newSimpleInstance(this);
            playerViewTwo.setPlayer(playertwo);
            Uri uri2 = Uri.parse(url2);
            DataSource.Factory dataSourceFactory2 = new DefaultDataSourceFactory(this, "exoplayer-codelab");
            MediaSource mediaSource2 = new ProgressiveMediaSource.Factory(dataSourceFactory2).createMediaSource(uri2);
            playertwo.setPlayWhenReady(playWhenReady_2);
            playertwo.seekTo(currentWindow_2, playPackPosition_2);
            playertwo.prepare(mediaSource2, false, false);
            isClikable_2 = false;


        }else if (isClikable_3) {
            System.out.println("clickable three");
            playerthree = ExoPlayerFactory.newSimpleInstance(this);
            playerViewThree.setPlayer(playerthree);
            Uri uri3 = Uri.parse(url3);
            DataSource.Factory dataSourceFactory3 = new DefaultDataSourceFactory(this, "exoplayer-codelab");
            MediaSource mediaSource3 = new ProgressiveMediaSource.Factory(dataSourceFactory3).createMediaSource(uri3);
            playerthree.setPlayWhenReady(playWhenReady_3);
            playerthree.seekTo(currentWindow_3, playPackPosition_3);
            playerthree.prepare(mediaSource3, false, false);
            isClikable_3 = false;

        }else if (isClikable_4){
            System.out.println("clickable Four");
            playerFour = ExoPlayerFactory.newSimpleInstance(this);
            playerViewFour.setPlayer(playerFour);
            Uri uri4 = Uri.parse(url4);
            DataSource.Factory dataSourceFactory4 = new DefaultDataSourceFactory(this, "exoplayer-codelab");
            MediaSource mediaSource4 = new ProgressiveMediaSource.Factory(dataSourceFactory4).createMediaSource(uri4);
            playerFour.setPlayWhenReady(playWhenReady_4);
            playerFour.seekTo(currentWindow_4, playPackPosition_4);
            playerFour.prepare(mediaSource4, false, false);
            isClikable_3 = false;
        }
    }
    public  void releaseVideo () {
        if (player != null){
            playWhenReady = player.getPlayWhenReady();
            playPackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClikable_1 = true;
                initVideo();
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClikable_2 = true;
                initVideo();
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClikable_3 = true;
                initVideo();
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClikable_4 = true;
                initVideo();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
      if (player != null){
          initVideo();
      }
    }

    @Override
    protected void onPause() {
        super.onPause();
      releaseVideo();
    }


    @Override
    protected void onStop() {
        super.onStop();
          releaseVideo();

    }

}