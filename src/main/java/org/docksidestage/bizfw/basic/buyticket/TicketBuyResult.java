package org.docksidestage.bizfw.basic.buyticket;

// TODO sato クラスのJavaDocお願いします by jflute (2026/10/23)
public class TicketBuyResult {
    // TODO sato handedMoney も final で良いのでは？ by jflute (2026/10/23)
    private final int displayPrice;
    private int handedMoney;

    public TicketBuyResult(int displayPrice, int money) {
        this.displayPrice = displayPrice;
        this.handedMoney = money;
    }

    // TODO sato getChange()と同じように、Ticketの発行はここじゃない方が良いかなと by jflute (2026/10/23)
    public Ticket getTicket() {
        Ticket passport = new Ticket(displayPrice);
        return passport;
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
        // TODO sato なので、ここでの計算じゃなく別のところに by jflute (2026/10/23)
        return handedMoney - displayPrice;
    }

}