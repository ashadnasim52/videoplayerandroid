package com.example.ashad.videoplayer;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
        int Gallerycode=1000;
        Uri uri;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=(VideoView) findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

    }
    public void selectVideo(View v){
        Intent i=new Intent(Intent.ACTION_PICK);
        i.setType("video/*");
        startActivityForResult(i,Gallerycode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Gallerycode)
        {

            try {
                uri=data.getData();
                try {
                    if (!uri.equals(""))
                    {

                        Log.i("Tag", uri.toString());
                        videoView.setVideoURI(uri);
                        videoView.requestFocus();

                        videoView.start();
                    }
                    else
                    {
                        Toast.makeText(this, "No video selected", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "No video selected", Toast.LENGTH_SHORT).show();

                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "No video selected", Toast.LENGTH_SHORT).show();
            }


//            Log.i(TAG,"is "+createFolder());


        }
    }


    public void showVideo(){

    }
}
