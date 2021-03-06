/*******************************************************************\
| The default Omicron vertex shader, does all the necessary things. |
|                                                                    |
| @author David Saxon                                                |
\*******************************************************************/

//VARIABLES
//the model matrix
uniform mat4 u_MMatrix;
//the model view projection matrix
uniform mat4 u_MVPMatrix;

//the vertex positions
attribute vec4 a_Position;
//uv co-ordinates
attribute vec2 a_UVCoord;
//the normals
attribute vec3 a_Normal;

//vertices data that will be passed to the fragment shader
varying vec3 v_Position;
//uv data that will be passed to the fragment shader
varying vec2 v_UVCoord;
//normal information that will be passed to the fragment shader
varying vec3 v_Normal;

//MAIN METHOD
void main() {

    //apply transformations to position
    v_Position = vec3(u_MMatrix * a_Position);

    //pass the uv co-ordinates through to the fragment shader
    v_UVCoord = a_UVCoord;

    //transform the normal into eye space
    v_Normal = vec3(u_MMatrix * vec4(a_Normal, 0.0));

    //set the position
    gl_Position = u_MVPMatrix * a_Position;
}