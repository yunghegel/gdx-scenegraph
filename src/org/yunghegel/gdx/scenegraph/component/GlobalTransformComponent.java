package org.yunghegel.gdx.scenegraph.component;

import com.badlogic.gdx.math.Matrix4;
import com.google.gson.stream.JsonWriter;
import org.yunghegel.gdx.scenegraph.scene3d.GameObject;

import java.io.IOException;

public class GlobalTransformComponent<T extends Matrix4> extends BaseComponent<T> implements Component<T> {

    public GlobalTransformComponent(T object, GameObject gameObject) {
        super(object,gameObject);
    }



    @Override
    void update(T object, float delta) {
        object.set(gameObject.getTransform());
    }

    @Override
    void render(T object, float delta) {

    }



}
