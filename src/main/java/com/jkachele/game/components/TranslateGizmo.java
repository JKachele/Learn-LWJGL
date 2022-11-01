/******************************************
 *Project-------Engine2D-LWJGL
 *File----------TranslateGizmo.java
 *Author--------Justin Kachele
 *Date----------10/24/2022
 *License-------GNU GENERAL PUBLIC LICENSE
 ******************************************/
package com.jkachele.game.components;

import com.jkachele.game.editor.PropertiesWindow;
import com.jkachele.game.engine.MouseListener;

public class TranslateGizmo extends Gizmo {

    public TranslateGizmo(Sprite arrowSprite, PropertiesWindow propertiesWindow) {
        super(arrowSprite, propertiesWindow);
    }

    @Override
    public void update(float dt) {
        if (activeGameObject != null) {
            if (xAxisActive && !yAxisActive && !zAxisActive) {
                activeGameObject.transform.position.x -= MouseListener.getWorldDX();
            }
            if (yAxisActive && !xAxisActive && !zAxisActive) {
                activeGameObject.transform.position.y -= MouseListener.getWorldDY();
            }
            if (zAxisActive && !xAxisActive && !yAxisActive) {
                float distance = (float)(Math.sqrt((MouseListener.getWorldDX() * MouseListener.getWorldDX()) +
                        (MouseListener.getWorldDY() * MouseListener.getWorldDY())));
                if (MouseListener.getWorldDX() < 0 || MouseListener.getWorldDY() < 0) {
                    distance *= -1;
                }
                activeGameObject.transform.position.x -= distance;
                activeGameObject.transform.position.y -= distance;
            }
        }
        super.update(dt);
    }
}