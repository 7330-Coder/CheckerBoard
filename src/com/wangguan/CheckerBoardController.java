/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wangguan;

import static com.wangguan.CheckerBoard.DEFAULT_NUM_COLS;
import static com.wangguan.CheckerBoard.DEFAULT_NUM_ROWS;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author LSY
 */
public class CheckerBoardController implements Initializable {

    private Stage stage;
    private CheckerBoard cb;

    @FXML
    private AnchorPane board;

    @FXML
    private VBox vbox;

    @FXML
    private MenuBar menuBar;

    @FXML
    private void gridMenuItemClick(ActionEvent event) {
        MenuItem item = (MenuItem) event.getTarget();
        String itemName = item.getText();
        if ("16 x 16".equals(itemName)) {
            cb.setNumRosw(16);
            cb.setNumCols(16);
        } else if ("10 x 10".equals(itemName)) {
            cb.setNumRosw(10);
            cb.setNumCols(10);
        } else if ("8 x 8".equals(itemName)) {
            cb.setNumRosw(8);
            cb.setNumCols(8);
        } else if ("3 x 3".equals(itemName)) {
            cb.setNumRosw(3);
            cb.setNumCols(3);
        }
        cb.build();
        vbox.getChildren().set(1, cb.build());
    }

    @FXML
    private void colorMenuItemClick(ActionEvent event) {
        MenuItem item = (MenuItem) event.getTarget();
        String itemName = item.getText();
        if ("Default".equals(itemName)) {
            cb.setLightColor(CheckerBoard.DEFAULT_LIGHT_COLOR);
            cb.setDarkColor(CheckerBoard.DEFAULT_DARK_COLOR);
        } else if ("Blue".equals(itemName)) {
            cb.setLightColor(Color.SKYBLUE);
            cb.setDarkColor(Color.DARKBLUE);
        }
        cb.build();
        vbox.getChildren().set(1, cb.build());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void ready(Stage stage) {
        this.stage = stage;
        stage.widthProperty().addListener(windowsSizeChangeListener);
        stage.heightProperty().addListener(windowsSizeChangeListener);

        cb = new CheckerBoard(DEFAULT_NUM_ROWS, DEFAULT_NUM_COLS, board.getWidth(), board.getHeight());
        vbox.getChildren().set(1, cb.build());
    }

    private ChangeListener<Number> windowsSizeChangeListener = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            Scene scene = stage.getScene();
//            double newWidth = vbox.getWidth();
//            double newHeight = vbox.getHeight() - menuBar.getHeight();
            double newWidth = scene.getWidth();
            double newHeight = scene.getHeight() - menuBar.getHeight();
            newWidth = Math.max(0, newWidth);
            newHeight = Math.max(0, newHeight);
            cb.setWidth(newWidth);
            cb.setHeight(newHeight);
            cb.build();
            vbox.getChildren().set(1, cb.build());
        }
    };
}
