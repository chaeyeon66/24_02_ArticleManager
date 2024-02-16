package com.KoreaIT.java.AM.dto;

public class User extends Dto{
  public int id;
  public String userId;
  public String password;
  public String nickname;

  public User(int id ,String userId, String password, String nickname, String regDate){
    this.id = id;
    this.userId = userId;
    this.password = password;
    this.nickname = nickname;
    this.regDate = regDate;
  }
}
