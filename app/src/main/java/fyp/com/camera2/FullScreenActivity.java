package fyp.com.camera2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
}
