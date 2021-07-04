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
    var row_height = Gdx.graphics.width / 12f
    var col_width = Gdx.graphics.width / 12f
    var camera: OrthographicCamera = OrthographicCamera()
    var stage: Stage
    var skin: Skin
    var PlayButton: TextButton

    init {

        camera.setToOrtho(false, 800f, 400f)
        stage = Stage(ScreenViewport())
        skin = Skin(Gdx.files.internal("glassy-ui.json"))
        PlayButton = TextButton("Play", skin, "small")
        PlayButton.setSize(col_width*4, row_height)
        PlayButton.setPosition(col_width,Gdx.graphics.getHeight()-row_height*3);
        stage.addActor(PlayButton)
        Gdx.input.inputProcessor = stage

    }

    override fun show() {
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act()
        stage.draw()
        camera.update()


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