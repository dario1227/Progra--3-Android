package datos1.tec.org.packettec.multimedia;

public class CameraTakePicture {
	private PictureCallback mPicture = new PictureCallback() {

	    @Override
	    public void onPictureTaken(byte[] data, Camera camera) {

	        File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
	        if (pictureFile == null){
	            Log.d(TAG, "Error creating media file, check storage permissions: " +
	                e.getMessage());
	            return;
	        }

	        try {
	            FileOutputStream fos = new FileOutputStream(pictureFile);
	            fos.write(data);
	            fos.close();
	        } catch (FileNotFoundException e) {
	            Log.d(TAG, "File not found: " + e.getMessage());
	        } catch (IOException e) {
	            Log.d(TAG, "Error accessing file: " + e.getMessage());
	        }
	    }
	};
	Button captureButton = (Button) findViewById(id.button_capture);
	captureButton.setOnClickListener(
	    new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            mCamera.takePicture(null, null, mPicture);
	        }
	    }
	);
}
