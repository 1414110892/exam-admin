package com.ycx.Exam.utils;

public class judgeLevel {
    static int levelName;
    public static Integer getLevelName(String LevelName){

        if(LevelName.equals("一年级")){
            levelName =  1;
        }
        if(LevelName.equals("二年级")){
            levelName =  2;
        }
        if(LevelName.equals("三年级")){
            levelName =  3;
        }
        if(LevelName.equals("四年级")){
            levelName =  4;
        }
        if(LevelName.equals("五年级")){
            levelName =  5;
        }
        if(LevelName.equals("六年级年级")){
            levelName =  6;
        }
        if(LevelName.equals("初一")){
            levelName =  7;
        }
        if(LevelName.equals("初二")){
            levelName =  8;
        }
        if(LevelName.equals("初三")){
            levelName =  9;
        }
        if(LevelName.equals("高一")){
            levelName =  10;
        }
        if(LevelName.equals("高二")){
            levelName =  11;
        }
        if(LevelName.equals("高三")){
            levelName =  12;
        }
        return levelName;
    }
}
