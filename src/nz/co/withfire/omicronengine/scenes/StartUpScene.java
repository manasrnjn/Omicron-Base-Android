/***********************************************************\
| The start up scene which is default to all Omicron games. |
|                                                            |
| @author David Saxon                                        |
\***********************************************************/

package nz.co.withfire.omicronengine.scenes;

import java.util.List;
import java.util.ArrayList;

import nz.co.withfire.omicronengine.entities.start_up.Splash;
import nz.co.withfire.omicronengine.omicron.graphics.camera.Camera;
import nz.co.withfire.omicronengine.omicron.graphics.camera.PerspectiveCamera;
import nz.co.withfire.omicronengine.omicron.graphics.renderable.Sprite;
import nz.co.withfire.omicronengine.omicron.graphics.renderer.OmicronRenderer;
import nz.co.withfire.omicronengine.omicron.logic.scene.Scene;
import nz.co.withfire.omicronengine.omicron.resources.manager.ResourceManager;
import nz.co.withfire.omicronengine.omicron.utilities.vector.Vector3;
import nz.co.withfire.omicronengine.override.DebugValues;
import nz.co.withfire.omicronengine.override.ResourceGroups.ResourceGroup;

public class StartUpScene extends Scene {

    //VARIABLES
    //the camera
    private Camera camera = new PerspectiveCamera(60.0f, 0.01f, 100.0f);

    //true once loading has been completed
    private boolean loaded = false;

    //the splash entity
    private Splash splash;

    //PUBLIC METHODS
    @Override
    public void init() {

        //set the camera
        camera.setPos(new Vector3(0.0f, 0.0f, 1.7f));
        OmicronRenderer.setCamera(camera);

        //load the start up resources
        ResourceManager.load(ResourceGroup.ALL);
        ResourceManager.load(ResourceGroup.GUI);
        ResourceManager.load(ResourceGroup.START_UP);

        //load in debug resources if we need to
        if (DebugValues.inDebugMode()) {

            ResourceManager.load(ResourceGroup.DEBUG);
        }

        //create and add the splash
        splash = new Splash(
            (Sprite) ResourceManager.getRenderable("omicron_splash"));
        entities.add(splash);
    }

    @Override
    public boolean execute() {

        //super call
        super.execute();

        //once the splash has faded in load the next scene resources
        if (!loaded && splash.fadedIn()) {

            ResourceManager.load(ResourceGroup.MAIN_MENU);
            loaded = true;
        }

        //complete once the splash has faded out
        return splash.fadedOut();
    }

    /**@return the next scene*/
    public Scene nextScene() {

        //super call
        super.nextScene();

        //release start up resources
        ResourceManager.destroy(ResourceGroup.START_UP);

        //return new MainMenuScene();

        List<ResourceGroup> loadList = new ArrayList<ResourceGroup>();
        loadList.add(ResourceGroup.PHYSICS_DEMO);
        LoadingScene.setLoadGroups(loadList);
        LoadingScene.setNextScene(new PhysicsDemoScene());

        return new LoadingScene();
    }

    @Override
    public boolean backPressed() {

        return true;
    }
}
