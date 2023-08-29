package org.yunghegel.gdx.scenegraph.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import org.yunghegel.gdx.scenegraph.scene3d.SceneGraph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SceneGraphSerializer {

    SceneGraph sceneGraph;

    public SceneGraphSerializer(SceneGraph sceneGraph) {
        this.sceneGraph = sceneGraph;
    }


    public void serialize(File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(file);
        JsonWriter jsonWriter = new JsonWriter(writer);

        sceneGraph.getRoot().serialize(jsonWriter);
        writer.close();



        //pretty print





    }

}
