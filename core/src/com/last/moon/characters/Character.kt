package com.last.moon.characters

import com.badlogic.gdx.graphics.Texture
import com.last.moon.animation.Animation
import java.awt.Rectangle

interface Character{
    var health: Float
    var moveSpeed: Float
    var attackPower: Float
    var texture:Texture
    var posX: Float
    var posY: Float

    fun move()

}