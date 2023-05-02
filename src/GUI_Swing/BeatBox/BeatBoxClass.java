package GUI_Swing.BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * GUI будет иметь 256 снятых флажков (JCheckBox), 16 меток (JLabel) для названий инструментов и 4 кнопки
 * Связываем AudioListener с каждой кнопкой.
 * Слушатели для флажков не нужны, т.к не будет меняться динамически звучание при изменении флажков - жмем Start для этого
 */
public class BeatBoxClass {

    JPanel mainPanel;
    ArrayList<JCheckBox> checkBoxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args) {
        new BeatBoxClass().buildGUI();
    }

    public void buildGUI(){
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // пустая граница для полей

        checkBoxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new MySendListener());
        buttonBox.add(saveButton);

        JButton restoreButton = new JButton("Restore");
        restoreButton.addActionListener(new MyReadInListener());
        buttonBox.add(restoreButton);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++){
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for(int i = 0; i < 256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
            // Создали чек боксы, выключили, и добавили в ArrayList
        }

        setUpMidi();

        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi(){ // MIDI код для получения синтезатора, сиквенсора и дорожки
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void buildTrackAndStart(){
        int[] trackList = null;// массив из 16 элементов для хранения значения для каждого инструмента на все 16 тактов

        sequence.deleteTrack(track);
        track = sequence.createTrack(); // удаляем старую дорожку и создаем новую

        for (int i = 0; i < 16; i++){
            trackList = new int[16]; // делаем для каждого из 16 рядов

            int key = instruments[i]; // задаем клавишу, которая представляем инструмент, массив содержит MIDI числа для инструментов

            for (int j = 0; j < 16; j++){
                /**
                 * Установлен ли флажок на этом такте. Если да, то помещаем значение клавиши в текущую ячейку массива.
                 * Если нет, то инструмент не должен играть в этом такте, поэтому присваиваем ему 0
                 */
                JCheckBox jc = (JCheckBox) checkBoxList.get(j + (16 * i));
                if (jc.isSelected()){
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList); // для этого инструмента и для всех 16 тактов создаем события и добавляем их на дорожку
            track.add(makeEvent(176,1,127,0,16));
        }

        track.add(makeEvent(192,9,1,0,15)); // Мы должны быть уверены, что событие на такте 16 существует (они идут от 0 до 15)
        // Иначе BeatBox может не пройти все 16 тактов перед тем как заново начнет последовательность
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY); // позволяет задать количество повторений цикла или непрерывность
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
    }

    public class MyStartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 1.03)); // темп синтезатора, по-умолчанию 1.0, щелчком мыши делаем +/- 3%
        }
    }

    public class MyDownTempoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * .97)); // темп синтезатора, по-умолчанию 1.0, щелчком мыши делаем +/- 3%
        }
    }

    public class MySendListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) { // Все что происходит при нажатии элементов, которые в прослушке
            boolean[] checkboxState = new boolean[256]; // создаем булев массив для хранения состояния каждого флажка

            for (int i = 0; i < 256; i++){
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if (check.isSelected()){
                    checkboxState[i] = true;
                }
            }

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File("Checkbox.ser"));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(checkboxState);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public class MyReadInListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkBoxState = null;

            try {
                FileInputStream fileInputStream = new FileInputStream(new File("Checkbox.ser"));
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                checkBoxState = (boolean[]) objectInputStream.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (int i = 0; i < 256; i++){
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if (checkBoxState[i]){
                    check.setSelected(true);
                } else {
                    check.setSelected(false);
                }
            }

            sequencer.stop();
            buildTrackAndStart();
        }
    }

    /**
     * makeTracks создает события для одного инструмента за каждый проход цикла для всех 16 тактов.
     * Можно получить int[] для Bass Drum и каждый элемент массива будет содержать либо клавишу этого инструмента либо 0.
     * Если 0, то инструмент не играет на текущем такте, иначе нужно создать событие и добавить его в дорожку
     */
    public void makeTracks(int[] list){
        for (int i = 0; i < 16; i++){
            int key = list[i];
            if (key != 0){
                // Создаем события включения и выключения и добавляем их в дорожку
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(128,9,key,100,i+1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return event;
    }


}
