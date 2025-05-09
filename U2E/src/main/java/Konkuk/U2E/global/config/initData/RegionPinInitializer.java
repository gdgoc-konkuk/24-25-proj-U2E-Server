package Konkuk.U2E.global.config.initData;

import Konkuk.U2E.domain.news.domain.News;
import Konkuk.U2E.domain.news.domain.NewsPin;
import Konkuk.U2E.domain.news.repository.NewsPinRepository;
import Konkuk.U2E.domain.pin.domain.Pin;
import Konkuk.U2E.domain.pin.domain.Region;
import Konkuk.U2E.domain.pin.repository.PinRepository;
import Konkuk.U2E.domain.pin.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class RegionPinInitializer {
    private final RegionRepository regionRepository;
    private final PinRepository pinRepository;
    private final NewsPinRepository newsPinRepository;
    private final NewsInitializer newsInitializer;
    private final Random random = new Random();

    private final List<List<String>> regionNamesPerNews = List.of(
            List.of("런던", "로스앤젤레스", "대한민국"),
            List.of("인도"),
            List.of("도싯"),
            List.of("데번", "콘월", "뱀프턴"),
            List.of("대한민국", "의성군"),
            List.of("대한민국"),
            List.of("영국"),
            List.of("영국", "데번"),
            List.of("대한민국"),
            List.of("대한민국"),
            List.of("영국", "마스덴", "덴홈"),
            List.of("영국", "인버네스", "쿨더셀"),
            List.of("영국", "볼링"),
            List.of("영국", "샙"),
            List.of("영국", "도싯"),
            List.of("영국", "웨일스"),
            List.of("영국", "북아일랜드"),
            List.of("영국", "스코틀랜드"),
            List.of("미주리", "텍사스", "오클라호마"),
            List.of("컴브리아", "워킹턴")
    );

    private final Map<String, BigDecimal[]> regionCoordinates = Map.ofEntries(
            Map.entry("런던", new BigDecimal[]{new BigDecimal("51.5072"), new BigDecimal("0.1276")}),
            Map.entry("로스앤젤레스", new BigDecimal[]{new BigDecimal("34.0522"), new BigDecimal("118.2437")}),
            Map.entry("대한민국", new BigDecimal[]{new BigDecimal("35.9078"), new BigDecimal("127.7669")}),
            Map.entry("인도", new BigDecimal[]{new BigDecimal("20.5937"), new BigDecimal("78.9629")}),
            Map.entry("도싯", new BigDecimal[]{new BigDecimal("50.7488"), new BigDecimal("2.3445")}),
            Map.entry("데번", new BigDecimal[]{new BigDecimal("50.7184"), new BigDecimal("-3.5339")}),
            Map.entry("콘월", new BigDecimal[]{new BigDecimal("50.2653"), new BigDecimal("-5.0547")}),
            Map.entry("뱀프턴", new BigDecimal[]{new BigDecimal("51.0152"), new BigDecimal("-3.4874")}),
            Map.entry("의성군", new BigDecimal[]{new BigDecimal("36.3526"), new BigDecimal("128.6977")}),
            Map.entry("영국", new BigDecimal[]{new BigDecimal("51.4590"), new BigDecimal("-2.1190")}),
            Map.entry("마스덴", new BigDecimal[]{new BigDecimal("53.6102"), new BigDecimal("-1.9552")}),
            Map.entry("덴홈", new BigDecimal[]{new BigDecimal("53.7940"), new BigDecimal("-1.8950")}),
            Map.entry("인버네스", new BigDecimal[]{new BigDecimal("57.4778"), new BigDecimal("-4.2247")}),
            Map.entry("쿨더셀", new BigDecimal[]{new BigDecimal("57.4547"), new BigDecimal("-4.2252")}),
            Map.entry("볼링", new BigDecimal[]{new BigDecimal("55.9300"), new BigDecimal("-4.4840")}),
            Map.entry("샙", new BigDecimal[]{new BigDecimal("54.5262"), new BigDecimal("-2.6771")}),
            Map.entry("웨일스", new BigDecimal[]{new BigDecimal("51.6563"), new BigDecimal("-3.4261")}),
            Map.entry("북아일랜드", new BigDecimal[]{new BigDecimal("54.6000"), new BigDecimal("-6.7500")}),
            Map.entry("스코틀랜드", new BigDecimal[]{new BigDecimal("56.4907"), new BigDecimal("-4.2026")}),
            Map.entry("미주리", new BigDecimal[]{new BigDecimal("38.5739"), new BigDecimal("-92.6038")}),
            Map.entry("텍사스", new BigDecimal[]{new BigDecimal("31.9686"), new BigDecimal("-99.9018")}),
            Map.entry("오클라호마", new BigDecimal[]{new BigDecimal("35.4676"), new BigDecimal("-97.5164")}),
            Map.entry("컴브리아", new BigDecimal[]{new BigDecimal("54.5770"), new BigDecimal("-2.7975")}),
            Map.entry("워킹턴", new BigDecimal[]{new BigDecimal("54.6422"), new BigDecimal("-3.5445")})
    );

    public void initializeRegionsAndPins() {
        List<News> newsList = newsInitializer.getNewsList();

        for (int i = 0; i < newsList.size(); i++) {
            News news = newsList.get(i);

            for (String regionName : regionNamesPerNews.get(i)) {
                BigDecimal[] coords = regionCoordinates.get(regionName);

                Region region = Region.builder()
                        .name(regionName)
                        .latitude(coords[0])
                        .longitude(coords[1])
                        .build();
                regionRepository.save(region);

                Pin pin = Pin.builder()
                        .region(region)
                        .build();
                pinRepository.save(pin);

                NewsPin newsPin = NewsPin.builder()
                        .news(news)
                        .pin(pin)
                        .build();
                newsPinRepository.save(newsPin);
            }
        }
    }
}
