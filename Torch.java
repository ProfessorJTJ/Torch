package anywheresoftware.b4a.torch;

import anywheresoftware.b4a.BA;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.AbsObjectWrapper;

@BA.Version(1f)
@BA.ShortName("Torch")
public class Torch extends AbsObjectWrapper<CameraManager> {
	public void Initialize(final BA ba) {
		CameraManager cameraManager = (CameraManager) BA.applicationContext.getSystemService(Context.CAMERA_SERVICE);
        this.setObject(cameraManager);
    }
	public List getCameraIDList()
	{
		List cameras = new List();
		cameras.Initialize();
		
		try
		{
			String[] cameriasList = ((CameraManager)this.getObject()).getCameraIdList();
			for(String cameraID : cameriasList)
	    	{
				cameras.Add(cameraID);
	    	}
		}
		catch(Exception e)
		{
			
		}
		return cameras;
	}
	public boolean setTorchMode(final String cameraId, final boolean enabled)
	{
		CameraManager cameraManager = (CameraManager) BA.applicationContext.getSystemService(Context.CAMERA_SERVICE);
		try
		{
			cameraManager.setTorchMode(cameraId, enabled);
			return true;
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
}
