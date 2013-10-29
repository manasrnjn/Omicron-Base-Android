/**********************************************************\
| Manages the creation, loading, and freeing of resources. |
|														   |
| @author David Saxon									   |
\**********************************************************/

package nz.co.withfire.omicronengine.omicron.resources.manager;

import java.util.HashMap;
import java.util.Map;

import nz.co.withfire.omicronengine.omicron.graphics.material.Material;
import nz.co.withfire.omicronengine.omicron.graphics.material.shader.Shader;
import nz.co.withfire.omicronengine.omicron.graphics.material.texture.Texture;
import nz.co.withfire.omicronengine.omicron.graphics.renderable.Renderable;
import nz.co.withfire.omicronengine.omicron.resources.types.MaterialResource;
import nz.co.withfire.omicronengine.omicron.resources.types.RenderableResource;
import nz.co.withfire.omicronengine.omicron.resources.types.ShaderResource;
import nz.co.withfire.omicronengine.omicron.resources.types.TextureResource;
import nz.co.withfire.omicronengine.override.ResourceGroups.ResourceGroup;
import nz.co.withfire.omicronengine.override.Values;
import nz.co.withfire.omicronengine.resource_packs.MaterialDemoPack;

import android.content.Context;
import android.util.Log;

public class ResourceManager {

	//VARIABLES
	//the android context
	static Context context;
	
	//shader resource map
	private static Map<String, ShaderResource> shaders = null;
	//texture resource map
	private static Map<String, TextureResource> textures = null;
	//material resource map
	private static Map<String, MaterialResource> materials = null;
	//renderable resource map
	private static Map<String, RenderableResource> renderables = null;
	
	//PUBLIC METHODS
	/**Initialises the resource manager
	@param context the android context*/
	public static void init(final Context context) {
		
		//initialise variables
		ResourceManager.context = context;
		shaders =     new HashMap<String, ShaderResource>();
		textures =    new HashMap<String, TextureResource>();
		materials =   new HashMap<String, MaterialResource>();
		renderables = new HashMap<String, RenderableResource>();
		
		//build the resource packs
		MaterialDemoPack.build();
	}
	
	//LOAD
	/**Loads all shaders into memory*/
	public static void loadShaders() {
		
		for (ShaderResource s : shaders.values()) {
			
			s.load(context);
		}
	}
	
	/**Loads all shaders within the resource group into memory
	@param group the group to load*/
	public static void loadShaders(ResourceGroup group) {
		
		for (ShaderResource s : shaders.values()) {
			
			if (s.getGroup() == group) {
			
				s.load(context);
			}
		}
	}
	
	/**Loads all textures into memory*/
	public static void loadTextures() {
		
		for (TextureResource t : textures.values()) {
			
			t.load(context);
		}
	}
	
	/**Loads all textures within the resource group into memory
	@param group the group to load*/
	public static void loadTextures(ResourceGroup group) {
		
		for (TextureResource t : textures.values()) {
			
			if (t.getGroup() == group) {
			
				t.load(context);
			}
		}
	}
	
	/**Loads all materials into memory*/
	public static void loadMaterials() {
		
		for (MaterialResource m : materials.values()) {
			
			m.load(context);
		}
	}
	
	/**Loads all materials within the resource group into memory
	@param group the group to load*/
	public static void loadMaterials(ResourceGroup group) {
		
		for (MaterialResource m : materials.values()) {
			
			if (m.getGroup() == group) {
			
				m.load(context);
			}
		}
	}
	
	/**Loads all renderables into memory*/
	public static void loadRenderables() {
		
		for (RenderableResource r : renderables.values()) {
			
			r.load(context);
		}
	}
	
	/**Loads all renderables within the resource group into memory
	@param group the group to load*/
	public static void loadRenderables(ResourceGroup group) {
		
		for (RenderableResource r : renderables.values()) {
			
			if (r.getGroup() == group) {

				r.load(context);
			}
		}
	}
	
	/**Loads all resources into memory
	#WARNING: you prolly shouldn't do this*/
	public static void load() {
		
		loadShaders();
		loadTextures();
		loadMaterials();
		loadRenderables();
	}
	
	/**Loads all the resource in the group into memory
	@param group the group to load*/
	public static void load(ResourceGroup group) {
		
		loadShaders(group);
		loadTextures(group);
		loadMaterials(group);
		loadRenderables(group);
	}
	
	//FREE
	/**Frees all shaders from memory*/
	public static void destroyShaders() {
		
		for (ShaderResource s : shaders.values()) {
			
			if (s.isLoaded()) {
				
				s.destroy();
			}
		}
	}
	
	/**Frees the shaders within the group from memory
	@param group the group to free*/
	public static void destroyShaders(ResourceGroup group) {
		
		for (ShaderResource s : shaders.values()) {
			
			if (s.isLoaded() && s.getGroup() == group) {
				
				s.destroy();
			}
		}
	}
	
