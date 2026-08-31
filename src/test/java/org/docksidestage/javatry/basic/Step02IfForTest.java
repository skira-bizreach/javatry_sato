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
package org.docksidestage.javatry.basic;

import java.util.ArrayList;
import java.util.List;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of if-for. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author sato(kchan)
 */
public class Step02IfForTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        if Statement
    //                                                                        ============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_if_basic() { // example, so begin from the next method
        int sea = 904;
        if (sea >= 904) {
            sea = 2001;
        }
        log(sea); // your answer? => 2001
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_else_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else {
            sea = 7;
        }
        log(sea); // your answer? => 7
    }
    // 正解

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else if (sea >= 904) {
            sea = 7;
        } else if (sea >= 903) {
            sea = 8;
        } else {
            sea = 9;
        }
        log(sea); // your answer? => 7
    }
    // 正解、if文は最初に当てはまる分岐の処理に進む

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_nested() {
        boolean land = false;
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
            sea = sea++ * 2;
        } else if (land && sea >= 904) {
            sea = 7;
            sea = ++sea * 2;
        } else if (sea >= 903 || land) {
            if (sea % 2 == 0) {
                sea = sea++ * 2;
            }
            if (!land) {
                land = true;
            } else if (sea <= 903) {
                sea++;
            }
            if (sea < 1810) {
                sea = 8;
            }
        } else if (sea == 8) {
            sea++;
            land = false;
        } else {
            sea = 9;
        }
        if (sea >= 9 || (sea > 7 && sea < 9)) {
            sea--;
            if (sea % 2 == 1) {
                sea++;
            }
        }
        if (land) {
            sea = 10;
        }
        log(sea); // your answer? => 10
    }
    // 正解
    // これだけ処理が分岐すると、どこで値がどう変わるか混乱してくる
    // IntelliJが親切だから条件文に常にtrue / falseです、って出してくれる、カーソル合わせると見えちゃうから良くないな…

    // ===================================================================================
    //                                                                       for Statement
    //                                                                       =============
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_inti_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (int i = 0; i < stageList.size(); i++) {
            String stage = stageList.get(i);
            if (i == 1) {
                sea = stage;
            }
        }
        log(sea); // your answer? => dockside
    }
    // 正解
    // javaは配列の添字は0から

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            sea = stage;
        }
        log(sea); // your answer? => magiclamp
    }
    // 正解
    // for (String stage : stageList)はstageListの中身をstageに入れて、listの終端まで繰り返す
    // 毎回seaがstageの中身で上書きされて示すアドレスが変わり、最後のmagiclampが入る

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_continueBreak() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            sea = stage;
            if (stage.contains("ga")) {
                break;
            }
        }
        log(sea); // your answer? => hangar
    }
    // 正解
    // continueはその下の処理をスキップして、繰り返しの最初に戻る
    // breakは繰り返しを抜ける

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_listforeach_basic() {
        List<String> stageList = prepareStageList();
        StringBuilder sb = new StringBuilder();
        stageList.forEach(stage -> {
            if (sb.length() > 0) {
                return;
            }
            if (stage.contains("i")) {
                sb.append(stage);
            }
        });
        String sea = sb.toString();
        log(sea); // your answer? => dockside
    }
    // 正解
    // javaでラムダ式は初めて見た、実務ではKotlinだから良く見てます
    // forEachでstageListの中身1つ1つを処理する
    // ラムダ式なので、処理するstageListの中身がstageに入る
    // stageListの中身は2番目（添え字としては1）にiが入るので、そのタイミングで　sbにdocksideが入る
    // 次にstageがhangarになった時には、sb.length() > 0が満たされるので、returnされてラムダが終了
    // (あってるか不安だったのでAIに聞いたところ、ここのreturnはラムダの1回の要素処理だけを終了するらしい)
    // (結果的に他の中身ではsb.length() > 0が満たされないので中身が変わらなかった)
    // sbの最後の中身はdocksideなので、docksideが出力される

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Make list containing "a" from list of prepareStageList() and show it as log by loop. (without Stream API) <br>
     * (prepareStageList()のリストから "a" が含まれているものだけのリストを作成して、それをループで回してログに表示しましょう。(Stream APIなしで))
     */
    public void test_iffor_making() {
        // write if-for here
        List<String> stageList = prepareStageList();
        for (String stage : stageList) {
            if (stage.contains("a"))
                log(stage);
        }
    }
    // for文以外もforEachとかでも書けそう

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Change foreach statement to List's forEach() (keep result after fix) <br>
     * (foreach文をforEach()メソッドへの置き換えてみましょう (修正前と修正後で実行結果が同じになるように))
     */
    public void test_iffor_refactor_foreach_to_forEach() {
        List<String> stageList = prepareStageList();
        String sea = null;
        StringBuilder sb = new StringBuilder();
        Boolean isBreak = false;
        /*
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            sea = stage;
            if (stage.contains("ga")) {
                break;
            }
        }
         */
        stageList.forEach(stage -> {
            final String st = sb.toString();
            if (st.contains("ga")) {
                return;
            }
            if (stage.startsWith("br")) {
                return;
            }
            sb.setLength(stage.length());
            sb.replace(0, stage.length(), stage);
        });
        sea = sb.toString();
        log(sea); // should be same as before-fix
    }
    // 実行結果はhangar
    // continueは先ほどreturnを使って同じような処理をしているのを見た
    // seaもラムダ式の中ではfinal相当の変数でないと使用できないらしい
    // これは前に見たものと同様にStringBuilderを定義し、それをラムダ式の中で使うことで回避した
    // breakはどうやって表現するんだ？
    // 詰まったので調査したところ、ラムダ式の中ではbreakは使えない

    // 要件を整理し直してみる
    // brが含まれている文字列は何もせずスキップ → これは変わらない
    // それ以外の文字ならseaを入れ替える → これはStringBuilderを使う
    // gaが含まれている文字列ならその後何もせず処理終了 → gaが含まれているかを最初に確認する必要がある
    // あとはappendだと追加になるので、StringBuilderのメソッドを調べて、中身を入れ替える処理に変更すればいけた
    // breakが使えないってこんなに大変なんだな

    /**
     * Make your original exercise as question style about if-for statement. <br>
     * (if文for文についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     *
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_iffor_yourExercise() {
        // write your code here
    }

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    private List<String> prepareStageList() {
        List<String> stageList = new ArrayList<>();
        stageList.add("broadway");
        stageList.add("dockside");
        stageList.add("hangar");
        stageList.add("magiclamp");
        return stageList;
    }
}
