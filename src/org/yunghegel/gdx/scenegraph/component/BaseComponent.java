package org.yunghegel.gdx.scenegraph.component;

import org.yunghegel.gdx.scenegraph.scene3d.GameObject;

public abstract class BaseComponent<T> implements Component<T> {

    protected T object;
    protected GameObject gameObject;

    public BaseComponent(T object, GameObject gameObject) {
        this.object = object;
        this.gameObject = gameObject;
    }

    abstract void update(T object, float delta);

    abstract void render(T object, float delta);

    @Override
    public void update(float delta) {
        update(object, delta);
    }

    @Override
    public void render(float delta) {
        render(object, delta);
    }


}
