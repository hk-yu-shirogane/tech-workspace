import java.util.Scanner;

public class ShippingCalculator {
    public static void main(String[] args) {
        // [A]: 「税抜価格」をユーザーから取得する
        Scanner scanner = new Scanner(System.in);
        System.out.print("税抜価格を入力してください: ");
        double taxExcludedPrice = scanner.nextDouble();

        // [B]: 「税込価格」を計算する（消費税率は10%）
        double taxRate = 0.10;
        double taxIncludedPrice = taxExcludedPrice * (1+taxRate);

        // [C]、[D]: 送料の計算（2000円以上かどうかを判定して分岐する）
        int shippingCost;
        if (taxIncludedPrice >= 2000) {
            shippingCost = 0;
            System.out.println("送料は無料です");
        } else {
            shippingCost = 350;
            System.out.printf("送料は%d円です%n", shippingCost);
        }

        // [E]: 送料込税込価格を計算して、変数に代入する
        double totalPrice = taxIncludedPrice + shippingCost;

        // 「送料込税込価格」を少数を含めずに出力する
        System.out.printf("送料込税込価格は%.0f円です%n", totalPrice);
    }
}
