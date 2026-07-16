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

import java.math.BigDecimal;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author sato(kchan)
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log(sea); // your answer? => mystic
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;
        log(sea); // your answer? => mystic8:mai
    }
    // 不正解
    // nullは何もないってことだから、Stringにすると何もでないと思ったけど違うのか
    // nullの場合はnullがそのまま入る
    // printlnとかの出力系でも同じ挙動で、printlnの場合はString.valueOf()が呼ばれて、nullの場合は"null"という文字列になるらしい
    // TODO sato [ふぉろー] プログラミング言語の決めの問題となってて... by jflute (2026/07/16)
    // Javaみたいに "null" って文字として表現するケースもあれば、C#みたいに空文字になるケースも。
    // 画面やメール文言で "null" って表示されちゃう問題が発生しやすい一方で、
    // 開発時のログとか画面で "null" って表示されて不具合を見つけいやすい面も。
    // どっちもどっちみたいなところあります。
    // System.out.println() のコード読んでるの素晴らしい(^^。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic";
        String land = "oneman";
        sea = land;
        land = land + "'s dreams";
        log(sea); // your answer? => oneman
    }
    // 正解
    // プログラムは上から実行されるってことを頭の片隅に置いておく
    // TODO sato [いいね] Good, その通り。なんだかんだ1行ずつですからね by jflute (2026/07/16)
    // もうちょい踏み込むと、land = land + "'s dreams"; の行。
    // "=" の右側から実行されます。land + "'s dreams" が評価された結果が、
    // 左の land に代入されるという感じ。
    // なので右辺のlandが指し示すインスタンスと、左のlandが指し示すインスタンスが、
    // 変わっています。landという変数が持つアドレスが差し変わったと言う感じで。

    // TODO jflute 1on1にて、変数とインスタンスについてお話しする予定 (2026/07/16)
    // ↑このとぅどぅはくぼ用備忘録なので、そのままにしておいてください。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415
    }
    // 正解
    // これも1個上の問題と同じく、プログラムは上から実行されることを意識する

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94);
        BigDecimal land = new BigDecimal(415);
        sea = land;
        sea = land.add(new BigDecimal(1));
        sea.add(new BigDecimal(1));
        log(sea); // your answer? => 417
    }
    // 不正解、正解は416
    // BigDecimalは誤差を出さずに計算をするためのクラス
    // コンピュータ内部だと2進数で扱われるので、変換時に誤差が出る場合がある（これ、バイト先で高校生の情報科目のサポートやってた時に習ったな）
    // このクラスは数値を「整数値」と「小数点の位置（スケール）」の組み合わせとして10進数で管理するから誤差が起きない、ということらしい
    // そしてこの型は不変なので、加算結果は新しいインスタンスとして返される -> つまり、addしたものを代入しないと値は変わらない
    // addとかは勝手に変数の値を変えてくれるイメージがあったけど、型によっても違うんだな
    // TODO sato [ふぉろー] そんなバイトされていたんですね（＾＾。今度お話し聞かせてください笑 by jflute (2026/07/16)
    // 不変というキーワード素晴らしい、そこがポイントです。
    // add() で自分が変化するパターンと、変化結果を戻すだけのパターンと二つあるわけです。

    // TODO jflute 1on1にてimmutableのお話をする予定 (2026/07/16)

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => (何も出ない)
    }
    // 不正解、正解はnull
    // 初期化をしていない場合はnullが入る
    // nullは最初の問題の通り出力されるので、nullが出る
    // Stringはnull許容だったな
    // TODO sato [ふぉろー] Stringに限らずオブジェクト型全体がnull許容となります by jflute (2026/07/16)

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => エラーになる
    }
    // 不正解、正解は0
    // 初期化してないとエラーになると思ったけど違う
    // ローカル変数は初期化してないとエラーになるけど、インスタンス変数やクラス変数は初期化しなくてもデフォルト値が入る
    // 今回の場合はinstanceDocksideがクラス変数だから、初期化しなくてもデフォルトの値として0が入る
    // それをローカル変数seaの初期化に使っているから0が入ってエラーにはならない
    // TODO sato [ふぉろー] ここは言語としてのもう決めの話なんですね。 by jflute (2026/07/16)
    // オブジェクト型ではない「プリミティブ型」と言われるものは、デフォルト値が入ります。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => null
    }
    // 正解
    // まずintとIntegerの違いってなんだ？
    // intはプリミティブ型(最初から用意されている型)で、nullは入らない、32ビット
    // Integerはオブジェクト型で、nullも入る
    // IntegerはintをStringにキャストしたい時とかに使う
    // 今回の場合、Integerはnull許容なので、instanceHangerがnull
    // なのでseaも同様にnull
    // TODO sato [読み物課題] Java Beginner's Hint - プリミティブ型とラッパー型 by jflute (2026/07/16)
    // https://dbflute.seasar.org/ja/manual/topic/programming/java/beginners.html#primitivewrapper
    // ↑こちらぜひ読んでみてください。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => bigband|1|null|burn
    }
    // 不正解、正解はbigband|1|null|magician
    // クラス変数だから全部更新されると思ってたけど、helpInstanceVariableViaMethodで同じ名前の引数を作ってる
    // 引数の中身が更新されただけで、クラス変数の中身は変わらない
    // 42で学んだメモリとかの話にもつながりそう
    // TODO sato [ふぉろー] 厳密には「クラス変数」とは呼ばず「インスタンス変数」と呼ばれます by jflute (2026/07/16)
    // クラス全体にまたがってるからクラス変数と呼びたくなりますが、厳密にはインスタンスにまたがってる変数ということで。
    // 「クラス変数 (クラス全体にまたがってる)」となると、実は staticを付けた変数のことを差し示してしまいます。
    // (staticを付けた変数は、レアなので現時点ではそこまで意識しなくてもOKです)

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => 
    }

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
    }

    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => 
    }

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;
        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => 
    }

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land;
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */
    public void test_variable_writing() {
        // define variables here
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     *
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_variable_yourExercise() {
        // write your code here
    }
}
