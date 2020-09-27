package com.wanniu.game.attendance;


public class AttendanceUtil {
    private static AttendanceUtil instance;

    public static AttendanceUtil getInstance() {
        if (instance == null) {
            instance = new AttendanceUtil();
        }
        return instance;
    }
}


