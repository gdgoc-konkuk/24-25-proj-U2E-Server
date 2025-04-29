package Konkuk.U2E.config.initData;

import Konkuk.U2E.domain.news.domain.Climate;
import Konkuk.U2E.domain.news.domain.ClimateProblem;
import Konkuk.U2E.domain.news.domain.News;
import Konkuk.U2E.domain.news.repository.NewsRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Konkuk.U2E.domain.news.domain.ClimateProblem.*;

@Component
@RequiredArgsConstructor
@Getter
public class NewsInitializer {
    private final NewsRepository newsRepository;
    private final List<News> newsList = new ArrayList<>();

    private final List<String> urls = List.of(
            "https://www.bbc.com/news/articles/cx265w8v16qo", "https://www.bbc.com/news/articles/c5yl5g58k17o", "https://www.bbc.com/news/articles/cg41y4krxvno",
            "https://www.bbc.com/news/articles/cgkgyz0444ko", "https://www.bbc.com/news/articles/c4g3e35y3qqo", "https://www.bbc.com/news/articles/c5y214x9lw1o",
            "https://www.bbc.com/news/articles/c1lp365pd1go", "https://www.bbc.com/news/articles/c62kp3dk17lo", "https://www.bbc.com/news/articles/cnvz8ljzz8ro",
            "https://www.bbc.com/news/articles/cdx2801qegvo", "https://www.bbc.com/news/articles/crmjr3xz2kyo", "https://www.bbc.com/news/articles/c4gm3917pgyo",
            "https://www.bbc.com/news/articles/c86p2n6ggx5o", "https://www.bbc.com/news/articles/cm2y082ekydo", "https://www.bbc.com/news/articles/ckg10yqzez9o",
            "https://www.bbc.com/news/articles/clynpywddr1o", "https://www.bbc.com/news/articles/ckg84x797q8o", "https://www.bbc.com/news/articles/c8d487epdl9o",
            "https://www.bbc.com/news/articles/cevx7lkznm1o", "https://www.bbc.com/news/articles/cly6gn134jvo"
    );

    private final List<String> imageUrls = List.of(
            "https://ichef.bbci.co.uk/news/1536/cpsprodpb/dc84/live/c1272b10-0f08-11f0-ac9f-c37d6fd89579.png.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/c59e/live/2fc21290-0eb6-11f0-aabc-a51f61430e55.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/610b/live/c73b11b0-0e13-11f0-ac9f-c37d6fd89579.jpg.webp",
            "https://ichef.bbci.co.uk/news/1536/cpsprodpb/59d2/live/7d553c60-0d78-11f0-a1c5-cd0d1898b025.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/cdef/live/c2dec910-0d3a-11f0-b1c8-05eb2b6add27.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/39cb/live/2b01f1c0-0aed-11f0-94d4-6f954f5dcfa3.png.webp",
            "https://ichef.bbci.co.uk/news/1536/cpsprodpb/813d/live/b13d3b60-0a10-11f0-a457-1fbea9af81fd.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/a5f7/live/d942b390-b25b-11ef-abc8-5d4f677f13f2.png.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/e546/live/7d9b7c10-03d3-11f0-9b36-09a73999182b.jpg.webp",
            "", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/a79c/live/09987040-0679-11f0-8777-f3a97186d396.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/4a45/live/869a9d10-0652-11f0-996d-45b3433501bf.jpg.webp",
            "https://ichef.bbci.co.uk/news/1536/cpsprodpb/a2c8/live/87508430-05d1-11f0-8751-a7ef8f090311.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/6c34/live/05469cd0-057d-11f0-88b7-5556e7b55c5e.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/ea25/live/17724120-057d-11f0-8380-1b78bad7f910.jpg.webp",
            "https://ichef.bbci.co.uk/news/1536/cpsprodpb/56e7/live/18255e30-04b1-11f0-88b7-5556e7b55c5e.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/39a7/live/0a4c2470-04fb-11f0-b61c-853344875b4d.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/ad14/live/c2742650-03f8-11f0-88b7-5556e7b55c5e.jpg.webp",
            "https://ichef.bbci.co.uk/news/1536/cpsprodpb/117d/live/109d0ed0-026b-11f0-b50e-9d086302645f.jpg.webp", "https://ichef.bbci.co.uk/news/1536/cpsprodpb/1879/live/1332fc30-ff5b-11ef-ac3e-f94317684f61.jpg.webp"

    );

