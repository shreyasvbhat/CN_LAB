import java.math.BigInteger;
import java.util.*;

class RSAalgorithm{
        BigInteger prk, puk, mod;

        void getkeys(int bitlen){
                Random r = new Random();
                BigInteger p = BigInteger.probablePrime(bitlen, r);
                BigInteger q = BigInteger.probablePrime(bitlen, r);
                mod = p.multiply(q);
                BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
                puk = BigInteger.probablePrime(bitlen/2, r);
                while(!phi.gcd(puk).equals(BigInteger.ONE) || puk.compareTo(phi) >= 0 ){
                        puk = BigInteger.probablePrime(bitlen/2, r);
                }
                prk = puk.modInverse(phi);
                //System.out.println("Public Key: ( e= " + puk + ", n = "+ mod + ")");
                //System.out.println("Private Key: ( d= " + prk + ", n = "+ mod + ")");
        }

        BigInteger encrypt(BigInteger m){
                return m.modPow(puk, mod);
        }

        BigInteger decrypt(BigInteger c){
                return c.modPow(prk, mod);
        }
}

class Lab7RSA{
        public static void main(String[] args){
                RSAalgorithm rsa = new RSAalgorithm();
                rsa.getkeys(512);
                //rsa.displaykeys();
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the message to be encrypted: ");
                BigInteger m = new BigInteger(sc.next().getBytes());
                BigInteger c = rsa.encrypt(m);
                System.out.println("Encrypted message: " + c.longValue());
                BigInteger d = rsa.decrypt(c);
                System.out.println("Decrypted message: " + new String(d.toByteArray()));
                sc.close();
        }
}