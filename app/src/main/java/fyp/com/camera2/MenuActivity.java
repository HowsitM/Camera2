
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

    public void launchMediaGallery(View view){
        Intent launchMediaGallery = new Intent(this, Camera2Activity.class);
        startActivity(launchMediaGallery);
    }

    public void launchCamera2Activity (View view){
        Intent launchMediaGallery = new Intent(this, Camera2Activity.class);
        startActivity(launchMediaGallery);
    }

    public void launchAnalysis (View view) {
        Intent launchAnalysis = new Intent(this, Camera2Activity.class);
        startActivity(launchAnalysis);
    }
}