package fyp.com.camera2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AnalyseSelectionActivity extends AppCompatActivity {

    private String[] professionalPlayerSpinner;
    private String[] amateurPlayerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse_selection);

        this.professionalPlayerSpinner = new String[] {"Federer", "Murray", "Isner", "Djokovic"};
        Spinner s1 = (Spinner) findViewById(R.id.ProfessionalPlayerSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, professionalPlayerSpinner);
        s1.setAdapter(adapter);

        this.amateurPlayerSpinner = new String[] {"Video One", "Video Two", "Video Three", "VideoFour"};
        Spinner s2 = (Spinner) findViewById(R.id.AmateurPlayerSpinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, amateurPlayerSpinner);
        s2.setAdapter(adapter2);
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

    public void launchAnalysis (View view) {

        Toast.makeText(this, "Yep, it'll happen soon", Toast.LENGTH_SHORT).show();

        //To be implemented next
        //Intent AnalyseSelection = new Intent(this, AnalyseSelectionActivity.class);
        //startActivity(AnalyseSelection);
    }
}