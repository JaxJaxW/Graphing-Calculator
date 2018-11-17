package com.jaxton.graphing.objects;

import com.jaxton.graphing.framework.GameObject;
import com.jaxton.graphing.framework.ObjectId;

import java.awt.*;
import java.util.LinkedList;

public class Block extends GameObject {

    public Block(float x, float y, ObjectId id) {
        super(x, y, id);
    }

    public void tick(LinkedList<GameObject> object) {

    }

    public void render(Graphics g) {

    }

    public Rectangle getBounds() {
        return null;
    }
}
