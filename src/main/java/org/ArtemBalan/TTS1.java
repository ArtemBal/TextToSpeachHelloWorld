package org.ArtemBalan;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTS1 {
    Voice voice;
    public TTS1(String voiceName)
    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice = VoiceManager.getInstance().getVoice(voiceName);
    }
    public void speak(String msg) {
        try {
            if (voice != null) {
                voice.allocate();

                voice.setRate(190);
                voice.setPitch(150);
                voice.setVolume(10);

                voice.speak(msg);
                voice.deallocate();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String speekstring = "Hello, my name is Kevin.!";
        TTS1 tts1 = new TTS1("kevin16");
        tts1.speak(speekstring);
    }
}