    private final List<String> titles = List.of(
            "영국 기상청 경고 이후, 산불 주의 촉구", "인도 기상청, 올여름 강력한 폭염 경고", "건조한 날씨 속 들불 경고 발령",
            "데번과 콘월의 홍수 방지 사업, 정부 기금 지원 확대", "한국 산불, 조상 묘 돌보던 남성 방화 혐의로 조사 중", "한국, 산불 속 생명과 유산 구하기 위한 사투",
            "한국 역사상 최악의 산불로 최소 24명 사망", "홍수 방지를 위한 새 하수 저장 탱크, 윌트셔 칩넘에 설치 완료", "폭풍으로 쓰러진 나무들, 자연 생태계 복원에 도움",
            "한국 산불로 최소 2명 사망…전국 재난 사태 선포", "15개 소방대, 영국 마스덴 황야 산불 진압에 투입", "스코틀랜드 전역 '극심한 위험' 경고 속, 인버네스 인근에서 산불 발생",
            "극심한' 산불 경고 발효 중, 스코틀랜드 웨스트 던바튼셔 산불 진화", "영국 커브리아 첫 산불 ‘더 큰 재앙 될 뻔’… 소방대, 관리 부재 경고", "도싯, 산불 방지 위해 PSPO 확대 추진…불씨 행위 단속 강화",
            "3400만 파운드 투입… 웨일스 탄광 슬래그 붕괴 위험에 대응", "북아일랜드, 산불 위험 ‘호박 경보’ 발령… 최근 무어산 화재 여파", "스코틀랜드 전역에 ‘극심한’ 산불 경고…건조한 날씨 속 주민 주의 당부",
            "미국 남부, 토네이도·먼지 폭풍으로 최소 34명 사망… 수백 채 피해·산불 확산", "스톰 에오윈 이후 통신 두절… 영국 농촌 지역, 연결성 개선 요구"
    );

