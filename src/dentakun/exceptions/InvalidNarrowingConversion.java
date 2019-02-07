package dentakun.exceptions;

// 縮小変換できないときに投げられる例外
// 整数のみを受け付ける関数に小数を入力したときなどに発生
@SuppressWarnings("serial")
public class InvalidNarrowingConversion extends RuntimeException {

}
