package org.docksidestage.bizfw.basic.buyticket;

import java.time.LocalTime;

// #1on1: enumとは？ (2026/11/27)
// $種類...みたいな
// 今まではクラス(class/オブジェクト型)とか、intのようなプリミティブ型しか出てこなかったけど...
// enumというものが登場した。データ型としてクラスとかintと同じように扱うことができてる。
//
// int dockside = 7; // 値そのものが入っているイメージ
// String hangar = new String("mystic"); // "mystic"Stringインスタンスのアドレスが入っている
// TicketType sea = TicketType.ALL_DAY; // → (色々説明した後)アドレスが入ってる
// if (sea == TicketType.NIGHT_ONLY) { // 普通に判定も書ける
//     ...
// }
/*
public class TradTicketType {
    public static final TradTicketType ONE_DAY = new TradTicketType(...oneDay情報);
    public static final TradTicketType TWO_DAY = new TradTicketType(...twoDay情報);

    private TradTicketType() { // 他の人が新しいインスタンスを作れないようにする
    }
}

TradTicketType land = TradTicketType.ONE_DAY; // TradTicketTypeのインスタンスのアドレス
if (land == TicketType.ONE_DAY) { // "==" はインスタンスが同一かどうかを判定、アドレスが一致しているか？
}

// こうすると判定が破綻するけど、コンストラクターをprivateにすることで、そもそもこういうことができない
if (land == new TicketType(...oneDay情報)) { // これはfalse, インスタンスが違うから
}
 */
// 「アドレスが一致しているか？」は「インスタンスが同一かどうか？」とやってること同じ。
//
// enumの ALL_DAY, NIGHT_ONLY は、単なる定数定義と考えても良い。
// enumのコンストラクターは必ずprivate。
// というルールが加わった、ただのクラス。
// 「インスタンスの個数を限定したクラス」と言っても良い。
//
// enumで==判定してても、単にインスタンスの同一性を見ているだけ。(アドレスを比較しているだけ)
//
// enumは種類の識別のための識別子として、インスタンスの存在そのもの(アドレス)を識別子としている。
//
//
// #1on1: 種別っぽい概念が、ここでは二つあるということ (2026/11/27)
// o チケット種別 e.g. OneDay, TwoDay, ...
// o 入園時間帯種別 e.g. AllDay, NightOnly, ...
//
// #1on1: enumの二つ役割 (2026/11/27)
// o メインの役割: 識別すること enum TicketType { ALL_DAY, NIGHT_ONLY }
// o サブの役割: 要素ごとに参照データを持たせる e.g. { ALL_DAY(9), NIGHT_ONLY(17) }
//             (データを運ぶ箱の役割にもなる)
//
// TODO sato 業務で、区分値っぽいものを見つけてみてください。 by jflute (2026/11/27)

public enum TicketType {
    // #1on1: $どちらかというとチケットの種類で分けたかった!?(まだ整理付いていない) (2026/11/27)
    ALL_DAY(LocalTime.of(9, 0)), NIGHT_ONLY(LocalTime.of(17, 0));

    // ALL_DAYのインスタンスだったら 9 が入る。
    // NIGHT_ONLYのインスタンスだったら 17 が入る。
    private final LocalTime entryAvailableTime;

    TicketType(LocalTime entryAvailableTime) {
        this.entryAvailableTime = entryAvailableTime;
    }
}
