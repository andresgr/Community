package com.asgr.community.model;

import android.support.annotation.NonNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by andres on 30/10/17.
 */

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class BiblePosition implements Comparable<BiblePosition> {

    private int chapter;
    private int verse;

    @Override
    public int compareTo(@NonNull BiblePosition other) {
        if (this.equals(other)) {
            return 0;
        }
        if (chapter < other.chapter) {
            return -1;
        } else if (chapter > other.chapter) {
            return 1;
        } else {
            return verse < other.verse ? -1 : (verse == other.verse ? 0 : 1);
        }
    }

    @Override
    public String toString() {
        return String.format("%d, %d", chapter, verse);
    }
}