    private final List<String> bodies = List.of(
            "영국 기상청이 산불 위험에 대한 앰버(주황) 경보를 발령하자, 런던 소방대는 시민들에게 각별한 주의를 당부했다. 최근 비록 여름처럼 높은 기온은 아니지만 봄철의 건조한 날씨로 인해 잔디, 관목, 쓰레기 등에 작은 불씨만으로도 산불이 발생할 수 있으며, 불길은 순식간에 확산될 수 있다. 런던 소방대의 폴 맥코트는 로스앤젤레스와 한국의 사례를 언급하며, 온도가 높지 않아도 야외에서는 불이 빠르게 번질 수 있음을 경고했다. 그는 시민들에게 야외나 발코니에서 바비큐를 하지 말고, 쓰레기를 올바르게 처리하며, 담배꽁초를 조심히 버릴 것을 요청했다. 기상청의 기상학자 캐서린 초크는 강한 바람과 계속되는 건조한 날씨가 산불 발생 가능성을 높이고 있다고 설명했으며, 현재 영국 전역, 특히 런던 지역에 앰버 경보가 발효 중이다. 이번 주 금요일에는 기온이 섭씨 22도까지 오를 것으로 예상된다.",
            "인도 기상청은 올해 인도 전역에서 평년보다 높은 기온과 더 많은 폭염 일수가 나타날 것이라고 경고했다. 이미 2월부터 일부 지역에서는 최저기온이 평년보다 13도 높았으며, 여름철인 4월부터 6월까지는 북부, 동부, 중부, 북서부 평야 지역에서 평년보다 24일 더 많은 폭염이 예상된다. 특히 우타르프라데시, 자르칸드, 차티스가르, 오디샤 등은 10~11일의 폭염이 발생할 수 있다. 2024년에는 라자스탄의 추루에서 최고기온 50.5도를 기록했으며, 보건부는 3월부터 6월 사이 폭염으로 143명이 사망했다고 발표했으나, 독립 보고서에 따르면 실제로는 733명이 열사병으로 사망한 것으로 추정된다. 기상청은 인구 증가, 산업화, 교통 증가 등 인간 활동으로 인한 온실가스 배출이 폭염을 악화시키고 있으며, 인도는 세계 3위의 온실가스 배출국으로서 여전히 석탄 발전에 크게 의존하고 있다고 지적했다.",
            "영국 도싯(Dorset)과 윌트셔(Wiltshire) 지역에 건조한 날씨가 지속됨에 따라 들불(산불) 위험이 증가하면서 앰버(주황) 경보가 발령됐다. 도싯 및 윌트셔 소방구조대(DWFRS)는 시민들에게 일회용 바비큐 사용 금지, 야영지 불피우기 금지, 담배 꽁초 주의 등을 당부했다. 이 경고는 올해 들어 두 번째로 발령된 것으로, 이번 주 내내 유지될 예정이다. 기상 예보에 따르면 4월 초까지 비 예보가 없으며, 이에 따라 산불 위험은 더욱 커질 전망이다. 실제로 2020년 5월에는 일회용 바비큐로 인해 발생한 산불이 워햄 숲(Wareham Forest)의 220헥타르를 태우며 2주 넘게 지속된 바 있다. 이후 해당 지역에는 **공공장소보호명령(PSPO)**이 도입됐으며, 현재는 들판, 초지, 산림 지역에서 바비큐, 랜턴, 불꽃놀이, 담배 투기 행위 등을 한 사람에게 최대 100파운드의 벌금을 부과하는 규제를 확대하는 방안이 검토 중이다. 이에 대한 공청회는 4월 20일까지 진행된다.",
            "영국 환경청(Environment Agency)은 영국 남서부의 데번(Devon)과 콘월(Cornwall) 지역에 약 3,300만 파운드(한화 약 560억 원) 규모의 홍수 방지 사업 자금을 지원한다고 발표했다. 이 자금은 해당 지역 내 70개의 홍수 관련 사업에 투입되며, 이를 통해 27,000여 개의 주택과 상업 시설이 보호될 것으로 기대된다. 이외에도 엑스머스(Exmouth), 뱀프턴(Bampton), 헬스턴(Helston) 등도 침수, 해안 침식, 표면수 범람 등에 대비한 보호 대상 지역으로 지정되었다. 이번 예산에 포함되지 않은 사업에 대해서도 환경청은 지역 자치단체 및 홍수 대응 그룹과 협력해 위험 완화 노력을 지속할 계획이다.",
            "한국 경상북도 의성군의 한 야산에서 조상 묘를 돌보던 56세 남성이 대형 산불의 원인으로 지목되어 수사받고 있다. 이 남성은 성묘 중 나뭇가지를 라이터로 태우려다 불이 번졌다는 의혹을 받고 있으며, 현재 입건되었으나 구속은 되지 않았다. 그의 딸은 아버지가 무성하게 자란 가지를 태우려다 불이 시작됐다고 진술한 것으로 전해졌다. 불길은 건조한 날씨와 강풍, 소나무 위주의 산림, 평년보다 따뜻한 기온 등으로 인해 빠르게 확산되었다. 경찰, 소방청, 산림청이 합동 수사를 진행 중이며, 정부는 이재민들을 위한 재정 지원을 약속했다.",
            "한국 남동부 산청군에서 시작된 사상 최악의 산불이 10여 개 시·군으로 번지며 현재까지 27명이 사망, 32명이 부상한 가운데, 소방대원들이 생명과 문화재 보호를 위해 총력 대응 중이다. 피해자 대부분은 60~70대 고령자이며, 의성, 안동, 청송 등으로 불길이 번졌다. 고운사는 이미 전소되었고, 조선시대 국보급 불교 건축물과 유네스코 세계유산인 하회마을, 병산서원도 위협받고 있다. 문화재로부터 목판, 불화 등 유물은 긴급 대피 조치되었다. 정부의 재난대응본부 이한경 국장은 기후위기의 현실을 지금처럼 뚜렷이 목격한 적은 없다고 밝히며 기후 변화와 인간 활동이 겹쳐 참사를 키운 상황이라고 강조했다.",
            "2025년 3월 말, 한국 남동부 지역에서 발생한 초대형 산불로 인해 현재까지 최소 24명이 사망, **26명이 부상(이 중 12명은 중상)**을 입었으며, 23,000명 이상이 대피했다. 산불은 3월 21일 산청군에서 시작되어 의성군, 경북, 안동, 청송, 영양 등지로 확산되었다. 건조한 기후와 강풍이 불길을 키우며, 국가재난 대응단계는 최고 단계로 격상되었고, 소방관 수천 명과 군 병력 5천 명, 미군 헬기까지 동원되었다. 의성에서는 헬기 한 대가 추락해 조종사가 사망했다. 기상청은 비 예보가 거의 없어 진화에 어려움이 있다고 밝혔고, 정부는 불법 소각 등 개인의 부주의 단속을 강화할 것을 약속했다. 올해 발생한 산불은 총 244건으로 전년도 같은 시기보다 2.4배 증가한 수치이다. 한덕수 대통령 권한대행은 “이번 산불은 한국 역사상 가장 치명적인 재난이며, 전례 없는 기록을 쓰고 있다”고 밝혔다.",
            "2024년 11월, 영국 윌트셔(Wiltshire)의 칩넘(Chippenham)은 **스톰 버트(Storm Bert)**로 인해 **에이번 강(River Avon)**이 범람하며 큰 홍수 피해를 입었다. 이를 계기로 2백만 파운드(약 34억 원) 규모의 홍수 방지 프로젝트가 시행되어, 25만 리터 용량의 저장 탱크가 지하에 설치되었다. 이 탱크는 폭우로 인한 하수도 범람을 줄이기 위한 추가 용량 확보를 목적으로 한다. 이 프로젝트는 YTL 그룹 산하의 Wessex Water가 주도했으며, 2025년부터 2030년까지 5억 8천만 파운드 투자를 통해 ▲우수 범람 감소, ▲자연 기반 솔루션 도입, ▲빗물 관리 개선 등을 추진할 계획이다. 다만, Wessex Water는 규제 기관 Ofwat이 승인한 5개년 투자 예산이 자사 요구 대비 17% 부족하다며, 이에 대해 **경쟁시장감시국(CMA)**의 재검토를 요청한 상태이다.",
            "2024년 12월, **스톰 대러(Storm Darragh)**로 인해 **영국 데번(Devon) 주의 엑스무어 국립공원(Exmoor National Park)**에 강풍(최고 시속 약 142km)이 몰아치면서 다수의 나무가 쓰러졌지만, 이 나무들이 지역 생태계에 긍정적 영향을 주고 있다는 분석이 나왔다. 엑스무어 국립공원 관리청(ENPA)은 죽은 나무와 쓰러진 나무들이 곤충, 조류, 박쥐, 버섯 등 생물들의 서식처로 변하면서 자연 생물다양성 회복에 기여하고 있다고 밝혔다. 공원 측은 단순히 나무를 많이 심는 것보다 기후 회복력, 홍수 관리, 멸종 위기종 보호, 희귀 이끼 서식지 확보 등 ‘기후 적응형 숲 관리’가 핵심 전략이라고 강조했다.",
            "2025년 3월 23일, 대한민국 남동부에서 대형 산불이 발생해 소방관 2명이 사망하고, 수백 명이 대피했다. **경남 산청군(Sancheong)**에서는 소방관 2명이 숨졌고, 2명이 실종 상태이다. 산불은 전국 여러 지역으로 확산되고 있으며, 산림청은 12곳에 '심각 단계' 산불 경보를 발령했다. 오후 6시, 정부는 울산광역시와 경북·경남 지역에 국가 재난 사태를 선포했다. 산청군 8개 마을의 주민 200여 명, 경북 의성군에서는 400여 명 이상이 긴급 대피했다. 산불 현장 인근은 서울에서 약 250km 떨어져 있으며, 강한 바람으로 진화 작업이 매우 어렵다고 당국은 밝혔다. 최상목 대통령 권한대행은 “해가 지기 전까지 전력을 다해 불길을 잡아야 한다”고 강조했으나, 강풍으로 인해 진화 작업은 난항을 겪고 있다.",
            "2025년 3월 21일 금요일 오후 1시 30분(현지 시간), **영국 웨스트요크셔(West Yorkshire) 마스덴(Marsden) 지역의 황야 지대(Moorland)**에서 대형 산불이 발생해 15개 소방대와 지원 부대가 투입되었다. 화재는 March Haigh 저수지 인근에서 시작되었으며, 6마일(10km) x 3마일(5km) 규모로 번져 그레이터 맨체스터(Greater Manchester) 방향인 덴홈(Denholme) 지역으로 확산되었다. 오후 7시 20분경, 소방대는 대부분 철수했으나, 4개의 펌프팀은 여전히 남아 건물 보호에 주력 중이다. 현재까지 인명 피해는 보고되지 않았다. 화재 원인은 아직 조사 중이다.",
            "2025년 3월 21일, 스코틀랜드 인버네스(Inverness) 인근의 건조한 풀밭 지역에서 대형 산불이 발생했다. 지난 일주일간 건조하고 화창한 날씨가 지속되면서 **스코틀랜드 전역의 저지대 지역에 ‘극심한 산불 위험 경고’**가 내려진 상황이었다. 소방당국은 현재까지 불길을 대부분 통제했으며, 인명 피해는 보고되지 않았다고 전했다. 이번 화재는 불씨 방치, 캠프파이어, 바비큐, 담배꽁초, 유리병 등의 부주의와 건조하고 따뜻한 날씨, 강풍, 낮은 습도가 결합된 결과로 발생한 것으로 보인다. 스코틀랜드 소방구조청(SFRS)은 **“산불은 통제할 수 없고 예측 불가능한 자연재해이며, 특히 봄철과 가을철의 건조한 날씨에는 각별한 주의가 필요하다”**고 경고했다.",
            "2025년 3월 21일, 스코틀랜드 전역의 저지대 지역에 ‘극심한 산불 위험’ 경보가 발효된 가운데, 웨스트 던바튼셔(West Dunbartonshire) 지역 **웨스트 킬패트릭 힐(West Kilpatrick Hills)**에서 발생한 산불이 진화되었다. 화재 발생 시점에 Bowling 인근 주택에서는 불길이 육안으로 보일 정도였으며, 기온이 18도까지 상승할 것으로 예상됨에 따라, 화재 위험도는 화요일 ‘매우 높음’에서 금요일 ‘극심’ 단계로 상향 조정되었다. 이는 기상 조건과 건조한 지면 상태가 산불 확산을 쉽게 만드는 ‘화약고’ 환경을 조성하고 있음을 나타낸다.",
            "2025년 3월 19일, **영국 커브리아(Cumbria) 주 샙(Shap) 서쪽의 랄프랜드 커먼(Ralfland Common)**에서 발생한 올해 첫 산불에 대해 소방 당국은 **“훨씬 더 큰 피해가 날 수도 있었다”**며 우려를 표했다. 화재는 약 100m x 300m(328ft x 984ft)의 면적을 태웠으며, 샙과 페너리스(Penrith) 소방대가 출동, 현지 농민들의 협조로 현장까지 이동, 비터(beater)와 휴대용 소화기를 사용해 불을 진압했다. 다행히 인명 피해는 없었다. **샙 소방서(Shap Fire Station)**는 “커브리아 고지대의 최근 수년간의 산림 관리 부재로 인해 죽은 식생(dead vegetation)이 쌓이며 산불 위험이 증가하고 있다”고 경고했다. 이어 “현재의 고사 지대는 자연 보호나 환경 개선에 도움이 되기는커녕 심각한 위험 요소로 작용하고 있다”고 덧붙였다.",
            "영국 도싯(Dorset) 지역에서는 산불 예방을 위한 법적 규제 강화 방안이 추진 중이다. 현재 일부 지역(예: 워햄 숲 Wareham Forest)에 적용 중인 **공공장소보호명령(PSPO, Public Space Protection Order)**을 확대해, 더 많은 자연 보호구역과 해변 지역에 적용하는 방안이 도싯 카운슬(Dorset Council) 주도로 논의되고 있다. 이 명령이 적용되면, 야외에서 바비큐·랜턴·불꽃놀이 사용 또는 담배꽁초 투기 시 £100 벌금이 부과되며, 소방위험 물품 압수도 가능하다. 도싯의 환경·주택 담당 의원 길 테일러(Gill Taylor)는 이 명령은 자연 보호와 주민·관광객의 안전을 위한 필수 조치라며, **4월 20일까지 대중 의견 수렴(공청회)**이 진행될 예정이라고 밝혔다.",
            "웨일스 전역에 흩어진 오래된 탄광 폐석더미(Coal Tips)의 붕괴 위험에 대비하기 위해, 웨일스 정부가 **3,400만 파운드(약 585억 원)**를 투자하기로 했다. 웨일스에는 총 2,573개의 폐탄광 슬래그 더미가 존재하며, 이 중 360개는 공공 안전에 위협이 될 수 있어 정기적 점검이 필요한 것으로 분류됐다. 특히 Rhondda Cynon Taf 지역에는 가장 많은 ‘D등급 고위험’ 슬래그가 있어, 1,149만 파운드가 이 지역에 집중 배정된다. 2020년 Tylorstown 붕괴 사건 당시 6만 톤의 폐석이 하산하며 하천을 덮쳤고, 이후 영국-웨일스 정부 합동 Coal Tip Safety Taskforce가 발족되었다. 현재는 기존의 1966년 Aberfan 참사 이후 제정된 법이 실효성을 잃었다는 지적에 따라, **‘폐광 및 채석장 안전법(Disused Mine and Quarry Tips Bill)’**이 웨일스 의회에 제출되어 새 법적 기반을 마련 중이다.",
            "2025년 3월 20일, 북아일랜드 전역에 산불 위험 ‘호박(Amber)’ 경보가 발령되었다. 최근 무어 산(Mourne Mountains) 기슭에서 발생한 큰 골풀(gorse) 화재 이후, 기상 조건이 건조하고 바람이 강해 산불 발생 위험이 커진 상황이다. 이번 화재는 60명의 소방대원과 7대의 소방차가 투입될 정도로 큰 규모였으며, 방화로 의심되고 있다. 이에 따라 **자연재해 파트너십(Natural Hazards Partnership)**은 기존의 ‘황색 경보’를 상향 조정했고, **북아일랜드 수도사업청(NI Water)**은 일회용 바비큐 사용, 쓰레기 투기, 쓰레기 태우기 금지 등을 당부했다. 소방당국은 “이러한 산불은 대부분 인간의 부주의로 인해 발생하며, 예방 가능하다”고 강조하며, 담배 꽁초와 야외 불씨 사용 금지를 강력히 권고했다. 또, “산불은 빠르게 확산되고 예측 불가하며, 환경과 생물 다양성에 심각한 피해를 준다”고 경고했다.",
            "2025년 3월 18일, 스코틀랜드 전역 저지대 지역에 대해 ‘극심한(extreme)’ 산불 위험 경고가 발령되었다. **스코틀랜드 소방구조청(SFRS)**은 최근 건조하고 화창한 날씨가 지속되며, 금요일에는 기온이 최고 18도까지 오를 것으로 예보되어 산불 발생 가능성이 매우 높다고 밝혔다. 이번 경보는 올해 처음으로 발령된 ‘아주 높은 위험’ 수준의 경고를 상향 조정한 것으로, 중부 및 남서부 지역에선 이미 높은 위험 수준이 유지되고 있다. 소방지휘관 머레이 달글리시(Murray Dalgleish)는 “산불은 가축, 농지, 생태 보호 구역 및 지역 주민의 생계와 안전에 치명적인 피해를 줄 수 있다”며, 모든 국민이 책임감 있는 행동을 해야 한다고 경고했다.",
            "2025년 3월 중순, 미국 남부 여러 주에서 발생한 극심한 토네이도와 먼지 폭풍, 산불로 인해 최소 34명이 사망하고 수많은 주택이 파괴되었으며, 수십만 가구가 정전 피해를 입었다. **미주리(Missouri)**에서는 12명이 사망하고, 25개 카운티에서 19개의 토네이도가 관측되었다. 일부 가옥은 완전히 파괴되어 잔해로 변했다. **텍사스(Texas)**와 **캔자스(Kansas)**에서는 **먼지 폭풍(dust storm)**으로 50대 이상의 차량이 추돌하며, 각각 최소 4명과 8명이 숨졌다. **오클라호마(Oklahoma)**에서는 130건 이상의 산불이 발생해, 112건의 화상 등 부상자가 보고되었으며, 주지사 본인의 목장도 전소되었다. ‘토네이도 앨리(Tornado Alley)’라 불리는 텍사스, 루이지애나, 오클라호마, 캔자스 등은 지형적 특성상 따뜻하고 습한 공기와 찬 공기가 충돌해 토네이도가 자주 발생하는 지역으로, 이번 사태는 계절을 앞당긴 이상 기상 현상으로 해석된다.",
            "2025년 1월에 발생한 **폭풍 ‘에오윈(Éowyn)’**으로 인해 영국 북부 컴브리아(Cumbria) 지역에서 수천 가구가 정전 피해를 입었고, 많은 농촌 지역에서 통신망이 두절되었다. 이로 인해 주민들이 외부와 연락조차 할 수 없는 위기 상황에 놓이자, 컴브리아 지역 의원들이 통신사와 이동통신망 사업자들에게 개선을 촉구하고 나섰다. 통신사 단체인 Mobile UK는 업계는 이미 극한 기상 조건에 대비한 탄력성을 강화하기 위한 조치를 진행 중이며, 자가 발전형 기지국 개발도 포함된다고 설명했다. 에너지 규제 기관 Ofgem은 2028~2032년간의 지역망 투자 계획에 따라, 더 빈번한 극한 기후에 대비한 기반시설 강화가 포함될 것이라고 발표했다."
    );

