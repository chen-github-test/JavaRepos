package com.snack.main;

import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL  getHeaderUpUrl=Data.class.getResource("/static/header-up.png");
    public static URL  getHeaderDownUrl=Data.class.getResource("/static/header-down.png");
    public static URL  getHeaderLeftUrl=Data.class.getResource("/static/header-left.png");
    public static URL  getHeaderRightUrl=Data.class.getResource("/static/header-Right.png");
    public static URL  getBodyUrl=Data.class.getResource("/static/body.png");
    public static URL  getFoodUrl=Data.class.getResource("/static/food.png");
    //图片
    public static ImageIcon getHeaderUpImageIcon=new ImageIcon(getHeaderUpUrl);
    public static ImageIcon getHeaderDownImageIcon=new ImageIcon(getHeaderDownUrl);
    public static ImageIcon getHeaderLeftImageIcon=new ImageIcon(getHeaderLeftUrl);
    public static ImageIcon getHeaderRightImageIcon=new ImageIcon(getHeaderRightUrl);
    public static ImageIcon getBodyImageIcon=new ImageIcon(getBodyUrl);
    public static ImageIcon getFoodImageIcon=new ImageIcon(getFoodUrl);
}
