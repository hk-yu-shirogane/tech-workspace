public class Basic {
    public static void main(String[] args) {
        // 各科目の点数を変数として定義
        int japanese = 85;  // 国語
        int math = 90;      // 数学
        int english = 75;   // 英語

        // 平均点を計算（小数のためdouble型で計算）
        double average = (japanese + math + english) / 3.0;

        // 結果を表示
        System.out.println("3科目の平均点は " + average + " 点です");
    }
}
