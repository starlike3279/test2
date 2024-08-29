package org.example.article;

import org.example.Container;
import org.example.Request;

import java.util.List;

public class ArticleController {

    ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void write() {
        System.out.print("제목 : ");
        String subject = Container.getSc().nextLine().trim();
        System.out.print("내용 : ");
        String content = Container.getSc().nextLine().trim();

        //
        int id = articleService.create(subject, content);

        System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
    }

    public void list() {
        List<Article> articleList = articleService.findAll();
        System.out.println("번호 / 제목 / 내용");
        System.out.println("----------------------");
        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
        }
    }

    public void delete(Request request) {
        int id = _getIntParam(request.getParams("id"));


        if (id == -1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        Article article = this.articleService.getFindById(id);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
        } else {
            articleService.remove(article);
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
        }
    }

    public void modify(Request request) {
        int id = _getIntParam(request.getParams("id"));

        if (id == -1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        Article article = articleService.getFindById(id);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
        } else {

            System.out.printf("제목(기존) : %s\n", article.getSubject());
            System.out.print("제목 : ");
            String modifySubject = Container.getSc().nextLine();

            System.out.printf("내용(기존) : %s\n", article.getContent());
            System.out.print("내용 : ");
            String modifyContent = Container.getSc().nextLine();

            articleService.modify(article, modifySubject, modifyContent);

            System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
        }
    }

    private int _getIntParam(String id) {
        int defaultValue = -1;

        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}