package com.last.moon.characters

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.last.moon.Moon
import com.last.moon.animation.Animation

class Hero() : Character  {
    override var texture = Texture("4.png")
    override var health = 10f
    override var moveSpeed = 2f
    override var attackPower = 100f
    override var posX = 200f
    override var posY = 200f
    var animation: Animation = Animation(TextureRegion(texture),3, 0.5f)

    override fun move() {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            if(posX > 99) {
                posX -= moveSpeed
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            if(posX < 864) {
                posX += moveSpeed
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            if(posY < 648) {
                posY += moveSpeed
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            if(posY > 100) {
                posY -= moveSpeed
            }
        }
    }
}