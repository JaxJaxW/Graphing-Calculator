package com.jaxton.graphing.window;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Window {

    public Window(int w, int h, String title, Calculator calculator) {
        calculator.setPreferredSize(new Dimension(w, h));
        calculator.setMaximumSize(new Dimension(w, h));
        calculator.setMinimumSize(new Dimension(w, h));

        JFrame frame = new JFrame(title);
        frame.add(calculator);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);





    }




}
