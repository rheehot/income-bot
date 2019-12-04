package com.jojoldu.incomebot.parser.parser.book.aladin;

import com.jojoldu.incomebot.parser.parser.book.BookParseResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static com.jojoldu.incomebot.parser.util.NumberUtils.toAbsCommaNumber;

/**
 * Created by jojoldu@gmail.com on 26/10/2019
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@ToString
@Getter
@RequiredArgsConstructor
public class AladinParseResult implements BookParseResult {
    public static final AladinParseResult EMPTY = new AladinParseResult(0);
    private static final String TEXT_FORMAT = "[알라딘] \"{goods}\"의 Sales Point가 {addScore} 되어 현재 {newScore} 를 달성했습니다.";

    private final long currentScore;

    @Override
    public String getMessage(long beforeScore, String goods) {
        long changeScore = currentScore - beforeScore;
        String code = changeScore >= 0 ? "+" : "-";

        return TEXT_FORMAT
                .replaceAll("\\{goods\\}", goods)
                .replaceAll("\\{addScore\\}", code + toAbsCommaNumber(changeScore))
                .replaceAll("\\{newScore\\}", toAbsCommaNumber(currentScore));
    }
}
