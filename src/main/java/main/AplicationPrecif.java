
package main;

import view.TelaLogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicationPrecif {
     public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
 
     } 
}
