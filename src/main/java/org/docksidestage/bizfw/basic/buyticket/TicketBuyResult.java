package org.docksidestage.bizfw.basic.buyticket;

import java.time.LocalTime;

// done sato クラスのJavaDocお願いします by jflute (2026/10/23)
/**
 * @author sato
 */
public class TicketBuyResult {
    // done sato handedMoney も final で良いのでは？ by jflute (2026/10/23)
    // 変更されないのでfinalにしました
    // TODO sato displayPrice, handedMoneyはgetterも用意してないので保持する必要がない by jflute (2026/11/06)
    // なので、インスタンス変数からは削除でOK。(or getter用意するとか)
    private final int displayPrice;
    private final int handedMoney;
    private final int change;
    private final Ticket ticket;

    // #1on1: どちらかというと、引数の方に良い名前を付けたほうが、呼び出し側が助かる。 (2026/11/06)
    // 一方で、this. を使ってどっちも良い名前にするっていうのが一般的。 
    // TODO sato 引数名、もう少しわかるような名前にしましょう by jflute (2026/11/06)
    public TicketBuyResult(int price, int money, LocalTime time) {
        displayPrice = price;
        handedMoney = money;
        change = handedMoney - displayPrice;
        ticket = new Ticket(displayPrice, time);
    }

    // done sato getChange()と同じように、Ticketの発行はここじゃない方が良いかなと by jflute (2026/10/23)
    // 同じようにコンストラクタで発行するようにしてみた
    public Ticket getTicket() {
        return ticket;
    }

    public int getChange() {
        // #1on1: お釣りの計算、getterで計算処理はあまりやらない (2026/10/23)
        // getってメソッドは、「そこにあるものをただ取るだけ」イメージ強い。
        // 読み手からするとそこで計算処理が入っているとは思わない。
        // ので、お釣りの計算処理どこだ？って探す時にちょっと探しづらい。(可読性)
        // また、呼び出し側で気軽に何度も呼ばれちゃう可能性もある。
        // (Resultが持ち回されてあっちでもこっちでもget/get/getされたり)
        // 結果は変わらないけど、パフォーマンスが変わる可能性がある。
        // もし、お釣りの計算がもっと複雑でちょっと重い処理だったり...
        // なんだったらDB見たり、リモートAPIコールしたり...ロジックである限りはそういう可能性も。
        // 許容範囲なのかどうかを考えるくらいなら、getでの計算は避けた方が世話ない。
        //
        // getは汎用的で抽象度が高いメソッド名とも言えるので...
        // もしここで計算するのであれば calcuateChange() って名前にしちゃうのもアリ。
        // (汎用的で抽象度が高くして隠蔽した時は話は別だけど、それはよほどのレイヤー意識があるときじゃないと)
        //
        // ただ、calcuateChange()のパターン、ここでは Result というクラスなので、
        // 結果という概念を表現するオブジェクトなので、単なる入れ物感が強い。
        // (結果はあくまで計算された結果を持っているだけで、結果自体が計算をするわけじゃないイメージ)
        //
        // もし、ResultCreator, ResultProvider っていうクラス名だったら話は変わってくる。
        // それだったら calcuateChange() 全然アリ。さらに、issueTicket() とかも。
        //
        // done sato なので、ここでの計算じゃなく別のところに by jflute (2026/10/23)

        // じゃあどこで計算すればいいんだ？を考えた時に、別メソッドを用意してもそれを呼ぶならあんまり変わらないしなあと思った
        // 現状の形ならコンストラクタ内で渡された金額とチケット金額が両方解ってるので、そこで計算するのがいいか？と思った
        return change;
    }

}