    private final List<LocalDate> dates = List.of(
            LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 1),
            LocalDate.of(2025, 3, 31), LocalDate.of(2025, 3, 30), LocalDate.of(2025, 3, 27),
            LocalDate.of(2025, 3, 26), LocalDate.of(2025, 3, 26), LocalDate.of(2025, 3, 23),
            LocalDate.of(2025, 3, 23), LocalDate.of(2025, 3, 22), LocalDate.of(2025, 3, 21),
            LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 20),
            LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 18),
            LocalDate.of(2025, 3, 16), LocalDate.of(2025, 3, 15)
    );

    private final List<List<ClimateProblem>> problems = List.of(
            List.of(WILDFIRE),
            List.of(TEMPERATURE_RISE),
            List.of(WILDFIRE),
            List.of(HEAVY_RAIN_OR_FLOOD),
            List.of(HEAVY_RAIN_OR_FLOOD, TEMPERATURE_RISE, DROUGHT_OR_DESERTIFICATION),
            List.of(WILDFIRE, TEMPERATURE_RISE, DROUGHT_OR_DESERTIFICATION, BIODIVERSITY_LOSS),
            List.of(WILDFIRE, TEMPERATURE_RISE, DROUGHT_OR_DESERTIFICATION, BIODIVERSITY_LOSS),
            List.of(HEAVY_RAIN_OR_FLOOD, SEA_LEVEL_RISE),
            List.of(DEFORESTATION, BIODIVERSITY_LOSS, TYPHOON_OR_TORNADO),
            List.of(WILDFIRE, TEMPERATURE_RISE, DROUGHT_OR_DESERTIFICATION),
            List.of(WILDFIRE, DROUGHT_OR_DESERTIFICATION),
            List.of(WILDFIRE, DROUGHT_OR_DESERTIFICATION, TEMPERATURE_RISE),
            List.of(WILDFIRE, DROUGHT_OR_DESERTIFICATION, TEMPERATURE_RISE),
            List.of(WILDFIRE, DEFORESTATION, DROUGHT_OR_DESERTIFICATION),
            List.of(WILDFIRE, BIODIVERSITY_LOSS, DROUGHT_OR_DESERTIFICATION),
            List.of(HEAVY_RAIN_OR_FLOOD, SEA_LEVEL_RISE),
            List.of(WILDFIRE, FINE_DUST, DROUGHT_OR_DESERTIFICATION),
            List.of(WILDFIRE, TEMPERATURE_RISE, DROUGHT_OR_DESERTIFICATION),
            List.of(TYPHOON_OR_TORNADO, HEAVY_RAIN_OR_FLOOD, WILDFIRE, FINE_DUST, TEMPERATURE_RISE),
            List.of(TYPHOON_OR_TORNADO, HEAVY_RAIN_OR_FLOOD, TEMPERATURE_RISE)
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
            newsList.add(news);
        }
    }

}