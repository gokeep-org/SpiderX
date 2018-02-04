package com.spiderx.util;

import java.util.Date;

public class DateUtil {
    private DateUtil(){}

    public static Long getCurrentDateTimeValue(){
        return new Date().getTime();
    }
}
