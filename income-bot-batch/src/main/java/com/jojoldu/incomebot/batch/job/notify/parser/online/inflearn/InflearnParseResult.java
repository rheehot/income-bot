package com.jojoldu.incomebot.batch.job.notify.parser.online.inflearn;

import com.jojoldu.incomebot.batch.job.notify.parser.online.OnlineParseResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.jojoldu.incomebot.batch.util.NumberUtils.toCommaNumber;

/**
 * Created by jojoldu@gmail.com on 26/10/2019
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@Getter
@RequiredArgsConstructor
public class InflearnParseResult implements OnlineParseResult {
    public static final InflearnParseResult EMPTY = new InflearnParseResult(0, 0);
    private static final String TEXT_FORMAT = "[인프런] \"{goods}\"의 수강생이 {addScore}명 ({addAmount}원) 되어 현재 {newScore} 명이 수강중입니다.";

    private final long studentCount;
    private final long coursePrice;

    @Override
    public String getMessage(long beforeScore, String goods) {
        long changeScore = studentCount - beforeScore;
        String code = changeScore >= 0 ? "+" : "-";
        long changeAmount = Math.round(changeScore * coursePrice * 0.7 * 0.88);

        return TEXT_FORMAT
                .replaceAll("\\{goods\\}", goods)
                .replaceAll("\\{addScore\\}", code + toCommaNumber(changeScore))
                .replaceAll("\\{addAmount\\}", code + toCommaNumber(changeAmount))
                .replaceAll("\\{newScore\\}", toCommaNumber(studentCount));
    }

}
