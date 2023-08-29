package org.yunghegel.gdx.scenegraph.scene3d;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;


public class SceneGraph implements Json.Serializable {

    protected BaseScene scene;
    protected GameObject root;


    public SceneGraph(BaseScene scene) {
        root = new GameObject(this, "root", -1,new Matrix4());
        root.initChildrenArray();
    }

    public void render(float delta) {
        for (GameObject go : root.getChildren()) {
            go.render(delta);
        }
    }

    public void update(float delta) {
        for (GameObject go : root.getChildren()) {
            go.update(delta);
        }
    }

    public void addGameObject(GameObject go) {
        root.addChild(go);
    }

    public Array<GameObject> getGameObjects() {
        return root.getChildren();
    }

    public GameObject getGameObjectByName(String name) {
        return root.findChildrenByName(name);
    }

    public GameObject getRoot() {
        return root;
    }



    public int getGameObjectCount(){
        int count = 0;
        for (GameObject go : root.getChildren()) {
            count++;
            countChildren(go,count);
        }
        return count;
    }

    public int countChildren(GameObject go,int count){
        if (go.getChildren() == null) return count;
        for (GameObject child : go.getChildren()) {
            if (child != null) {
                count++;
                countChildren(child,count);
            }

        }
        return count;
    }


    @Override
    public void write(Json json) {
      json.writeValue("root",root);

    }

    @Override
    public void read(Json json, JsonValue jsonData) {

    }

    public void write(Json json, GameObject go){
        json.writeValue("gameObject",go);
        if(go.getChildren() != null){
            json.writeArrayStart("children");
            for(GameObject child:go.getChildren()){

                json.writeValue(child);
            }
            json.writeArrayEnd();
        }
    }
}
