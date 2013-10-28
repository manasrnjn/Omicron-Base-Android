/************************\
| Represent a 3d vector. |
|                        |
| @author David Saxon    |
\************************/

package nz.co.withfire.omicronengine.omicron.utilities.vector;

public class Vector3 {
   
    //VARIABLES
    //static zero vector
    static public final Vector3 zero3d = new Vector3();
    
    //the values of the variables
    private float x;
    private float y;
    private float z;
    
    //CONSTRUCTORS
    /**Creates a new zero 3d vector*/
    public Vector3() {
        
        x = 0.0f;
        y = 0.0f;
        z = 0.0f;
    }
    
    /**Creates a new vector from the given values
    @param x the x value of the vector
    @param y the y value of the vector
    @param z the z value of the vector*/
    public Vector3(float x, float y, float z) {
        
        this.x  = x;
        this.y = y;
        this.z = z;
    }
    
    /**Creates a new vector by copying the values from the other vector
    @param other the other vector to copy from*/
    public Vector3(final Vector3 other) {
        
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }
    
    /**Create a new 3d vector by copying the x and y values from
    the 2d vector and sets the z value to 0
    @param other the 2d vector to copy from*/
    public Vector3(final Vector2 other) {
    	
    	this.x = other.getX();
    	this.y = other.getY();
    	this.z = 0;
    }
    
    /**Create a new 3d vector by copying the x, y, and z values from
    the 4d vector and truncates the w value
    @param other the 4d vector to copy from*/
    public Vector3(final Vector4 other) {
    	
    	this.x = other.getX();
    	this.y = other.getY();
    	this.z = other.getZ();
    }
    
    //PUBLIC METHODS
    /**Set the values of the vector to be the new given values
    @param x the new x value
    @param y the new y value
    @param z the new z value*/
    public void set(float x, float y, float z) {
        
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**Copy the values from the other vector to this vector
    @param other the other vector to copy from*/
    public void copy(final Vector3 other) {
        
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }
    
    /**Adds the values of the other vector to this vector
    @param other the other vector to add to this vector*/
    public void add(final Vector3 other) {
        
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
    }
    
    /**Subtracts the values of the other vector from this vector
    @param other the other vector to subtract by*/
    public void sub(final Vector3 other) {
        
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
    }
    
    /**Multiplies the values of this vector by the values of the other vector
    @param other the other vector to multiply by*/
    public void mul(final Vector3 other) {
        
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
    }
    
    /**Divides the values of this vector by the values of the other vector
    @param other the other vector to divide by*/
    public void div(final Vector3 other) {
        
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
    }
    
    /**@param value the value to add to the x value of this vector*/
    public void addX(float value) {
    	
    	this.x += value;
    }
    
    /**@param value the value to add to the y value of this vector*/
    public void addY(float value) {
    	
    	this.y += value;
    }
    
    /**@param value the value to add to the z value of this vector*/
    public void addZ(float value) {
    	
    	this.z += value;
    }
    
    /**@param value the value to subtract from the x value of this vector*/
    public void subX(float value) {
    	
    	this.x -= value;
    }
    
    /**@param value the value to subtract from the y value of this vector*/
    public void subY(float value) {
    	
    	this.y -= value;
    }
    
    /**@param value the value to subtract from the z value of this vector*/
    public void subZ(float value) {
    	
    	this.z -= value;
    }
    
    /**@param value the value to multiply the x value of this vector by*/
    public void mulX(float value) {
    	
    	this.x *= value;
    }
    
    /**@param value the value to multiply the y value of this vector by*/
    public void mulY(float value) {
    	
    	this.y *= value;
    }
    
    /**@param value the value to multiply the z value of this vector by*/
    public void mulZ(float value) {
    	
    	this.z *= value;
    }

    /**@param value the value to divide the x value of this vector by*/
    public void divX(float value) {
    	
    	this.x *= value;
    }
    
    /**@param value the value to divide the y value of this vector by*/
    public void divY(float value) {
    	
    	this.y *= value;
    }
    
    /**@param value the value to divide the z value of this vector by*/
    public void divZ(float value) {
    	
    	this.z *= value;
    }
    
    /**@return the magnitude of this vector*/
    final public float magnitude() {
        
    	return (float) Math.sqrt(x * x + y * y + z * z);
    }
    
    /**@return the inverse of the vector*/
    public Vector3 inverse() {
    	
    	return new Vector3(-x, -y, -z);
    }
    
    /**Normalises this vector*/
    public void normalise() {
    	
    	//get the magnitude
    	float mag = magnitude();
    	
    	//normalise the components
    	x /= mag;
    	y /= mag;
    	z /= mag;
    }
    
    /**Calculates the dot product of this vector and the other vector
    @param other the other vector to calculate with
    @return the dot product*/
    final public float dot(final Vector3 other) {
        
        return (this.x * other.x) + (this.y * other.y) +
            (this.z * other.z);
    }
    
    /**Calculates this distance between this vector and the other vector
    @param other the other vector to find the distance between
    @return the distance between the two vectors*/
    final public float distance(final Vector3 other) {
        
        return (float) Math.sqrt(Math.pow(this.x - other.x,  2.0f) +
            Math.pow(this.y - other.y, 2.0f) +
            Math.pow(this.z - other.z, 2.0f));
    }
    
    /**@return the values of the vector as an array*/
    final public float[] toArray() {
        
        float array[] = {x, y, z};
        
        return array;
    }
    
    //GETTERS
    /**@return the x value of the vector*/
    final public float getX() {
        
        return x;
    }
    
    /**@return the y value of the vector*/
    final public float getY() {
        
        return y;
    }
    
    /**@return the z value of the vector*/
    final public float getZ() {
        
        return z;
    }
    
    //SETTERS
    /**Sets the new x value
    @param x the new x value*/
    public void setX(float x) {
        
        this.x = x;
    }
    
    /**Sets the new y value
    @param y the new y value*/
    public void setY(float y) {
        
        this.y = y;
    }
    
    /**Sets the new z value
    @param z the new z value*/
    public void setZ(float z) {
        
        this.z = z;
    }
    
    /**@return the vector as a string*/
    public String toString() {
        
        return "(" + x + ", " + y + ", " + z + ")";
    }
}