package org.yunghegel.gdx.scenegraph.scene3d;

import com.badlogic.gdx.graphics.Camera;

public interface Scene {

    void update(float delta);

    void render(float delta);

    void resize(int width, int height);



}
