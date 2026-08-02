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
    // done sato [ふぉろー] プログラミング言語の決めの問題となってて... by jflute (2026/07/16)
    // Javaみたいに "null" って文字として表現するケースもあれば、C#みたいに空文字になるケースも。
    // 画面やメール文言で "null" って表示されちゃう問題が発生しやすい一方で、
    // 開発時のログとか画面で "null" って表示されて不具合を見つけいやすい面も。
    // どっちもどっちみたいなところあります。
    // System.out.println() のコード読んでるの素晴らしい(^^。
    // #1on1: nullのネタの話、一応細かいけどメリデメがある (2026/07/17)
    // #1on1: println() のソースコードリーディング (2026/07/17)

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic"; // "mystic"というStringインスタンスが生成された
        String land = "oneman"; // "oneman"というStringインスタンスが生成された
        sea = land; // landのアドレスがseaにコピーされる (どちらもonemanを参照してる)
        land = land + "'s dreams"; // "'s dreams" と "oneman's dreams" というStringインスタンスが生成された
        log(sea); // your answer? => oneman
    }
    // 正解
    // プログラムは上から実行されるってことを頭の片隅に置いておく
    // done sato [いいね] Good, その通り。なんだかんだ1行ずつですからね by jflute (2026/07/16)
    // もうちょい踏み込むと、land = land + "'s dreams"; の行。
    // "=" の右側から実行されます。land + "'s dreams" が評価された結果が、
    // 左の land に代入されるという感じ。
    // なので右辺のlandが指し示すインスタンスと、左のlandが指し示すインスタンスが、
    // 変わっています。landという変数が持つアドレスが差し変わったと言う感じで。

    // #1on1: メソッドの中は上からだけど、構造自体はあまり上下関係ない話 (2026/07/17)
    // メソッドの定義位置は上だろうが下だろうが挙動に影響はない。

    // done jflute 1on1にて、変数とインスタンスについてお話しする予定 (2026/07/16)
    // ↑このとぅどぅはくぼ用備忘録なので、そのままにしておいてください。
    // #1on1: 授業でインスタンスは聞いた→言語化が難しい (2026/07/17)
    // 一軒家の設計図: クラス
    // 具体的な一軒家作ったもの: インスタンス
    // Stringのvalue変数も見てみて、冷蔵庫の例え。
    // これ「インスタンス変数」と呼ぶ。インスタンスごとに独立して存在している変数。
    // Instance Variable のエクササイズとも連携した話。

    // #1on1: 変数とインスタンス (2026/07/17)
    // String sea = "mystic";
    // 変数にインスタンスがそのまま入っているわけではない。
    // アドレスというキーワード。
    // 変数の中には、アドレスしか入ってないイメージ。
    // seaの中には、"mystic" というインスタンスが存在するアドレスが書かれた紙があるだけ。
    // seaは "mystic" を指し示しているだけ。
    // プログラムを見たら、変数とインスタンスの関係性をイメージできるようになって欲しい。

    // #1on1: 隠れインスタンスでメモリ不足話 (2026/07/17)

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
    // #1on1: プリミティブ型は、変数はアドレスではなく、値そのものが入っている。 (2026/07/17)
    // (言語によっては、プリミティブ型を隠蔽して、すべてオブジェクト型にしているものもある)

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
    // done sato [ふぉろー] そんなバイトされていたんですね（＾＾。今度お話し聞かせてください笑 by jflute (2026/07/16)
    // 不変というキーワード素晴らしい、そこがポイントです。
    // add() で自分が変化するパターンと、変化結果を戻すだけのパターンと二つあるわけです。

    // 大学生のときに中高生にプログラミングを教えるアルバイトをしていました、MINECRAFTにMODを作る内容でjavaを簡単にですが教えていました
    // javaを教えるのとは別で、高校3年生の情報科目の教材サポート（質問に返答する仕事）をやっていて、丸め誤差とかの話も出てきましたね
    // 情報系なので授業でもやったはずなんですが、そっちはもう3年前とかなので忘れてしまっています
    // TODO sato [いいね] ありがとうございます。素晴らしい、良い経験ですね by jflute (2026/08/03)
    // 内容自体はさすがに忘れてしまうと思いますが、一度体験してることでコツみたいなのが体に染み込んで残ってたりするので。
    // また、教えるってのは言葉にするってことで、教える体験が理解を深めることになりますので、
    // 今後も人に教えるというか伝えるというのを意識して技術と向き合っていくと良いと思います。

    // add()の中ではnew BigDecimal(1)で新しいインスタンスを作って加算している
    // ただ前も書いた通りこの型は不変なので、add()すると新しいインスタンスとして返ってくる
    // 123行目の場合は、新しいインスタンスのアドレスがseaに代入されるので、中身が更新されたように見える
    // TODO sato [いいね] そう、中身が更新されたように見えるってのがポイントですね。 by jflute (2026/08/03)
    // immutableとmutableでは全然使い方が違うので注意なのです。

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
    // done sato [ふぉろー] Stringに限らずオブジェクト型全体がnull許容となります by jflute (2026/07/16)

    // String以外、例えばIntegerやコレクション（List）もnull許容
    // コレクションはイメージつきやすいけど、Integerはそもそもほとんどこれまで使ったことないのでイメージしづらいかもしれない
    // なぜnull許容なのか？ → オブジェクト型は値じゃなく、オブジェクトへの参照が入っている
    // nullでない場合は参照としてアドレスが入る
    // nullは「参照がないこと」を表すので、null許容になる
    // TODO sato [いいね] 変数の中身の意識でnull許容を考えるとはとてもGoodです by jflute (2026/08/03)
    // ちなみに、Listもnull許容ですが、世界的なマナーとしてやらないってのが浸透しています。
    // List<String> seaList = null;
    // みたいなの。for文でループ回す時にnullチェックをしないといけないってのが面倒だし、
    // リストという概念は、空っぽという概念も持っていますから、ないことは空っぽで表現すればいいよねみたいな。
    // こういうように、文法としては縛られてないけど、世界的なマナーで実質的なルールになっているものもあります。

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
    // done sato [ふぉろー] ここは言語としてのもう決めの話なんですね。 by jflute (2026/07/16)
    // オブジェクト型ではない「プリミティブ型」と言われるものは、デフォルト値が入ります。

    // なぜプリミティブ型（値が入るもの）にはデフォルト値が入る？
    // プリミティブ型はJavaの仕様として、デフォルト値が決まっている
    // オブジェクト型は参照（アドレス）が入るので、「参照先がないこと」を表すnullがデフォルト値になる
    // ローカル変数は自動で初期値入らないのでそれは注意

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
    // done sato [読み物課題] Java Beginner's Hint - プリミティブ型とラッパー型 by jflute (2026/07/16)
    // https://dbflute.seasar.org/ja/manual/topic/programming/java/beginners.html#primitivewrapper
    // ↑こちらぜひ読んでみてください。

    // nullが入らない型としてプリミティブ型を使う、っていう考え方があることに驚いた
    // Kotlinを業務で描くようになってnull許容を意識するようになったけど、これまでjavaを書いてきた中ではほとんど意識してなかった
    // Integer、intをStringに変換するときくらいしか使わないな
    // メソッドを使えるのはメリットの一つではあるけど、とはいえあまり使わないなと思った
    // TODO sato [ふぉろー] プリミティブ型をnullを防ぐ手段として使うのは、本当にたまたまですね。 by jflute (2026/08/03)
    // Javaの文法的にオブジェクト型で(コンパイルレベルで)nullを防ぐ手段がなかったので、
    // 若干文法の隙をついてそうやるようになったみたいな。
    // Kotlinは後に作られた言語なので、そこを見越して文法にnull可否を表現できるようにしたけですね。

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
    // done sato [ふぉろー] 厳密には「クラス変数」とは呼ばず「インスタンス変数」と呼ばれます by jflute (2026/07/16)
    // クラス全体にまたがってるからクラス変数と呼びたくなりますが、厳密にはインスタンスにまたがってる変数ということで。
    // 「クラス変数 (クラス全体にまたがってる)」となると、実は staticを付けた変数のことを差し示してしまいます。
    // (staticを付けた変数は、レアなので現時点ではそこまで意識しなくてもOKです)

    // 確かにクラス変数だとstatic変数のことを指すのか、いつもstatic変数と呼んでいたので忘れていました
    // インスタンス変数はインスタンスごとに値や参照を持っている
    // 逆にクラス変数は全てのインスタンスで共通の値や参照を持つ
    // ローカル変数とクラス変数が使用できる範囲（スコープ）を示しているように思えてしまうのが混乱する原因かもしれないですね
    // TODO sato [いいね] やっぱり "static変数" って呼んじゃいますよね笑。自然とそうなるのかな... by jflute (2026/08/03)
    // 確かに、ローカル変数とインスタンス変数はスコープを示しているように捉えても大丈夫ですが、
    // クラス変数(static)だけその感覚だとピンと来ないですよね。
    // クラス変数のクラスは、クラス内のコードというより設計図って概念のニュアンスが大きいのかも。
    // 設計事務所側のスコープということで、"全てのインスタンスで共通の値や参照を持つ" な感じに。

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
