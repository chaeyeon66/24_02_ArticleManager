package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("== 프로그램 시작 ==");

    Scanner sc = new Scanner(System.in);
    List<Article> articles = new ArrayList<>();

    int lastArticleId = 0;
    while(true){
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine().trim();

      if(cmd.length() == 0){
        System.out.println("명령어를 입력하세요");
        continue;
      }

      if(cmd.equals("system exit")) {
        break;
      }

      if(cmd.equals("article list")) {
        if(articles.size() == 0) {
          System.out.println("게시글이 없습니다.");
        }else{
          System.out.println("게시글이 있습니다.");
        }

      }else if(cmd.equals("article write")){
        lastArticleId++;
        System.out.print("제목 : ");
        String title = sc.nextLine();
        System.out.print("내용 : ");
        String content = sc.nextLine();

        Article article = new Article(lastArticleId, title, content);
        articles.add(article);

        System.out.printf("%d번 글이 생성 되었습니다.\n",lastArticleId);

      }else{
        System.out.println("존재하지 않는 명령어입니다.");
      }
    }

    sc.close();

    System.out.println("== 프로그램 종료 ==");
  }
}

class Article{
  int id;
  String title;
  String content;

  public Article(int id, String title, String content) {
    this.id = id;
    this.title =title;
    this.content = content;
  }
}
