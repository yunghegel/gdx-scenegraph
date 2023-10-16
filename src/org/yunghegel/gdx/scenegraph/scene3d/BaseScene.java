package org.yunghegel.gdx.scenegraph.scene3d;


import javax.annotation.Nullable;

public abstract class BaseScene implements Scene {

    protected String name;
    public String path;




    public BaseScene(String name,String path){
        this.name = name;
        this.path = path;
    }


    public String name() {
        return name;
    }



    public String path() {
        return path;
    }





}
