package com.last.moon.characters

import com.badlogic.gdx.graphics.Texture

class Enemy() : Character {

    override var texture = Texture("hero.png")
    override var health = 10f
    override var moveSpeed = 20f
    override var attackPower = 100f
    override var posX = 400f
    override var posY = 400f

    override fun move() {
        posX
    }
}