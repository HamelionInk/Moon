package com.last.moon

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.last.moon.characters.Enemy
import com.last.moon.characters.Hero

class Moon() : Game() {
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont
    lateinit var hero: Hero
    lateinit var enemy: Enemy

    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont()
        hero = Hero()
        enemy = Enemy()

        this.setScreen(MainMenuScreen(this))
    }

    override fun render() {
        super.render()
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }
}