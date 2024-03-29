package com.KoreaIT.java.AM.dto;

public class Article extends Dto{
  public int viewCount;
  public String title;
  public String content;
  public Article(int id, String title, String content, String regDate) {
    this(id, title, content, regDate, 0);
  }

  public Article(int id, String title, String content, String regDate, int viewCount) {
    this.id = id;
    this.title =title;
    this.content = content;
    this.regDate = regDate;
    this.viewCount = viewCount;
  }

  public  void increaseViewCnt(){
    viewCount++;
  }
}
