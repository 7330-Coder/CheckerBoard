/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wangguan;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author LSY
 */
public class CheckerBoard {
    
    public static final Color DEFAULT_LIGHT_COLOR = Color.RED;
    public static final Color DEFAULT_DARK_COLOR = Color.BLACK;
    
    public static final int DEFAULT_NUM_ROWS = 8;
    public static final int DEFAULT_NUM_COLS = 8;
    
    private int numRows;
    private int numCols;
    private double width;
    private double height;
    private Color lightColor;
    private Color darkColor;
    
    private AnchorPane board;

    public CheckerBoard(int numRows, int numCols, double width, double height, Color lightColor, Color darkColor) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.width = width;
        this.height = height;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }

    public CheckerBoard(int numRows, int numCols, double width, double height) {
        this(numRows, numCols, width, height, DEFAULT_LIGHT_COLOR, DEFAULT_DARK_COLOR);
    }
    
    public AnchorPane build() {
        double rectWidth = getRectangleWidth();
        double rectHeight = getRectangleHeight();
        
        board = new AnchorPane();
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Color color = (row + col) % 2 == 0 ? lightColor : darkColor;
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                rect.layoutXProperty().set(rectWidth * row);
                rect.layoutYProperty().set(rectHeight * col);
                board.getChildren().add(rect);
            }
        }
        
        return board;
    }
    
    /**
     * 
     * @return 
     */
    public AnchorPane getBoard() {
        return board;
    }
    
    /**
     * @return the numRows
     */
    public int getNumRosw() {
        return numRows;
    }

    /**
     * @param numRosw the numRows to set
     */
    public void setNumRosw(int numRosw) {
        this.numRows = numRosw;
    }

    /**
     * @return the numCols
     */
    public int getNumCols() {
        return numCols;
    }

    /**
     * @param numCols the numCols to set
     */
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the lightColor
     */
    public Color getLightColor() {
        return lightColor;
    }

    /**
     * @param lightColor the lightColor to set
     */
    public void setLightColor(Color lightColor) {
        this.lightColor = lightColor;
    }

    /**
     * @return the darkColor
     */
    public Color getDarkColor() {
        return darkColor;
    }

    /**
     * @param darkColor the darkColor to set
     */
    public void setDarkColor(Color darkColor) {
        this.darkColor = darkColor;
    }

    /**
     * @return the rectangleWidth
     */
    public double getRectangleWidth() {
        return width / numCols;
    }

    /**
     * @return the rectangleHeight
     */
    public double getRectangleHeight() {
        return height / numRows;
    }

}
