package org.example;

import org.example.article.ArticleController;
import org.example.system.SystemController;

public class App {
    // CRUD 동작
    ArticleController articleController;
    SystemController systemController;

    App() {
        articleController = new ArticleController();
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 게시판 앱 ==");
        while (true) {
            System.out.println("명령) ");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                articleController.write();
            } else if (command.equals("목록")) {
                articleController.list();
            } else if (command.startsWith("삭제")) {
                articleController.delete(request);
            } else if (command.startsWith("수정")) {
                articleController.modify(request);
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        systemController.exit();
    }
}
