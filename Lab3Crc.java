import java.util.*;

class Lab3Crc {
        public static String xor(String a, String b)
        {
                String result = "";
                int n = b.length();
                for (int i = 1; i < n; i++) {
                        if (a.charAt(i) == b.charAt(i))
                                result += "0";
                        else
                                result += "1";
                }

                return result;
        }

        public static String Mod2Div(String dividend, String divisor)
        {
                int curr = divisor.length();
                String tmp = dividend.substring(0, curr);
                int n = dividend.length();

                while (curr < n) {
                        if (tmp.charAt(0) == '1')
                                tmp = xor(divisor, tmp) + dividend.charAt(curr);
                        else
                                tmp= tmp + dividend.charAt(curr);
                        curr++;
                }

                if (tmp.charAt(0) == '1')
                        tmp = xor(divisor, tmp);

                return tmp;
        }

        public static void EncodeData(String data, String key)
        {
                int len = key.length();
                String appended_data = data + "0".repeat(len-1);
                String remainder = Mod2Div(appended_data, key);

                String codeword = data + remainder;
                System.out.println("Remainder : " + remainder);
                System.out.println( "Encoded Data (Data + Remainder) :" + codeword + "\n");
        }

        static void Receiver(String data, String key)
        {
                String currxor = Mod2Div(data, key);

                if (currxor.contains("1")) {
                        System.out.println("There is some error in data");
                } else {
                        System.out.println("Correct message received");
                }
        }
        public static void main(String[] args)
        {
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the data in binary format: ");
                String data =sc.next();

                System.out.println("Enter the key in binary format: ");
                String key = sc.next();

                System.out.println("\nSender side...");
                EncodeData(data, key);

                System.out.println("Enter data received :");
                data=sc.next();
                Receiver(data,key);
                sc.close();
}
}