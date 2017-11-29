package datos1.tec.org.packettec.multimedia;

public class CameraCheck{
	//VERRIFICA LA EXISTENCIA DE UNA CAMARA
	private boolean checkCameraHardware(Context context) {
	    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
	        return true;
	    } else {
	        return false;
	    }
	}
	public static Camera getCameraInstance(){
	    Camera c = null;
	    try {
	        c = Camera.open(); 
	    }
	    catch (Exception e){
	        
	    }
	    return c;
	}
}
