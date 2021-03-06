package com.jojoldu.incomebot.core.lecture.book.store.history;

import com.jojoldu.incomebot.core.lecture.LectureHistory;
import com.jojoldu.incomebot.core.lecture.LectureRank;
import com.jojoldu.incomebot.core.lecture.book.store.BookLectureStore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ConstraintMode;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by jojoldu@gmail.com on 26/10/2019
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@Getter
@NoArgsConstructor
@Entity
@Table(
        indexes = {
                @Index(name = "idx_book_lecture_store_history_1", columnList = "store_id")
        }
)
public class BookLectureStoreHistory extends LectureHistory {

    @Embedded
    private LectureRank rank;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "store_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private BookLectureStore store;

    @Builder
    public BookLectureStoreHistory(long beforeScore, long currentScore, int beforeRank, int currentRank, LocalDateTime notifyDateTime, String message) {
        super(beforeScore, currentScore, notifyDateTime, message);
        this.rank = LectureRank.builder().beforeRank(beforeRank).currentRank(currentRank).build();
    }

    public void setStore(BookLectureStore store) {
        this.store = store;
    }

    public long getCurrentScore() {
        return score.getCurrentScore();
    }

    public int getCurrentRank() {
        return rank.getCurrentRank();
    }

}
