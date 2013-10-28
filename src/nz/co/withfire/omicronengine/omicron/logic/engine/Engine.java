/******************************\
| The logic engine of Omicron. |
|							   |
| @author David Saxon		   |
\******************************/

package nz.co.withfire.omicronengine.omicron.logic.engine;

import android.view.MotionEvent;
import nz.co.withfire.omicronengine.omicron.logic.fps_manager.FPSManager;
import nz.co.withfire.omicronengine.omicron.logic.scene.Scene;
import nz.co.withfire.omicronengine.omicron.utilities.vector.Vector2;
import nz.co.withfire.omicronengine.scenes.StartUpScene;

public class Engine {
	
	//VARIABLES
	//the fps manager
	private FPSManager fps = new FPSManager();
	
	//the current scene
	private Scene scene;
	
	//PUBLIC METHODS
	/**Initialises the engine*/
	public void init() {
		
		//set the first scene to start up an init
		scene = new StartUpScene();
		scene.init();
		
		//zero the fps manager
		fps.zero();
	}
	
	/**Executes the engine*/
	public void execute() {
		
		//get the amount of times we need to update
		int updateAmount = fps.update();
		
		//perform updates
		for (int i = 0; i < updateAmount; ++i) {
			
			//execute the current scene
			if (scene.execute()) {
				
				//set the new scene
				scene = scene.nextScene();
				scene.init();
				fps.zero();
				
				break;
			}
		}
	}
	
	/**Inputs a touch event to the engine
	@param event the event type
	@param index the event index
	@touchPos the position of the touch event*/
	public void touchEvent(int event, int index, Vector2 touchPos) {
		
		//pass the motion event to the scene
		scene.touchEvent(event, index, touchPos);
	}
}