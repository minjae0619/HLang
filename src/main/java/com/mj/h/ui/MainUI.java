package com.mj.h.ui;

import com.mj.h.log.LogType;
import com.mj.h.log.Logger;
import com.mj.h.utils.Resource;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainUI extends JFrame {


    private JFXPanel jfxPanel = new JFXPanel();
    private WebView webView;
    private WebEngine webEngine;
    private Group group = new Group();

    private Scene scene = new Scene(group);

    public MainUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setResizable(false);
        setSize(1400, 760);
        setTitle("H Language");
        setLayout(null);
        Platform.runLater(()-> {

            webView = new WebView();
            group = new Group();

            scene = new Scene(group);
            jfxPanel.setScene(scene);
            group.getChildren().add(webView);
            webView.setMinSize(1400, 760);
            webView.setMaxSize(1400, 760);
            webEngine = webView.getEngine();
            String text = String.format(Resource.getText(Resource.getResource("/index.html")), Resource.getJavaCode().replace("\\", "\\\\").replace("\n", "\\n"));
            webEngine.loadContent(text);
        });
    }
    public String getJavaCode(){
        return (String) webEngine.executeScript("getText()");

    }
    public void view() {
        jfxPanel.setBounds(0, 0, 1400, 760);
        add(jfxPanel);
        this.getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Platform.runLater(() -> {
                    String text = getJavaCode();
                    Resource.writeJavaCode(text);
                    Resource.readCode();
                });
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);


        this.getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Platform.runLater(() -> {
                    String text = (String) webEngine.executeScript("window.editor.getModel().getValueInRange(window.editor.getSelection())");
                    if (text.equals(""))
                        return;
                    StringSelection stringSelection = new StringSelection(text);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                });
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

        this.getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Platform.runLater(() -> {
                    String text = (String) webEngine.executeScript("window.editor.getModel().getValueInRange(window.editor.getSelection())");
                    if (text.equals(""))
                        return;
                    StringSelection stringSelection = new StringSelection(text);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                });
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
        setVisible(true);

    }
}