/****************************\
| A progressing loading bar. |
|                            |
| @author David Saxon        |
\****************************/

package nz.co.withfire.omicronengine.entities.loading;

import nz.co.withfire.omicronengine.omicron.graphics.renderable.Mesh;
import nz.co.withfire.omicronengine.omicron.graphics.renderer.OmicronRenderer;
import nz.co.withfire.omicronengine.omicron.logic.entity.Entity;
import nz.co.withfire.omicronengine.omicron.resources.manager.ResourceManager;
import nz.co.withfire.omicronengine.omicron.utilities.TransformationsUtil;
import nz.co.withfire.omicronengine.omicron.utilities.vector.Vector3;

public class LoadingBar extends Entity {

    //VARIABLES
    //the mesh
    private final Mesh barMesh;
    
    //the scale
    private Vector3 scale = new Vector3(0.0f, 0.03f, 1.0f);
    
    //the max scale amount
    private final float MAX_SCALE =
        TransformationsUtil.getOpenGLDim().x * 0.9f;
    
    //CONSTRUCTOR
    /**Creates a new loading bar*/
    public LoadingBar() {
        
        //get the mesh
        barMesh = (Mesh) ResourceManager.getRenderable("loading_bar");
        //set position
        barMesh.setTranslation(new Vector3(0.0f, -0.7f, 0.0f));
        //set scale
        barMesh.setScale(scale);
        //add to the renderer
        OmicronRenderer.add(barMesh);
    }
    
    @Override
    public void cleanUp() {
        
        OmicronRenderer.remove(barMesh);
    }
    
    /**Updates the percent complete of the bar
    @param precent the new percent complete*/
    public void setPercent(float percent) {
        
        scale.x = MAX_SCALE * percent;
        barMesh.setScale(scale);
    }
}
