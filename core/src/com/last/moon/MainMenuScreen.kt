package com.last.moon

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.utils.viewport.ScreenViewport


class MainMenuScreen(var game: Moon) : Screen  {
    var ui = Stage(ScreenViewport(), game.batch)
    var buttonStart: TextButton
    var buttonExit: TextButton
    var camera: OrthographicCamera = OrthographicCamera()

    init {

        buttonStart = TextButton("Play", game.skin)
        buttonExit = TextButton("Exit", game.skin)
        Gdx.input.setInputProcessor(ui)
        camera.setToOrtho(false, 800f, 400f)
        buttonStart.setPosition(Gdx.graphics.width/2 - buttonStart.width, Gdx.graphics.height - 200f)
        ui.addActor(buttonStart)
        buttonExit.setPosition(Gdx.graphics.width/ 2 - buttonExit.width, Gdx.graphics.height - 200f)
        ui.addActor(buttonExit)
    }


    override fun show() {
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        ui.act(delta)
        ui.draw()
        camera.update()
        game.batch.begin()
        //game.font.draw(game.batch, "Welcome to Moon", 100f, 150f)
        //game.font.draw(game.batch, "Tap anyway to begin", 100f, 170f)
        game.batch.end()

        if(Gdx.input.isTouched) {
            game.setScreen(GameScreen(game))
            dispose()
        }



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