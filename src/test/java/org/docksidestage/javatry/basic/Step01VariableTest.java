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
    // TODO sato 全く同じことを思った記憶があります by fujisawa (2026/08/13)
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
    // done sato [いいね] ありがとうございます。素晴らしい、良い経験ですね by jflute (2026/08/03)
    // 内容自体はさすがに忘れてしまうと思いますが、一度体験してることでコツみたいなのが体に染み込んで残ってたりするので。
    // また、教えるってのは言葉にするってことで、教える体験が理解を深めることになりますので、
    // 今後も人に教えるというか伝えるというのを意識して技術と向き合っていくと良いと思います。
    // #1on1: 技術を言葉にして人に伝える機会があったらぜひ積極的に (2026/08/03)

    // add()の中ではnew BigDecimal(1)で新しいインスタンスを作って加算している
    // ただ前も書いた通りこの型は不変なので、add()すると新しいインスタンスとして返ってくる
    // 123行目の場合は、新しいインスタンスのアドレスがseaに代入されるので、中身が更新されたように見える
    // done sato [いいね] そう、中身が更新されたように見えるってのがポイントですね。 by jflute (2026/08/03)
    // immutableとmutableでは全然使い方が違うので注意なのです。
    // #1on1: "中身が更新されたように見える" という表現が素晴らしい (2026/08/03)
    // 変数とインスタンスの関係性をしっかり理解している証拠。

    // done jflute 1on1にてimmutableのお話をする予定 (2026/07/16)
    // #1on1: immutable/mutableとは？ (2026/08/03)
    // immutableって言葉よく使う？ ($学生時代は聞いたこともほとんどない)
    // immutable (不変な)
    // o immutableなクラス(インスタンス) // default!?
    // o immutableな変数
    // 
    // immutableなクラス(インスタンス):
    // まさしくBigDecimalみたいなもので、インスタンス内の状態が絶対に変化しない特徴。
    // immutableなクラス == immutableな設計をしているクラス
    // immutableなインスタンス == その設計から作られてimmutableな特徴を持つインスタンス
    // BigDecimalのインスタンス変数を見るとfinalが付いてて状態が変わらないようになっている。
    // (もしくは、finalが付いてなくても、実質的に内部利用のみで外部に影響与える変化はしないケースも)
    //
    // immutableな変数:
    // finalが付いてて、再代入ができない変数。(Kotlinだとval)
    //
    // 変数もクラスもimmutableで、だぶるいみゅーたぶるだったら...
    // その変数(インスタンス)はずっと同じ値であることが保証される。
    // BigDecimalのintValの例をみてみた。(使ってるクラスのBigIntegerもimmutable)
    //
    // 後は、immutable/mutableのさらなる深掘りは後半エクササイズにて。
    //
    // #1on1: immutableのメリデメ (2026/08/21)
    // pp メリット
    // o 変えちゃいけない中身を変えられないので安心 → 安全性
    // o 読み飛ばしとかimmutableの情報を使って読み進められる → 可読性
    //   (安全なものは何かしらのルールの則ってる可能性高いので、可読性にもつながりやすい)
    //   (高級な絵画の例)
    //
    // pp デメリット
    // o $変えようとした時にインスタンスが増えちゃう、メモリ
    // o immutableは手間を掛けてimmutableにしているので、言語サポート(文法)など欲しい
    //
    // immutableの歴史
    // o 昔はメモリが貧弱だった → new/newするやり方は避ける傾向にあった
    // o 昔は言語の文法も貧弱だった
    // o 今やそれらは進化してデメリットが小さくなった
    //
    // (デメリットの大小は、時系列でも変わるし、場所でも変わる、相対的なもの)
    //
    // immutableのバランス
    // o 言語と組織と個人の文化に寄る
    // o Java: 歴史もあるし、コンセプトもあるしなので、8:2くらいの印象
    //  i jflute個人もそんな感覚でimmutable寄りだけど無理しない
    //  i ただ、mutable使う時は、別の方法で安全性や可読性をカバーしようと工夫する
    // o 他の言語はimmutable全推しorかなり推しもある。

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
    // done sato [いいね] 変数の中身の意識でnull許容を考えるとはとてもGoodです by jflute (2026/08/03)
    // ちなみに、Listもnull許容ですが、世界的なマナーとしてやらないってのが浸透しています。
    // List<String> seaList = null;
    // みたいなの。for文でループ回す時にnullチェックをしないといけないってのが面倒だし、
    // リストという概念は、空っぽという概念も持っていますから、ないことは空っぽで表現すればいいよねみたいな。
    // こういうように、文法としては縛られてないけど、世界的なマナーで実質的なルールになっているものもあります。
    // #1on1: 空リストなのか？Listの変数がnullなのか？それを業務的に区別する必要がないよねって話 (2026/08/03)
    // それがちゃんと浸透している。

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

    // #1on1: 業務的な0なのか？文法上のデフォルト0なのか？区別が付かないことが時々困る (2026/08/03)

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
    // #1on1: よく使われるプリミティブ型のお話 (2026/08/03)
    // (業務webサービスでは)int/longは両方よく使われる。booleanは、ほとんどプリミティブ型。

    // nullが入らない型としてプリミティブ型を使う、っていう考え方があることに驚いた
    // Kotlinを業務で描くようになってnull許容を意識するようになったけど、これまでjavaを書いてきた中ではほとんど意識してなかった
    // Integer、intをStringに変換するときくらいしか使わないな
    // メソッドを使えるのはメリットの一つではあるけど、とはいえあまり使わないなと思った
    // done sato [ふぉろー] プリミティブ型をnullを防ぐ手段として使うのは、本当にたまたまですね。 by jflute (2026/08/03)
    // Javaの文法的にオブジェクト型で(コンパイルレベルで)nullを防ぐ手段がなかったので、
    // 若干文法の隙をついてそうやるようになったみたいな。
    // Kotlinは後に作られた言語なので、そこを見越して文法にnull可否を表現できるようにしたわけですね。

    // #1on1: 曖昧な情報とか、感想とか評価とかは、なかなか本とかネット上では出てこない話 (2026/08/03)
    // なので、現場での先輩との会話とか、こういった1on1の場とかが重要になってくる。

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
    // done sato [いいね] やっぱり "static変数" って呼んじゃいますよね笑。自然とそうなるのかな... by jflute (2026/08/03)
    // 確かに、ローカル変数とインスタンス変数はスコープを示しているように捉えても大丈夫ですが、
    // クラス変数(static)だけその感覚だとピンと来ないですよね。
    // クラス変数のクラスは、クラス内のコードというより設計図って概念のニュアンスが大きいのかも。
    // 設計事務所側のスコープということで、"全てのインスタンスで共通の値や参照を持つ" な感じに。

    // ややこしいところなので、名前がスコープを示していると捉えるよりもきちんとそれぞれの意味を理解しておくべきですね

    // TODO jflute 次回↑ここの残りフォローする (2026/08/03)

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // done jflute 次回1on1にてimmutable/mutableのさらなる深掘り (2026/08/03)
    // あと、Kotlinのプログラムで、immutable/mutableなクラスを探してきてください。

    // MutableListはMutableって付いてますね、そのまま可変なリストという意味なのか
    // 基本的な型（StringとかIntとか）はJava同様Immutable
    // #1on1: 実際に使ってるわけじゃなく、Kotlinのクラスとして見つけた MutableList (2026/08/21)
    // #1on1: 現場でmutableはレアだと思われるので、見つけたら教えてください (2026/08/21)

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor"; // 6丁目6番地に"harbor"Stringインスタンス建てて、seaに6丁目6番地を書き込む
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => harbor416
    }
    // 不正解、正解はharbor
    // StringはImmutableなクラスなので、concatは文字列を結合し新しいインスタンスを返す
    // concatもだし、呼び出しているメソッドの中で変数が変わってもreturnとかをしてないから呼び出し元には影響がない
    // TODO sato どのエディタをつかっているかわからないですが、IntelliJだと、concatに警告がでますね。 by fujisawa (2026/08/13)

    // #1on1: じっくり図を見ながら変数とインスタンスの関係性を追ってみた (2026/08/21)
    // そして、Stringはimmutableなので、実はhelpメソッドを読まなくても答えが出ちゃう。
    // なので、immutableって読み手にとっての情報になる。だから可読性が良くなる。
    // immutableは一つの事象しか発生しない。helpで書き換えてない、という事象のみ。

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
        log(sea); // your answer? => harbor416
    }

    // 正解
    // StringBuilderはmutableなクラス（さっき見た）
    // mutableなクラスなのでseaの中身が変わる
    // mutableなクラスは同じオブジェクトを参照しており、オブジェクト自体を変更できるため、呼び出し元にも変更が見える
    // 一方、immutableなクラスは同じオブジェクトを参照していてもオブジェクト自体を更新できないため、新しいインスタンスが返る

    // #1on1: こっちはhelpメソッドを読まないと絶対に確定できない (2026/08/21)
    // なぜなら、mutableな引数だから、help内で書き換えてる、書き換えてないの二つの事象があり得るから。
    // mutableは読み手にとって、あまり情報にならない。(immutableに比べて)

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
        log(sea); // your answer? => harbor416
    }

    // 不正解、正解はharbor
    // seaがStringBuilderなのは変わらないと思ったからharbor416だと思った
    // でも下のメソッドで new して新しいインスタンスを作っているから、見ているオブジェクトが違うものになって上のメソッドのseaが変わらない
    // #1on1: Good, しっかり理解できています (2026/08/21)
    // ここでも絵画の例 (書き写した絵画に落書きしただけ)

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

    private int piari;

    public void test_variable_writing() {
        String sea = "mystic";
        Integer land = null;
        log(sea + "," + land + "," + piari);
    }

    // #1on1: サンプル変数名としてfoo,bar / hoge,fuga が良く使われる。 (2026/08/21)
    // foo, bar, baz, qux, quux, corge(だっけ), ...
    // なんか sea, land, piari, bonvo, dstore, amba, miraco, dohotel

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 次の条件を満たすプログラムを作成してください。
     *
     *   1. String型とStringBuilder型の変数をそれぞれ1つずつ用意する。
     *   2. それらを別のメソッドへ引数として渡す。
     *   3. 呼び出したメソッド内で、Stringには文字列結合を行い、StringBuilderには文字列追加を行う。
     *   4. メソッドから戻った後、呼び出し元の変数の中身を表示する。
     *   5. StringとStringBuilderで結果が異なる理由をコメントで説明する。
     *
     *   メソッドから値をreturnしない場合、StringとStringBuilderの値はそれぞれどうなるでしょうか？
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_variable_yourExercise() {
        String s = "test";
        StringBuilder sb = new StringBuilder("test");
        helpMethodYourExcercise(s, sb);
        log(s); // your answer? => test
        log(sb); // your answer? => test100
    }

    private void helpMethodYourExcercise(String s, StringBuilder sb) {
        int i = 100;
        s.concat(String.valueOf(i));
        sb.append(i);
    }

    // 復習
    // Stringはimmutableなクラスなので中身は変わらない
    // StringBuilderはmutableなクラスなので中身が変わる
}
