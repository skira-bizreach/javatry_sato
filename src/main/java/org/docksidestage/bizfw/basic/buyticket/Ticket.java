/*
 * Copyright 2019-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

import java.time.LocalTime;

/**
 * @author jflute
 */
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // #1on1: いいね、inParkCount, max どちらも誤解のない直感的な変数名 (2026/10/23)
    // done sato max何？ってのは少し表現したいところ e.g. maxDays by jflute (2026/10/23)
    // 入園できる最大日数なので、Daysにした

    // done sato maxはfinal付けられないだろうか？ by jflute (2026/10/23)
    // defaultを設定しました

    // ただ、今finalを付けると Constructorで max初期化されてないエラーになる。
    // switch case でどこにもヒットしないことを考慮されていないので文法的にどうしてもそうなる。
    // なので網羅させてfinalを付けられるようにしてみましょう。
    private final int displayPrice; // written on ticket, park guest can watch this
    private boolean alreadyIn; // true means this ticket is unavailable
    private int inParkCount;
    private final int maxDays;
    private final LocalTime entryAvailableTime;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    //    public Ticket(int displayPrice) {
    //        this.displayPrice = displayPrice;
    //        this.inParkCount = 0;
    //        switch (displayPrice) {
    //        case 7400:
    //            maxDays = 1;
    //            break;
    //        case 13200:
    //            maxDays = 2;
    //            break;
    //        case 22400:
    //            maxDays = 4;
    //            break;
    //        default:
    //            throw new IllegalArgumentException("登録されていないチケットの値段です" + displayPrice);
    //        }
    //    }

    // TODO jflute 次回、ここのConstructorのレビュー一緒に (2026/11/06)
    public Ticket(int displayPrice, LocalTime time) {
        this.displayPrice = displayPrice;
        this.inParkCount = 0;
        this.entryAvailableTime = time;
        if (entryAvailableTime.equals(LocalTime.of(17, 0))) {
            switch (displayPrice) {
            case 7400:
                maxDays = 2;
                break;
            default:
                throw new IllegalArgumentException("登録されていないチケットの値段です" + displayPrice);
            }
        } else {
            switch (displayPrice) {
            case 7400:
                maxDays = 1;
                break;
            case 13200:
                maxDays = 2;
                break;
            case 22400:
                maxDays = 4;
                break;
            default:
                throw new IllegalArgumentException("登録されていないチケットの値段です" + displayPrice);
            }
        }
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        //                if (alreadyIn) {
        //                    throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        //                }
        if (entryAvailableTime.equals(LocalTime.of(17, 0))) {
            throw new IllegalStateException("このチケットでは17時まで入園できません");
        }

        // #1on1: $二つの選択肢があることは理解して、こっちに決めた (2026/11/06)
        // OneDayのみ時代は、「1回入った == 使い切った」だった。
        // シンプルな仕様時代の曖昧な概念が、仕様追加で区別しないといけなくなった。
        alreadyIn = true;

        if (inParkCount == maxDays) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        inParkCount++;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public int getParkCount() {
        return inParkCount;
    }

    public int getMaxDays() {
        return maxDays;
    }

    // TODO sato isAlreadyIn()のニュアンスを変えずに互換を維持しないといけない by jflute (2026/11/06)
    // (厳密には、使っている箇所を一つ一つ調べて、どっちのニュアンスで使ってるかを確認する必要がある)
    // ベテランだと、twoDayが仕様追加された瞬間に、なんか危なさそう、って思う。
    // javatryのケーススタディで、今からでもそういうことを意識して業務仕様を解釈できると良い。
    //
    // 一方で、すでに alreadyIn という言葉自体が紛らわしいので、変えちゃったほうが良いものではある。
    // ただ、その場でバッと変えていいかどうかはチームのやり方に依る。
    // (deprecated運用テクニックの紹介)
    public boolean isAlreadyIn() {
        return alreadyIn;
    }
}
