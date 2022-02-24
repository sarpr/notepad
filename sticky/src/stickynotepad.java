import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class stickynotepad extends JFrame{
    private JButton button1;
    private JButton button2;
    private JTextArea textArea1;
    private javax.swing.JPanel JPanel;

    public stickynotepad() {
        setContentPane(JPanel);
        setTitle("stickynotepad");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(250,250);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
                File snote = new File(filename + ".txt");
                try {
                    FileWriter writer = new FileWriter(snote);
                    writer.write(textArea1.getText());

                    writer.close();
                    button2.setForeground(Color.GREEN);

                } catch (IOException ex) {
                    ex.printStackTrace();
                    button2.setForeground(Color.RED);
                }


            }
        });
    }
    public static void main(String[] args) {
        stickynotepad snpf = new stickynotepad();

    }



}

