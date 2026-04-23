package com.game.object;

import javax.imageio.ImageIO;

import com.game.main.GamePanel;

public class OBJ_Key extends SuperObject {

    GamePanel gp;

    public OBJ_Key(GamePanel gp) {
        this.gp = gp;
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
