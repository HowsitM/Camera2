package fyp.com.camera2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MediaViewerActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor>{

    private final static int READ_EXTERNAL_STORAGE_PERMISSION_RESULT = 0;
    private final static int MEDIASTORE_LOADER_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_viewer);

        checkReadExternalStoragePermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch(requestCode){
            case READ_EXTERNAL_STORAGE_PERMISSION_RESULT:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //call cursor loader
                    //Toast.makeText(this, "Now have access to view thumbnails", Toast.LENGTH_SHORT).show();
                    getSupportLoaderManager().initLoader(MEDIASTORE_LOADER_ID, null, this);
                }
                    break;
            default: super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void checkReadExternalStoragePermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            //start cursor loader
                getSupportLoaderManager().initLoader(MEDIASTORE_LOADER_ID, null, this);

            } else {
                if(shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE));
                Toast.makeText(this, "App needs to view thumbnails", Toast.LENGTH_SHORT).show();
            }
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE_PERMISSION_RESULT);
        }else {
            //Start cursor loader
            getSupportLoaderManager().initLoader(MEDIASTORE_LOADER_ID, null, this);
        }
    }

    //Gets initialised on a background thread so its faster
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = { MediaStore.Files.FileColumns._ID,
                                MediaStore.Files.FileColumns.DATE_ADDED,
                                MediaStore.Files.FileColumns.MEDIA_TYPE
        };
        String selection = MediaStore.Files.FileColumns.MEDIA_TYPE + "=" + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;

        return new CursorLoader(this, MediaStore.Files.getContentUri("external"), projection, selection, null, MediaStore.Files.FileColumns.DATE_ADDED + "DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
