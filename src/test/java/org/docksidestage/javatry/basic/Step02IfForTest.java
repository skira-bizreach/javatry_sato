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
                land = true; // とにかくここ通ればseaは10
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

    // #1on1: コードリーディングのコツ、漠然読み (2026/09/04)
    // $上から読んでなくても、landがtrueなら10じゃん、land読んでおけば良かった。
    // $こういうこともあるのか
    // そういう体験をされたのは素晴らしい。
    // (javatryとしてはじっくり読むこと自体もトレーニングなので良いとして)
    // 
    // (まずスクロールして輪郭だけみて...)
    // o 漠然読みで構造把握 (全体像を見る)
    //  → ここだと、変数宣言、大中小のif文、ログ出し (5つのパート)
    //
    // o 当たりを付けてフォーカス読み
    //  (当たりの探し方)
    //  → seaに影響を与える行は直近(の確率が高い)ので逆さ読みでsea=10を見つける
    //  → もしくは全体像を見たことで自然とsea=10が目に入る
    //    (ストーリーがわかってれば、自然とこの辺を見れば当たりがありそう)
    //  → なんにせよ、そう言うふうに当たりを探す
    //
    // 当たりがどこかにあるんじゃないかと思って読む。
    //
    // ただ、ギャンブルに負けることはあります。だけど、損はない。
    // 構造把握しているし、ある程度踏み込んでるので、
    // ０から網羅読みするよりは速く読めるようになってる。
    // (頭の中で地図を作ってから読む方が、安定して読める)
    //
    // さらに、ある程度踏み込んだことで、次の当たりが見つかることも。
    // 3,4回繰り返したとしても、網羅読みするよりは速い可能性。
    //
    // 極力、読まなくて良いところ読まないで済ませたい。そのための方法論の一つ。
    //
    // よもやま: 仮説思考的なコードリーディング!?

    // done sato [読み物課題] My Favorite Book: 仮説思考 by jflute (2026/09/04)
    // https://jflute.hatenadiary.jp/entry/20150111/kasetsu
    // アンチパターンあるあるだなと思いました
    // 仮説思考、大事なのはもちろんわかるんですが、それと同時に難しい
    // 研究室の先生が心理学の話もよくしてくれていたので、メタ認知とかも難しいよなあと懐かしくなりましたね

    // sato [読み物課題] jfluteのプログラマーオススメ五冊 by jflute (2026/09/04)
    // https://jflute.hatenadiary.jp/entry/20150727/fivebooks
    // ディズニーの本のおすすめのところにあった以下の文が気に入りました、変数名とかディズニーに関連づけてるのも、気づいたらちょっと嬉しくなれますね
    // そこに少しでも笑顔が入るようなコード書けてたら、やっぱりうれしいじゃんって。
    // リーダブルコード、めちゃめちゃよく聞きますよね、実際同期のこはこうも読んでた（javatry影響なのかはわかりませんが）
    // 読んだことはないので読んでみようかな、チームの人に言われた達人プログラマーも全然読めていない…

    // #1on1: 他業種の特化したbutぼくらも共通のお話が役に立つことも多い (2026/09/04)
    // (他の人の俳句の話から変数名の命名の技術話)

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

    // #1on1: Javaの文法としての二つのループ (2026/09/04)
    // o いんとiのfor文: Java当初から (1995年)
    // o 拡張for文(foreach文): Java10年目くらいから (2005年)
    //
    // 普通のfor文って言った場合どっち？ → 現場だと拡張for文

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
        StringBuilder ga = new StringBuilder("ga");
        // #1on1: isBreak を使わなかったところが素晴らしい (2026/09/04)
        // sb が isBreak の情報を持ってるので、不要な変数を作らなくて良い。
        @SuppressWarnings("unused") // おもいで
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
        // #1on1: Lambda式は、実際にはとあるクラスのとあるメソッドを定義してnewしてるみたいもの (2026/09/18)
        // e.g. new AbcConsumer().accept() {}
        // ← ここの行1: test_メソッド所属
        stageList.forEach(stage -> {
            // ← ここの行2: AbcConsumer@accept()所属
            // test_メソッドから見たら、別クラス別メソッドの世界。

            // done sato パフォーマンス考慮、毎ループtoString()するとインスタンス多い by jflute (2026/09/04)
            // StringBuilderのまま判定できると良い。
            // final String st = sb.toString();
            //            if (st.contains("ga")) {
            //                return;
            //            }
            // StringBuilderの定義を見たらcompareToがあるからそれでいけそうと思ったけど、バージョンが違って実行できない
            // でもこの方法以外でStringBuilderのまま判定する方法はないと思うんだけどどうなんだろう
            // AIにバージョンを上げた場合の実行結果だけ聞いたらいけてそうだったのでdoneにします
            // #1on1: indexOf() の紹介 (2026/09/18)
            //  e.g. if (sb.indexOf("ga") >= 0) {
            if (ga.toString().compareTo(sb.toString()) == 0) {
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

    // #1on1: なんで、Lambda式の中で、外側のローカル変数の再代入ができないのか？ (2026/09/04)
    // $なんでだろう？
    // 仕組みが違うのか？
    // 普通に実行して、できても良さそうなのに。ループでseaに代入して、最後seaの値を出す。
    //
    // forEach()メソッドは、Javaキーワード色になっていない。
    //
    // #1on1: forEach()メソッドのコードリーディング (2026/09/18)
    // forEach()メソッドの中で、拡張for文を使っている。
    // 単なるfor文の代理人みたいなメソッド。文法的にはただのメソッド。
    //
    // sea = stage; ができないという話だが...
    // 自分(test_メソッド)のローカル変数を、別クラス別メソッドに書き換えられたらたまらん。
    //
    // Lambda式は別クラス別メソッド。
    // ローカル変数としてのコンセプトを維持するとなったら、外側のローカル変数は再代入させてはいけない。
    // もしできちゃうと、時系列的な矛盾も発生しやすく、カオスなプログラムが作りやすくなってしまう。
    // ローカル変数としてのコンセプトを維持するってのは非常に大事なこと。
    // 
    // でも、固定の値 (immutableな変数) であれば、参照はできる。参照だけならカオスは生まれにくい。
    // なので、isBreakは参照できる。
    // だけど、sea は参照できない。seaは固定の値ではない (mutableな変数になっている)
    // Lambda式から見て、seaはいつ変わるかわからない変数なので、それに依存しないように。
    // 時系列的な偶然性に依存した処理を書けないようにしている。
    //
    // こういうバックグランドを理解できるようになったら、文法の当たりを付けやすくなって、
    // 覚えやすい、想像しやすい、応用しやすい、につながってくると思います。

    // TODO jflute 次回1on1, じゃあforEach()メソッドの存在意義は？ (2026/09/18)
    // 仕組みはわかった。色々できない理由もわかった。
    // じゃあなんでそんなできないことだらけのループ作ったの？

    /**
     * Make your original exercise as question style about if-for statement. <br>
     * (if文for文についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     *1から10までの数字を順番に表示し、偶数の場合は
     *     「偶数」と一緒に表示してください。
     *
     *     例：
     *     1
     *     2（偶数）
     *     3
     *     4（偶数）
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_iffor_yourExercise() {
        // write your code here
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                log(i + "（偶数）");
            } else {
                log(i);
            }
        }
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
