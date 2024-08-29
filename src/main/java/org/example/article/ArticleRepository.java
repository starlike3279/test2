package org.example.article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    List<Article> articleList = new ArrayList<>();
    int lastId = 1;

    public int create(String subject, String content) {
        Article article = new Article(lastId, subject, content);
        articleList.add(article);
        lastId++;

        return article.getId();
    }

    public List<Article> findAll() {
        return articleList;
    }

    public Article getFindById(int id) {
        for (Article item : articleList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void remove(Article article) {
        articleList.remove(article);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        article.setSubject(modifySubject);
        article.setContent(modifyContent);
    }
}