package com.last.moon

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.last.moon.characters.Character
import com.last.moon.characters.Hero

class GameScreen(var game: Moon) : Screen {
    var camera = OrthographicCamera()
    var backgroundTexture: Texture


    init {
        camera.setToOrtho(false, 800f, 400f)
        backgroundTexture = Texture("background.png")
    }

    override fun show() {
    }

    override fun render(delta: Float) {
        game.hero.animation.update(delta)

        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        game.batch.begin()
        game.font.draw(game.batch, "Game Screen", 150f, 150f)
        game.batch.draw(backgroundTexture,0f,0f)
        game.batch.draw(game.hero.animation.getFrame(), game.hero.posX, game.hero.posY)
        game.batch.draw(game.enemy.texture, game.enemy.posX, game.enemy.posY)
        game.batch.end()

        game.hero.move()
        game.enemy.move()
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
    }
}