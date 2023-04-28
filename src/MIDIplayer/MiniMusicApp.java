package MIDIplayer;

import javax.sound.midi.*;

public class MiniMusicApp {
    public static void main(String[] args) {
        MiniMusicApp miniMusicApp = new MiniMusicApp();
        miniMusicApp.play();
    }

    /**
     * a.setMessage(тип сообщения, канал, нота для проигрывания, скорость и сила нажатия клавиши)
     * тип сообщения: 144 начало проигрывания ноты, 128 конец проигрывания ноты
     * канал: это номер проигрывающего, напр. №1, 2, 3 (по типу музыканта в оркестре)
     * нота для проигрывания: от 0 до 127
     * скорость и сила: 0 слабое нажатие, ничего не услышать, 100 - хорошее стандартное нажатие
     *
     * Изменение продолжительности звучания ноты
     * MidiEvent a = new MidiEvent(b, цифра продолжительности)
     *
     * setMessage если тип укажем 192 - это сообщение об изменении инструмента
     * setMessage(192, 1 канал, меняем на инструмент 102, 0)
     */
    public void play(){
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            ShortMessage a = new ShortMessage(); // создание сообщения
            a.setMessage(144,1, 44, 100); // сообщение помещаем в инструкцию (Начать проигрывать ноту 44)
            MidiEvent noteOn = new MidiEvent(a, 1); // используя сообщение создаем событие (сообщение а сработает на первом такте)
            track.add(noteOn); // добавляем событие в трек

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,44,100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(sequence);

            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
