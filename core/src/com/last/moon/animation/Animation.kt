package com.last.moon.animation

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Array

class Animation(region: TextureRegion, frameCount: Int, cycleTime: Float) {
    var frames: Array<TextureRegion>
    var maxFrameTime: Float
    var currentFrameTime: Float = 0.0f
    var frameCount: Int
    var frame: Int

    init {
        frames = Array<TextureRegion>()
        var frameWidth: Int = region.regionWidth / frameCount
        for(i in 0..frameCount) {
            frames.add(TextureRegion(region, i * frameWidth, 0, frameWidth, region.regionHeight))
        }
        this.frameCount = frameCount
        maxFrameTime = cycleTime / frameCount
        frame = 0
    }

    fun update(dt: Float) {
        currentFrameTime += dt
        if(currentFrameTime > maxFrameTime) {
            frame++
            currentFrameTime = 0f
        }
        if(frame >= frameCount) {
            frame = 0
        }
    }
    fun getFrame(): TextureRegion {
        return frames.get(frame)
    }
}