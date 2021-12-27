package com.example.beatboxnew

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class SoundViewModelTest {
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel
    private lateinit var beatBox: BeatBox

    @Before
    fun setUp() {
        beatBox = Mockito.mock(BeatBox::class.java)
        sound = Sound("assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        Assert.assertSame(subject.title, sound.name)
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()
        Mockito.verify(beatBox).play(sound)
    }
}