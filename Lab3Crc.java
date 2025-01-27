import java.util.*;

public class Lab3Crc {
    public static String divide(char[] divident, char[] divisor) {
        int n = divident.length, m = divisor.length;

        for (int i = 0; i < n; i++) {
            if (divident[i] == '1') {
                if (n - i < m)
                    break;

                for (int j = 0; j < m; j++) {
                    divident[i + j] = divisor[j] == '0' ? divident[i + j] : divident[i + j] == '1' ? '0' : '1';
                }
            }
        }

        // returning remainder
        return new String(divident).substring(n - m + 1);
    }

    public static String encode(String data, String key) {
        // data + remainder
        return data + divide((data + "0".repeat(key.length() - 1)).toCharArray(), key.toCharArray());
    }

    public static boolean decode(String encodedData, String key) {
        // returns true if remainder contains all zeros(i.e, error free data)
        return divide(encodedData.toCharArray(), key.toCharArray()).contains("1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter binary key : ");
        String key = sc.next();
        System.out.println("Enter binary data :");

        // encode data
        System.out.println("Encoded data : " + encode(sc.next(), key));

        // decode data
        System.out.println("Enter binary encoded data : ");
        System.out.println(decode(sc.next(), key) ? "Error in the data" : "Data is error free");
    }
}