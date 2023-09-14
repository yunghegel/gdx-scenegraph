package org.yunghegel.gdx.scenegraph.scene3d;


import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;

import com.esotericsoftware.minlog.Log;
import com.google.gson.stream.JsonWriter;
import org.yunghegel.gdx.scenegraph.component.BaseComponent;
import org.yunghegel.gdx.scenegraph.component.GlobalTransformComponent;
import org.yunghegel.gdx.scenegraph.component.LocalTransformComponent;


import java.io.IOException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class GameObject extends SimpleNode<GameObject> implements Iterable<GameObject> {

    public static final String DEFAULT_NAME = "GameObject";

    public String name;
    public boolean active;

    public Array<BaseComponent> components=new Array<>();
    private Array<String> tags;
    public SceneGraph sceneGraph;

    public GameObject(SceneGraph sceneGraph, String name, int id,Matrix4 transform) {
        super(id);
        this.sceneGraph = sceneGraph;
        this.name = (name == null) ? DEFAULT_NAME : name;
        this.active = true;
        this.tags = null;
        Log.info("GameObject created: [" + this.name + "]  [" + this.id+"]");
        addComponent(new LocalTransformComponent<>(transform, this));
        addComponent(new GlobalTransformComponent<>(transform,this));

    }

    public void render(float delta){

        for (BaseComponent component : components) {
           component.render(delta);
        }
        if(getChildren()!=null){
            for (GameObject child : getChildren()) {
                child.render(delta);
            }
        }
    }

    public void update(float delta){
        for (BaseComponent component : components) {
            component.update(delta);
        }
        if(getChildren()!=null){
            for (GameObject child : getChildren()) {
                child.update(delta);
            }
        }
    }


    public GameObject findChildrenByName(String name) {
        for (GameObject go : this) {
            if (go.name.equals(name)) {
                return go;
            }
        }

        return null;
    }




    public void addComponent(BaseComponent component) {
        components.add(component);
    }

    public void removeComponent(BaseComponent component) {
        components.removeValue(component, true);
    }

    public boolean hasComponent(Class<? extends BaseComponent> component) {
        for (BaseComponent c : components) {
            if (c.getClass().equals(component)) {
                return true;
            }
        }

        return false;
    }

    public Array<String> getTags() {
        return this.tags;
    }

    /**
     * Adds a tag.
     *
     * @param tag
     *            tag to add
     */
    public void addTag(String tag) {
        if (this.tags == null) {
            this.tags = new Array<String>(2);
        }

        this.tags.add(tag);
    }


    @Override
    public Iterator<GameObject> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super GameObject> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<GameObject> spliterator() {
        return Iterable.super.spliterator();
    }

    public Array<BaseComponent> getComponents() {
        return components;
    }

    public Array<BaseComponent> getComponentsByClass(Class<? extends BaseComponent> type) {
        Array<BaseComponent> components = getComponents();
        Array<BaseComponent> tmp = new Array<>();
        for (BaseComponent component : components) {
            if (component.getClass().equals(type)) {
                tmp.add(component);
            }
        }
        return tmp;
    }



}
