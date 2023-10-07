package org.yunghegel.gdx.scenegraph.scene3d;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Disposable;

public interface Scene extends Disposable {

    void update(float delta);

    void render(float delta);

    void resize(int width, int height);



}
