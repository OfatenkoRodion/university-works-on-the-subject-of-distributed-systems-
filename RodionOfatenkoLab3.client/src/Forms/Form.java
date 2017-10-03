package Forms;

import sun.misc.IOUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import static Java.GetURL.getHTML;
import static Java.GetURLInfo.getURL_info;


public class Form {
    public JPanel form;
    private JTextField textField1;
    private JButton послатьДанныеНаСерверButton;
    private JButton получитьКодСтраницыURLButton;
    private JTextArea ответTextArea;
    private JEditorPane editorPane1;

    public Form() {
        ответTextArea.setLineWrap(true);
        послатьДанныеНаСерверButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url=textField1.getText();
                    ответTextArea.setText( getURL_info(new URL(url)));
                }
                catch (Exception ex) {
                    ответTextArea.setText(ex.toString());
                }
            }
        });
        получитьКодСтраницыURLButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url=textField1.getText();


                    show(url);
                    ответTextArea.setText( getHTML(url));
                }
                catch (Exception ex) {
                    ответTextArea.setText(ex.toString());
                }
            }
        });
    }
    public static void show(String url) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        JEditorPane editorPane = new JEditorPane(url);
        editorPane.setEditable(false);
        frame.getContentPane().add(editorPane);
        //
        frame.setSize(700, 800);
        frame.setVisible(true);
    }
}
