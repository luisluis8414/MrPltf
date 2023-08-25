package com.luw.levels;

import com.luw.main.Game;
import com.luw.utils.LoadSave;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LevelHandler {
    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;

    public LevelHandler(Game game){
        this.game=game;
        // levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
        importOutsideSprites();
        levelOne= new Level(LoadSave.GetLevelData());
    }


    private void importOutsideSprites() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        //y-Achse sind 4 Bloecke. j durchlaeuft diese
        //wir unterteilen sprites in 32x32 pixel Bloeke
        //i ist x unterteilt in 12 d.h wir haben 12 x 32 Breite und 4 x 32 Hoehe
        for(int j =0;j<4;j++){
            for(int i=0; i<12; i++){
                int index=j*12+i;
                //x starting from left d.h ab dort nach rechts
                //y starting from top d.h ab dort nach unten
                //getSubimage(x-koordinate, y-koordinate, width, height)
                levelSprite[index] = img.getSubimage(i*32, j*32, 32, 32);
            }
        }
    }


    public void draw(Graphics g){
        for(int j =0; j< Game.TILES_IN_HEIGHT;j++)
        {
            for(int i=0; i<Game.TILES_IN_WIDTH;i++)
            {
                int index= levelOne.getSpriteIndex(i, j);
                 g.drawImage(levelSprite[index], Game.TILES_SIZE*i, Game.TILES_SIZE*j, Game.TILES_SIZE, Game.TILES_SIZE, null);
            }
        }
    }

    public Level getCurrentLevel(){
        return levelOne;
    }
}
