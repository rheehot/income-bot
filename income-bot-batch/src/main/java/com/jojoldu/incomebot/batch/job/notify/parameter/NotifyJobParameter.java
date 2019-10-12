package com.jojoldu.incomebot.batch.job.notify.parameter;

import com.jojoldu.incomebot.core.instructor.IntervalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by jojoldu@gmail.com on 12/10/2019
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@Slf4j
@Getter
@NoArgsConstructor
public class NotifyJobParameter {
    private static final DateTimeFormatter trimFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private IntervalType interval;
    private LocalDateTime executeTime;

    @Value("#{jobParameters[interval]}")
    public void setInterval(String interval) {
        this.interval = IntervalType.valueOf(interval);
    }

    @Value("#{jobParameters[executeTime]}")
    public void setExecuteTime(String executeTime) {
        this.executeTime = LocalDateTime.parse(executeTime, trimFormatter);
    }
}
