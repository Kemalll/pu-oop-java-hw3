package ui;

import javax.swing.*;

public class Modal extends JDialog {

    public Modal(JFrame parent, String title,String message){
        super(parent,title,true);

        JPanel panel=new JPanel();
        JLabel lable=new JLabel(message);
        panel.add(lable);
        getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public static void render(JFrame parent, String title,String message){
        new Modal(parent,title,message);
    }
}
