package view;


import utils.LanguageResourceBundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 1 on 01.11.2015.
 */
public class LoginFrame extends JFrame{

    private JTextField loginField;
    private JPasswordField passField;
    private JButton enterButton;
    private JButton registerButton;

    public LoginFrame(){

        setLocationRelativeTo(null);
        setSize(250, 105);
        setTitle(LanguageResourceBundle.get("login.title"));
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void init() {

        JLabel login = new JLabel(LanguageResourceBundle.get("login.username"));
        JLabel pass = new JLabel(LanguageResourceBundle.get("login.password"));

        loginField = new JTextField();
        passField = new JPasswordField();

        enterButton = new JButton(LanguageResourceBundle.get("login.enter"));
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        registerButton = new JButton(LanguageResourceBundle.get("login.register"));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        JPanel northInputPanel = new JPanel(new GridLayout(2,2));
        northInputPanel.add(login);
        northInputPanel.add(loginField);
        northInputPanel.add(pass);
        northInputPanel.add(passField);

        JPanel southButtonsPanel = new JPanel(new GridLayout(1,2));
        southButtonsPanel.add(enterButton);
        southButtonsPanel.add(registerButton);

        getContentPane().add(northInputPanel, BorderLayout.NORTH);
        getContentPane().add(southButtonsPanel, BorderLayout.SOUTH);

    }

}
