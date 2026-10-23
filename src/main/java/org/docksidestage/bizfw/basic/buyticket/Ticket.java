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

/**
 * @author jflute
 */
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // #1on1: いいね、inParkCount, max どちらも誤解のない直感的な変数名 (2026/10/23)
    // TODO sato max何？ってのは少し表現したいところ e.g. maxDays by jflute (2026/10/23)
    // TODO sato maxはfinal付けられないだろうか？ by jflute (2026/10/23)
    // ただ、今finalを付けると Constructorで max初期化されてないエラーになる。
    // switch case でどこにもヒットしないことを考慮されていないので文法的にどうしてもそうなる。
    // なので網羅させてfinalを付けられるようにしてみましょう。
    private final int displayPrice; // written on ticket, park guest can watch this
    private boolean alreadyIn; // true means this ticket is unavailable
    private int inParkCount;
    private int max;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(int displayPrice) {
        this.displayPrice = displayPrice;
        this.inParkCount = 0;
        switch (displayPrice) {
        case 7400:
            max = 1;
            break;
        case 13200:
            max = 2;
            break;
        case 22400:
            max = 4;
            break;
        }
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        //                if (alreadyIn) {
        //                    throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        //                }
        alreadyIn = true;

        if (inParkCount == max) {
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

    public int getMax() {
        return max;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }
}
