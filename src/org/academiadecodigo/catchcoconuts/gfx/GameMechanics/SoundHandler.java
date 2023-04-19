package org.academiadecodigo.catchcoconuts.gfx.GameMechanics;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class SoundHandler {

    private static Clip clip;

    public static void PlaySound(String filename) {
        try (InputStream in = SoundHandler.class.getResourceAsStream(filename)) {
            InputStream bufferedIn = new BufferedInputStream(in);
            try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn)) {
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void makeMeStop(){
        clip.stop();
    }
}

