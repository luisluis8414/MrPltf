package com.luw.entities;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import static com.luw.utils.Constants.PlayerConstants.*;
import static com.luw.utils.HelpMethods.CanMoveHere;

import com.luw.main.Game;
import com.luw.utils.HelpMethods;
import com.luw.utils.LoadSave;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private boolean left, up, right, down, flipped = false;
    private boolean moving = false, attacking = false;
    private float playerSpeed = 2.0f;
    private int[][] lvlData;
    private float xDrawOffset=21*Game.SCALE;
    private float yDrawOffset=4*Game.SCALE;


    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        initHitbox(x, y, 20*Game.SCALE, 28*Game.SCALE);
    }

    public void update() {
        updatePosition();
        updateAnimationTick();
        setAnimation();
    };

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int)hitBox.x - (int)xDrawOffset, (int)hitBox.y - (int)yDrawOffset, width,
                height, null);
        drawHitbox(g);
    };

    private void updatePosition() {
        moving = false;
        if (!left && !right && !up && !down)
            return;

        float xSpeed = 0, ySpeed = 0;
        if (left && !right) {
            xSpeed = -playerSpeed;
        } else if (right && !left) {
            xSpeed = playerSpeed;
        }

        if (up && !down) {
            ySpeed = -playerSpeed;
        } else if (down && !up) {
            ySpeed = playerSpeed;
        }

        // if(CanMoveHere(x+xSpeed,y+ySpeed, width, height, lvlData)){
        //     this.x+=xSpeed;
        //     this.y+=ySpeed;
        //     moving=true;
        // }

        
        if(CanMoveHere(hitBox.x+xSpeed,hitBox.y+ySpeed, hitBox.width, hitBox.height, lvlData)){
            hitBox.x+=xSpeed;
            hitBox.y+=ySpeed;
            moving=true;
        }
    }

    public void checkDir() {
        if (right && !left) {
            if (flipped) {
                for (BufferedImage[] animation : animations) {
                    for (int i = 0; i < animation.length; i++) {
                        animation[i] = HelpMethods.FlipImage(animation[i]);
                    }
                }
                flipped = false;
            }
        }
        if (left && !right) {
            if (!flipped) {

                for (BufferedImage[] animation : animations) {
                    for (int i = 0; i < animation.length; i++) {
                        animation[i] = HelpMethods.FlipImage(animation[i]);
                    }
                }
                flipped = true;
            }
        }
    }

    private void setAnimation() {
        int startAni = playerAction;

        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }

        if (attacking) {
            playerAction = ATTACK_1;
        }

        if (startAni != playerAction) {
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    private void loadAnimations() {

        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);

        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
        }
    }

    public void loadLevelData(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;

    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;

    }

    public void setRight(boolean right) {
        this.right = right;

    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

}
