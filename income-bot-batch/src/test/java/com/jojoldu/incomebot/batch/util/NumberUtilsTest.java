package com.jojoldu.incomebot.batch.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jojoldu@gmail.com on 28/10/2019
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class NumberUtilsTest {

    @Test
    public void 콤마가_있는값으로_출력된다() {
        //given
        Long number = 1_000L;

        //when
        String result = NumberUtils.toCommaNumber(number);

        //then
        assertThat(result).isEqualTo("1,000");
    }
}