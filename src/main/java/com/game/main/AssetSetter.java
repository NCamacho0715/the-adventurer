package com.game.main;

import com.game.object.OBJ_Boots;
import com.game.object.OBJ_Chest;
import com.game.object.OBJ_Door;
import com.game.object.OBJ_Key;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 40 * gp.tileSize;
        gp.obj[0].worldY = 40 * gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 3 * gp.tileSize;
        gp.obj[1].worldY = 5 * gp.tileSize;

        gp.obj[2] = new OBJ_Key();
        gp.obj[2].worldX = 3 * gp.tileSize;
        gp.obj[2].worldY = 44 * gp.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 18 * gp.tileSize;
        gp.obj[3].worldY = 14 * gp.tileSize;

        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 30 * gp.tileSize;
        gp.obj[4].worldY = 24 * gp.tileSize;

        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 5 * gp.tileSize;
        gp.obj[5].worldY = 39 * gp.tileSize;

        gp.obj[6] = new OBJ_Chest();
        gp.obj[6].worldX = 5 * gp.tileSize;
        gp.obj[6].worldY = 44 * gp.tileSize;

        gp.obj[7] = new OBJ_Boots();
        gp.obj[7].worldX = 18 * gp.tileSize;
        gp.obj[7].worldY = 12 * gp.tileSize;
    }
}
