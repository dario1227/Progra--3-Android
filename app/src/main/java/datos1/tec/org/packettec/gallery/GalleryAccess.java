package datos1.tec.org.packettec.gallery;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import datos1.tec.org.packettec.R;


public class GalleryAccess extends Activity{
	TextView textTargetUri;
    ImageView targetImage;

     @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Button buttonLoadImage = (Button)findViewById(R.id.center_horizontal);
         textTargetUri = (TextView)findViewById(R.id.textView);
         targetImage = (ImageView)findViewById(R.id.imageView);

         buttonLoadImage.setOnClickListener(new Button.OnClickListener(){

     @Override
     public void onClick(View arg0) {
      Intent intent = new Intent(Intent.ACTION_PICK,
        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
      startActivityForResult(intent, 0);
     }});
     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK){
     Uri targetUri = data.getData();
     textTargetUri.setText(targetUri.toString());
     Bitmap bitmap;
     try {
      bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
      targetImage.setImageBitmap(bitmap);
     } catch (FileNotFoundException e) {
      e.printStackTrace();
     }
    }
    }

}
