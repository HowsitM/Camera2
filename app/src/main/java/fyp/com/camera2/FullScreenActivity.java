package fyp.com.camera2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.io.File;

public class FullScreenActivity extends AppCompatActivity {

    private int videoPosition = 0;
    private ProgressDialog progressDialog;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        if(mediaController == null){
            mediaController = new MediaController(FullScreenActivity.this);
        }
        VideoView fullScreenVideoView = (VideoView) findViewById(R.id.fullScreenVideoView);

        Intent callingActivityIntent = getIntent();
        if(callingActivityIntent != null){
            Uri videoUri = callingActivityIntent.getData();
            if(videoUri != null && fullScreenVideoView != null){

                try{
                    fullScreenVideoView.setMediaController(mediaController);
                    fullScreenVideoView.setVideoURI(videoUri);

                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocas){
        super.onWindowFocusChanged(hasFocas);
        View decorView = getWindow().getDecorView();
        if(hasFocas){
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }
}