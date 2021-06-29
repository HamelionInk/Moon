package com.last.moon

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Skin

class Moon : Game() {
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont
    lateinit var skin: Skin
    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont()
        skin = Skin(Gdx.files.internal("uiskin.json"))
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