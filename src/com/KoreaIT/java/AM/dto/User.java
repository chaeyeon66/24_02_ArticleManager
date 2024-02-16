package com.KoreaIT.java.AM.dto;

public class User {
  public int id;
  public String userId;
  public String password;
  public String nickname;

  public User(String userId, String password, String nickname){
    this.id++;
    this.userId = userId;
    this.password = password;
    this.nickname = nickname;
  }
}
