package org.example.article;

import org.example.Container;
import org.example.Request;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    private final ArticleService articleService;

    public ArticleController() {
        this.articleService = new ArticleService();
    }

    // 등록
    public void write() {
        System.out.println("제목 : ");
        String title = Container.getSc().nextLine().trim();
        System.out.println("내용 : ");
        String content = Container.getSc().nextLine().trim();

        int id = articleService.create(title, content);
        System.out.printf("%d번 게시글이 등록되었습니다.\n", id);
    }

    // 목록(조회)
    public void list() {
        List<Article> articleList = articleService.findAll();
        System.out.println("번호 / 제목 / 내용");
        System.out.println("------------------");
        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
        }
    }

    // 삭제
    public void delete(Request request) {
        String[] idParams = request.getParams("id");
        List<Integer> ids = getIntParams(idParams);

        if (ids.isEmpty()) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        for (int id : ids) {
            Article article = articleService.getFindById(id);

            if (article == null) {
                System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
            } else {
                articleService.remove(article);
                System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
            }
        }
    }

    // 수정
    public void modify(Request request) {
        // List 형태로 id 값을 여러개 저장
        String[] idParams = request.getParams("id");
        List<Integer> ids = getIntParams(idParams);

        if (ids.isEmpty()) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        for (int id : ids) {
            Article article = articleService.getFindById(id);

            if (article == null) {
                System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                continue;
            }

            System.out.printf("제목(기존) : %s\n", article.getSubject());
            System.out.print("제목 : ");
            String modifySubject = Container.getSc().nextLine().trim();
            System.out.printf("내용(기존) : %s\n", article.getContent());
            System.out.print("내용 : ");
            String modifyContent = Container.getSc().nextLine().trim();

            articleService.modify(article, modifySubject, modifyContent);
            System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
        }
    }

    // id가 1개일때
    private int getIntParam(String id) {
        int defaultValue = -1;
        try {
            return Integer.parseInt(id.replace("id=", ""));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    // id가 2개일때
    private List<Integer> getIntParams(String[] idParams) {
        List<Integer> intIds = new ArrayList<>();
        for (String idStr : idParams) {
            int id = getIntParam(idStr);
            if (id != -1) {
                intIds.add(id);
            }
        }
        return intIds;
    }
}
