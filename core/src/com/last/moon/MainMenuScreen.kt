package com.last.moon

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.last.moon.characters.Hero


class MainMenuScreen(var game: Moon) : Screen  {
    var batch: SpriteBatch
    var row_height = Gdx.graphics.width / 12f
    var col_width = Gdx.graphics.width / 12f
    var camera: OrthographicCamera = OrthographicCamera()
    var textureBackground: Texture
    var stage: Stage
    var skin: Skin
    var playButton: TextButton
    var exitButton: TextButton

    init {

        textureBackground = Texture("menuBackground.jpg")
        batch = SpriteBatch()

        camera.setToOrtho(false, 800f, 400f)
        stage = Stage(ScreenViewport())
        skin = Skin(Gdx.files.internal("glassy-ui.json"))

        playButton = TextButton("Play", skin, "small")
        playButton.setSize(col_width*3, row_height)
        playButton.setPosition(col_width*4.5f,Gdx.graphics.getHeight()-row_height*4)
        playButton.addListener(object : InputListener() {
            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
            }

            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                game.setScreen(GameScreen(game))
                return true
            }
        })
        stage.addActor(playButton)

        exitButton = TextButton("Exit", skin, "small")
        exitButton.setSize(col_width*3, row_height)
        exitButton.setPosition(col_width*4.5f, Gdx.graphics.getHeight()-row_height*5.5f)
        exitButton.addListener(object : InputListener() {
            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
            }

            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                Gdx.app.exit()
                return true
            }
        })
        stage.addActor(exitButton)



        Gdx.input.inputProcessor = stage

    }

    override fun show() {
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(textureBackground,10f,10f)
        batch.end()
        stage.act()
        stage.draw()
        camera.update()

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