
package fyp.com.camera2;

import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    //Button galleryButton = (Button) findViewById(R.id.MediaGallery);
    //Button launchCameraButton = (Button) findViewById(R.id.LaunchVideo);
    //Button viewAnalysisButton = (Button) findViewById(R.id.VideoAnalysis);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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

    public void launchMediaGallery(View view){
        Intent launchMediaGallery = new Intent(this, MediaViewerActivity.class);
        startActivity(launchMediaGallery);
    }

    public void launchCamera2Activity (View view){
        Intent launchMediaGallery = new Intent(this, Camera2Activity.class);
        startActivity(launchMediaGallery);
    }

    public void launchAnalysisSelection (View view) {
        Intent AnalyseSelection = new Intent(this, AnalyseSelectionActivity.class);
        startActivity(AnalyseSelection);
    }
}