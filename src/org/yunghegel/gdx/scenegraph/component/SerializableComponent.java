package org.yunghegel.gdx.scenegraph.component;

import org.yunghegel.gdx.scenegraph.scene3d.GameObject;
import org.yunghegel.gdx.scenegraph.serialize.Serializable;

public abstract class SerializableComponent<T> extends BaseComponent<T> implements Serializable {

    public SerializableComponent(T object, GameObject gameObject) {
        super(object, gameObject);
    }


}
