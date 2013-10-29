/*****************************\
| Methods for loading meshes. |
|		 					  |
| @author David Saxon         |
\*****************************/

package nz.co.withfire.omicronengine.omicron.resources.loaders;

import java.util.ArrayList;
import java.util.Scanner;

import nz.co.withfire.omicronengine.omicron.graphics.renderable.Mesh;
import nz.co.withfire.omicronengine.omicron.graphics.renderable.Renderable;
import nz.co.withfire.omicronengine.omicron.utilities.vector.Vector2;
import nz.co.withfire.omicronengine.omicron.utilities.vector.Vector3;
import android.content.Context;

public class MeshLoader {

	//PUBLIC METHODS
	/**Loads an OBJ file file as a mesh
	NOTE: the OBJ file must consist of triangles
	@param context the android context
	@param resourceId the id of the resource to load
	@param type the type of renderable this is to be
	@param the layer of the mesh
	@return the loaded mesh*/
	public static Mesh loadOBJ(final Context context, int resourceId,
		Renderable.Group type, int layer) {
		
		  //open the file as a string
        String file = StringLoader.loadString(context, resourceId);
        
        //load the file into a scanner
        Scanner scanner = new Scanner(file);
        
        //a array list that contains the vertex coords
        ArrayList<Vector3> vertices = new ArrayList<Vector3>();
        //a list that contains the uv coords
        ArrayList<Vector2> uvCoords = new ArrayList<Vector2>();
        //a list that contains the vertex normals
        ArrayList<Vector3> normals = new ArrayList<Vector3>();
        //the array of the vertexs in order that make up the model
        ArrayList<Vector3> faceVertices = new ArrayList<Vector3>();
        //the array of texture coords in the model
        ArrayList<Vector2> faceUV = new ArrayList<Vector2>();
        //the array of normals in order
        ArrayList<Vector3> normalsFinal = new ArrayList<Vector3>();
        
        //read through the entire file
        while(scanner.hasNext()) {
        
            //get the next value
            String next  = scanner.next();
            
            //read the vertex coords
            if (next.equals("v")) {
                
                //add the vertex
                vertices.add(new Vector3(Float.parseFloat(scanner.next()),
                    Float.parseFloat(scanner.next()),
                    Float.parseFloat(scanner.next())));
            }
            //read the texture coords
            else if (next.equals("vt")) {
                
                //add the coord
            	uvCoords.add(new Vector2(Float.parseFloat(scanner.next()),
                    -Float.parseFloat(scanner.next())));
            }
            //read the vertex normals
            else if (next.equals("vn")) {
            	
            	//add the normal
                normals.add(new Vector3(Float.parseFloat(scanner.next()),
                        Float.parseFloat(scanner.next()),
                        Float.parseFloat(scanner.next())));
            }
            //read face vertices
            else if (next.equals("f")) {
                
                for (int i = 0; i < 3; ++i) {
                    
                    //get the index from the file and split
                    String indices[] = scanner.next().split("/");
                    
                    //parse as ints
                    int vertexIndex = Integer.parseInt(indices[0]) - 1;
                    int textureIndex = Integer.parseInt(indices[1]) - 1;
                    int normalIndex = -1;
                    if (indices.length > 2) {
                    	
                    	normalIndex = Integer.parseInt(indices[2]) - 1;
                    }
                    
                    faceVertices.add(vertices.get(vertexIndex));
                    faceUV.add(uvCoords.get(textureIndex));
                    if (normalIndex > -1) {
                    	
                    	normalsFinal.add(normals.get(normalIndex));
                    }
                }
            }
            else {
                
                //throw away the line
                scanner.nextLine();
            }
        }
        
        //get the triangle coords
        float coords[] = new float[faceVertices.size() * 3];
        float uv[] = new float[faceUV.size() * 2];
        float nrm[] = new float[normalsFinal.size() * 3];
        for (int i = 0; i < faceVertices.size(); ++i) {
            
            //get vertex coords
            coords[(i * 3)]     = faceVertices.get(i).getX();
            coords[(i * 3) + 1] = faceVertices.get(i).getY();
            coords[(i * 3) + 2] = faceVertices.get(i).getZ();
            
            //get texture coords
            uv[(i * 2)]     = faceUV.get(i).getX();
            uv[(i * 2) + 1] = faceUV.get(i).getY();
            
            //get normal coords
            if (normalsFinal.size() > i) {
            	
                nrm[(i * 3)]     = normalsFinal.get(i).getX();
                nrm[(i * 3) + 1] = normalsFinal.get(i).getY();
                nrm[(i * 3) + 2] = normalsFinal.get(i).getZ();
            }
        }
        
        return new Mesh(type, layer, coords, uv, nrm);
	}
}
