package Konkuk.U2E.config.initData;

import Konkuk.U2E.domain.news.domain.Climate;
import Konkuk.U2E.domain.news.domain.ClimateProblem;
import Konkuk.U2E.domain.news.domain.News;
import Konkuk.U2E.domain.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NewsInitializer {
    private final NewsRepository newsRepository;

    private final List<String> urls = List.of(
            "https://www.bbc.com/news/articles/cx265w8v16qo", "https://www.bbc.com/news/articles/c5yl5g58k17o", "https://www.bbc.com/news/articles/cg41y4krxvno"
    );

    private final List<String> imageUrls = List.of(
            "https://ichef.bbci.co.uk/news/1536/cpsprodpb/dc84/live/c1272b10-0f08-11f0-ac9f-c37d6fd89579.png.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/c59e/live/2fc21290-0eb6-11f0-aabc-a51f61430e55.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/610b/live/c73b11b0-0e13-11f0-ac9f-c37d6fd89579.jpg.webp"

    );

    private final List<String> titles = List.of(
            "영국 기상청 경고 이후, 산불 주의 촉구", "인도 기상청, 올여름 강력한 폭염 경고", "건조한 날씨 속 들불 경고 발령"
    );

    private final List<String> bodies = List.of(
            "영국 기상청이 산불 위험에 대한 앰버(주황) 경보를 발령하자, 런던 소방대는 시민들에게 각별한 주의를 당부했다. 최근 비록 여름처럼 높은 기온은 아니지만 봄철의 건조한 날씨로 인해 잔디, 관목, 쓰레기 등에 작은 불씨만으로도 산불이 발생할 수 있으며, 불길은 순식간에 확산될 수 있다. 런던 소방대의 폴 맥코트는 로스앤젤레스와 한국의 사례를 언급하며, 온도가 높지 않아도 야외에서는 불이 빠르게 번질 수 있음을 경고했다. 그는 시민들에게 야외나 발코니에서 바비큐를 하지 말고, 쓰레기를 올바르게 처리하며, 담배꽁초를 조심히 버릴 것을 요청했다. 기상청의 기상학자 캐서린 초크는 강한 바람과 계속되는 건조한 날씨가 산불 발생 가능성을 높이고 있다고 설명했으며, 현재 영국 전역, 특히 런던 지역에 앰버 경보가 발효 중이다. 이번 주 금요일에는 기온이 섭씨 22도까지 오를 것으로 예상된다.",
            "인도 기상청은 올해 인도 전역에서 평년보다 높은 기온과 더 많은 폭염 일수가 나타날 것이라고 경고했다. 이미 2월부터 일부 지역에서는 최저기온이 평년보다 13도 높았으며, 여름철인 4월부터 6월까지는 북부, 동부, 중부, 북서부 평야 지역에서 평년보다 24일 더 많은 폭염이 예상된다. 특히 우타르프라데시, 자르칸드, 차티스가르, 오디샤 등은 10~11일의 폭염이 발생할 수 있다. 2024년에는 라자스탄의 추루에서 최고기온 50.5도를 기록했으며, 보건부는 3월부터 6월 사이 폭염으로 143명이 사망했다고 발표했으나, 독립 보고서에 따르면 실제로는 733명이 열사병으로 사망한 것으로 추정된다. 기상청은 인구 증가, 산업화, 교통 증가 등 인간 활동으로 인한 온실가스 배출이 폭염을 악화시키고 있으며, 인도는 세계 3위의 온실가스 배출국으로서 여전히 석탄 발전에 크게 의존하고 있다고 지적했다.",
            "영국 도싯(Dorset)과 윌트셔(Wiltshire) 지역에 건조한 날씨가 지속됨에 따라 들불(산불) 위험이 증가하면서 앰버(주황) 경보가 발령됐다. 도싯 및 윌트셔 소방구조대(DWFRS)는 시민들에게 일회용 바비큐 사용 금지, 야영지 불피우기 금지, 담배 꽁초 주의 등을 당부했다. 이 경고는 올해 들어 두 번째로 발령된 것으로, 이번 주 내내 유지될 예정이다. 기상 예보에 따르면 4월 초까지 비 예보가 없으며, 이에 따라 산불 위험은 더욱 커질 전망이다. 실제로 2020년 5월에는 일회용 바비큐로 인해 발생한 산불이 워햄 숲(Wareham Forest)의 220헥타르를 태우며 2주 넘게 지속된 바 있다. 이후 해당 지역에는 **공공장소보호명령(PSPO)**이 도입됐으며, 현재는 들판, 초지, 산림 지역에서 바비큐, 랜턴, 불꽃놀이, 담배 투기 행위 등을 한 사람에게 최대 100파운드의 벌금을 부과하는 규제를 확대하는 방안이 검토 중이다. 이에 대한 공청회는 4월 20일까지 진행된다."

    );

    private final List<LocalDate> dates = List.of(
            LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 1)

    );

    private final List<List<ClimateProblem>> problems = List.of(
            List.of(ClimateProblem.WILDFIRE),
            List.of(ClimateProblem.TEMPERATURE_RISE),
            List.of(ClimateProblem.WILDFIRE)

    );


    public void initializeNews() {
        for (int i = 0; i < titles.size(); i++) {
            News news = News.builder()
                    .newsUrl(urls.get(i))
                    .imageUrl(imageUrls.get(i))
                    .newsTitle(titles.get(i))
                    .newsBody(bodies.get(i))
                    .newsDate(dates.get(i))
                    .build();

            List<Climate> climates = problems.get(i).stream()
                    .map(problem -> new Climate(problem, news))
                    .toList();

            news.setClimateList(climates);

            newsRepository.save(news);
        }
    }

}