	/**Frees all textures from memory*/
	public static void destroyTextures() {
		
		for (TextureResource t : textures.values()) {
			
			if (t.isLoaded()) {
				
				t.destroy();
			}
		}
	}
	
	/**Frees the textures within the group from memory
	@param group the group to free*/
	public static void destroyTextures(ResourceGroup group) {
		
		for (TextureResource t : textures.values()) {
			
			if (t.isLoaded() && t.getGroup() == group) {
				
				t.destroy();
			}
		}
	}
	
	/**Frees all materials from memory*/
	public static void destroyMaterials() {
		
		for (MaterialResource m : materials.values()) {
			
			if (m.isLoaded()) {
				
				m.destroy();
			}
		}
	}
	
	/**Frees the materials within the group from memory
	@param group the group to free*/
	public static void destroyMaterials(ResourceGroup group) {
		
		for (MaterialResource m : materials.values()) {
			
			if (m.isLoaded() && m.getGroup() == group) {
				
				m.destroy();
			}
		}
	}
	
	/**Frees all renderables from memory*/
	public static void destroyRenderables() {
		
		for (RenderableResource r : renderables.values()) {
			
			if (r.isLoaded()) {
				
				r.destroy();
			}
		}
	}
	
	/**Frees the renderables within the group from memory
	@param group the group to free*/
	public static void destroyRenderables(ResourceGroup group) {
		
		for (RenderableResource r : renderables.values()) {
			
			if (r.isLoaded() && r.getGroup() == group) {
				
				r.destroy();
			}
		}
	}
	
	/**Frees all loaded resources from memory*/
	public static void destroy() {
		
		destroyShaders();
		destroyTextures();
		destroyMaterials();
		destroyRenderables();
	}
	
	/**Frees all loaded resources within the group from memory
	@param group the group to free*/
	public static void destroy(ResourceGroup group) {
		
		destroyShaders(group);
		destroyTextures(group);
		destroyMaterials(group);
		destroyRenderables(group);
	}
	
	//GET
	/**Gets the shader from the resource map
	@param label the label of the shader
	@return the shader*/
	public static Shader getShader(String label) {
		
		return shaders.get(label).getShader();
	}
	
	/**Gets the texture from the resource map
	@param label the label of texture
	@return the texture*/
	public static Texture getTexture(String label) {
		
		return textures.get(label).getTexture();
	}
	
	/**Gets the material from the resource map
	@param label the label of the material
	@return the material*/
	public static Material getMaterial(String label) {
		
		return materials.get(label).getMaterial();
	}
	
	/**Gets the renderable from the resource map
	@param label the label of the renderable
	@return the renderable*/
	public static Renderable getRenderable(String label) {
		
		return renderables.get(label).getRenderable();
	}
	
	//ADD
	/**Adds a new shader resource to the resource map
	@param label the label of the shader
	@param shader the shader resource to add*/
	public static void add(String label, ShaderResource shader) {
		
        //check to make sure the map doesn't contain the key
        if (shaders.containsKey(label)) {
            
            Log.v(Values.TAG, "Invalid shader key");
            throw new RuntimeException("Invalid shader key");
        }
        
        shaders.put(label,  shader);
	}
	
	/**Adds a new texture resource to the resource map
	@param label the label of the texture
	@param texture the texture resource to add*/
	public static void add(String label, TextureResource texture) {
		
        //check to make sure the map doesn't contain the key
        if (textures.containsKey(label)) {
            
            Log.v(Values.TAG, "Invalid texture key");
            throw new RuntimeException("Invalid texture key");
        }
        
        textures.put(label, texture);
	}
	
	/**Adds a new material resource to the resource map
	@param label the label of the material
	@param material the material resource to add*/
	public static void add(String label, MaterialResource material) {
		
        //check to make sure the map doesn't contain the key
        if (materials.containsKey(label)) {
            
            Log.v(Values.TAG, "Invalid material key");
            throw new RuntimeException("Invalid material key");
        }
        
        materials.put(label, material);
	}
	
	/**Adds a new renderable resource to the resource map
	@param label the label of the renderable
	@param renderable the renderable resource to add*/
	public static void add(String label, RenderableResource renderable) {
		
        //check to make sure the map doesn't contain the key
        if (renderables.containsKey(label)) {
            
            Log.v(Values.TAG, "Invalid renderable key");
            throw new RuntimeException("Invalid renderable key");
        }
        
        renderables.put(label, renderable);
	}
	
	/**Cleans up the resource manager*/
	public static void cleanUp() {
		
		context = null;
		if (shaders != null) {
			
			shaders.clear();
			shaders = null;
		}
		if (textures != null) {
			
			textures.clear();
			textures = null;
		}
		if (materials != null) {
			
			materials.clear();
			materials = null;
		}
		if (renderables != null) {
			
			renderables.clear();
			renderables = null;
		}
	}
}