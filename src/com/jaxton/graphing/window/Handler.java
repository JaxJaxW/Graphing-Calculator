package com.jaxton.graphing.window;

import com.jaxton.graphing.framework.GameObject;

import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    private GameObject tempObject;

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            tempObject = object.get(i);
            tempObject.tick(object);
        }
    }





}
