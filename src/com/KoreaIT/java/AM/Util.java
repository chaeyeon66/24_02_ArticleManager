package com.KoreaIT.java.AM;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
  // 현재 날짜 시간 구하는 메서드
  public static String getNowDateStr(){
    SimpleDateFormat dateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    Date time = new Date();
    return dateFormat.format(time);
  }
}
