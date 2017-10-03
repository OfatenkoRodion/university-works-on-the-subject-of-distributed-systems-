package Forms;

import sun.misc.IOUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static Java.GetURL.getHTML;
import static Java.GetURLInfo.getURL_info;


public class Form {
    public JPanel form;
    private JTextField textField1;
    private JButton послатьДанныеНаСерверButton;
    private JButton получитьКодСтраницыURLButton;
    private JTextArea ответTextArea;

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

                    ответTextArea.setText( getHTML(url));
                }
                catch (Exception ex) {
                    ответTextArea.setText(ex.toString());
                }
            }
        });
    }
}
