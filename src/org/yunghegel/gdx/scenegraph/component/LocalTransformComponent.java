package org.yunghegel.gdx.scenegraph.component;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.google.gson.stream.JsonWriter;
import org.yunghegel.gdx.scenegraph.scene3d.GameObject;

import java.io.IOException;

public class LocalTransformComponent<T extends Matrix4> extends SerializableComponent<T> {

    Vector3 localPosition = new Vector3();
    Vector3 localScale = new Vector3();
    Quaternion localRotation = new Quaternion();

    public LocalTransformComponent(T object, GameObject gameObject) {
        super(object,gameObject);
    }

    @Override
    void update(T object, float delta) {
        gameObject.getLocalPosition(localPosition);
        gameObject.getLocalScale(localScale);
        gameObject.getLocalRotation(localRotation);
        object.set(localPosition,localRotation,localScale);
    }

    @Override
    void render(T object, float delta) {

    }


    @Override
    public void serialize(JsonWriter writer) throws IOException {
        writer.beginObject();
        writer.name("localTransform");
        writer.value(object.toString());
        writer.endObject();
    }
}
