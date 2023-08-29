package org.yunghegel.gdx.scenegraph.serialize;

import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public interface Serializable {

    void serialize(JsonWriter writer) throws IOException;

}
