package org.yunghegel.gdx.scenegraph.component;

import com.badlogic.gdx.math.Matrix4;
import com.google.gson.stream.JsonWriter;
import org.yunghegel.gdx.scenegraph.scene3d.GameObject;

import java.io.IOException;

public class GlobalTransformComponent<T extends Matrix4> extends SerializableComponent<T> implements Component<T> {

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


    @Override
    public void serialize(JsonWriter writer) throws IOException {
        writer.beginObject();
        writer.name("globalTransform");

        writer.value(object.getValues().toString());
        writer.endObject();
    }
}
