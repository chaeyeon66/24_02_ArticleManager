package com.KoreaIT.java.AM;

import com.KoreaIT.java.AM.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  private static List<Article> articles;
  static{
    articles = new ArrayList<>();
  }
  public  void start(){
    System.out.println("== 프로그램 시작 ==");
    makeTestData();

    Scanner sc = new Scanner(System.in);

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
          System.out.print("번호 | ");
          System.out.print("제목\n");
          for(int i = articles.size() -1; i>=0; i--){
            System.out.printf("%d | ",articles.get(i).id);
            System.out.printf("%s \n",articles.get(i).title);
          }
        }

      }else if(cmd.equals("article write")){
        int id = articles.size() + 1;
        String regDate = Util.getNowDateStr();
        System.out.print("제목 : ");
        String title = sc.nextLine();
        System.out.print("내용 : ");
        String content = sc.nextLine();
        Article article = new Article(id, title, content, regDate);
        articles.add(article);

        System.out.printf("%d번 글이 생성 되었습니다.\n",id);

      }else if(cmd.startsWith("article detail ")){
        String[] cmds = cmd.split(" ");

        if(cmds.length < 3){
          System.out.println("게시글의 번호를 입력해주세요");
          continue;
        }
        if(cmds.length >= 4){
          System.out.println("다른 불필요한 정보 없이 게시글의 번호만 입력해주세요");
          continue;
        }

        int id = Integer.parseInt(cmds[2]);
        Article foundArticle = getArticlebyID(id);
        /*
        String id = cmds[2];
        Article foundArticle = null;
        for(int i =0; i< articles.size(); i++){
          if(articles.get(i).id == Integer.parseInt(id)){
            Article article = articles.get(i);
            foundArticle = article;
            break;
          }
        }*/

        if(foundArticle == null){
          System.out.printf("%d번 게시물은 존재하지 않습니다.\n",id);
        }else{
          foundArticle.increaseViewCnt();
          System.out.printf("번호 : %d\n",foundArticle.id);
          System.out.printf("제목 : %s\n",foundArticle.title);
          System.out.printf("내용 : %s\n",foundArticle.content);
          System.out.printf("날짜 : %s\n",foundArticle.regDate);
          System.out.printf("조회수 : %s\n",foundArticle.viewCount);
        }

      }else if(cmd.startsWith("article delete ")){
        String[] cmds = cmd.split(" ");

        if(cmds.length < 3){
          System.out.println("게시글의 번호를 입력해주세요");
          continue;
        }
        if(cmds.length >= 4){
          System.out.println("다른 불필요한 정보 없이 게시글의 번호만 입력해주세요");
          continue;
        }

        int id = Integer.parseInt(cmds[2]);
        Article foundArticle = getArticlebyID(id);
        /*for(int i =0; i< articles.size(); i++){
          if(articles.get(i).id == id){
            Article article = articles.get(i);
            foundArticle = article;
            break;
          }
        }*/
        if(foundArticle == null){
          System.out.printf("%d번 게시물은 존재하지 않습니다.\n",id);
        }else{
          articles.remove(foundArticle);
          System.out.printf("%d번 게시물이 삭제되었습니다.\n",id);
        }
      }else if(cmd.startsWith("article modify ")){
        String[] cmds = cmd.split(" ");

        if(cmds.length < 3){
          System.out.println("게시글의 번호를 입력해주세요");
          continue;
        }
        if(cmds.length >= 4){
          System.out.println("다른 불필요한 정보 없이 게시글의 번호만 입력해주세요");
          continue;
        }

        int id = Integer.parseInt(cmds[2]);
        Article foundArticle = getArticlebyID(id);
        /*
        String id = cmds[2];
        Article foundArticle = null;
        for(int i =0; i< articles.size(); i++){
          if(articles.get(i).id == Integer.parseInt(id)){
            Article article = articles.get(i);
            foundArticle = article;
            break;
          }
        }*/
        if(foundArticle == null){
          System.out.printf("%d번 게시물은 존재하지 않습니다.\n",id);
        }else{
          System.out.print("제목 : ");
          String title = sc.nextLine();
          System.out.print("내용 : ");
          String content = sc.nextLine();
          foundArticle.title = title;
          foundArticle.content = content;
          System.out.printf("%s번 게시물이 수정되었습니다.\n",id);
        }

      }else{
        System.out.println("존재하지 않는 명령어입니다.");
      }
    }

    sc.close();

    System.out.println("== 프로그램 종료 ==");
  }

  private static void makeTestData() {
    System.out.println("게시글 테스트 데이터를 생성합니다.");
    articles.add(new Article(1,"t1","b1",Util.getNowDateStr(),11));
    articles.add(new Article(2,"t2","b2",Util.getNowDateStr(),12));
    articles.add(new Article(3,"t3","b3",Util.getNowDateStr(),436));
  }

  public static Article getArticlebyID(int id) {
    Article foundArticle = null;
    for (int i = 0; i < articles.size(); i++) {
      if (articles.get(i).id == id) {
        Article article = articles.get(i);
        foundArticle = article;
        break;
      }
    }
    return foundArticle;
  }
}
