package Konkuk.U2E.global.config.initData;

import Konkuk.U2E.domain.comment.domain.Comment;
import Konkuk.U2E.domain.comment.repository.CommentRepository;
import Konkuk.U2E.domain.news.domain.News;
import Konkuk.U2E.domain.user.domain.User;
import Konkuk.U2E.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class CommentUserInitializer {
    private final NewsInitializer newsInitializer;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    private final Random random = new Random();

    private final List<String> usernames = List.of(
            "홍길동", "김철수", "이영희", "박지민", "정우성",
            "한지민", "이민호", "김태희", "유재석", "아이유"
    );

    private final List<String> comments = List.of(
            "정말 충격적인 기사네요.", "이런 일이 다시는 없었으면 좋겠어요.",
            "기후 변화가 이렇게 심각한 줄 몰랐네요.", "좋은 정보 감사합니다!",
            "정부의 대응이 아쉽습니다.", "더 많은 대책이 필요해 보여요.",
            "지역 주민들이 걱정되네요.", "이런 뉴스가 더 많이 알려져야 해요.",
            "환경 보호의 중요성을 느낍니다.", "다들 조심하세요!"
    );

    public void initializeUsersAndComments() {
        List<News> newsList = newsInitializer.getNewsList();

        for (int i = 0; i < newsList.size(); i++) {
            News news = newsList.get(i);

            User user1 = userRepository.save(
                    User.builder()
                            .name(usernames.get((i * 2) % usernames.size()))
                            .password("test1234")
                            .news(news)
                            .build()
            );

            User user2 = userRepository.save(
                    User.builder()
                            .name(usernames.get((i * 2 + 1) % usernames.size()))
                            .password("test1234")
                            .news(news)
                            .build()
            );

            commentRepository.save(
                    Comment.builder()
                            .contents(comments.get((i * 2) % comments.size()))
                            .news(news)
                            .user(user1)
                            .build()
            );

            commentRepository.save(
                    Comment.builder()
                            .contents(comments.get((i * 2 + 1) % comments.size()))
                            .news(news)
                            .user(user2)
                            .build()
            );
        }
    }
}
