/***********************************************\
| The resource groups for organising resources. |
|                                                |
| @author David Saxon                            |
\***********************************************/

package nz.co.withfire.omicronengine.override;

public class ResourceGroups {

    //ENUMERATOR
    //the different groups resources can be in
    public enum ResourceGroup {

        ALL,
        DEBUG,
        GUI,
        START_UP,
        LOADING,
        MAIN_MENU,
        MATERIAL_DEMO,
        PHYSICS_DEMO,
        TWOD_DEMO
    };
}
