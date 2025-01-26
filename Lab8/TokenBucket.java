package Lab8;

import java.util.Scanner;

public class TokenBucket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: bucket size and token generation rate
        System.out.print("Enter bucket capacity (number of tokens): ");
        int bucketCapacity = scanner.nextInt();
        System.out.print("Enter token generation rate (tokens per second): ");
        int tokenRate = scanner.nextInt();

        // Input: number of packets and their sizes
        System.out.print("Enter the number of packets: ");
        int numPackets = scanner.nextInt();
        int[] packetSizes = new int[numPackets];
        System.out.println("Enter the packet sizes: ");
        for (int i = 0; i < numPackets; i++) {
            packetSizes[i] = scanner.nextInt();
        }

        int tokens = 0;
        int sent = 0;
        System.out.println("\nPacket Size\tTokens Available\tSent\tTokens Remaining\tStatus");
        for (int packetSize : packetSizes) {
            // Generate tokens for this iteration
            tokens = Math.min(tokens + tokenRate, bucketCapacity);

            // Check if packet can be processed
            if (packetSize <= tokens) {
                tokens -= packetSize;
                sent = packetSize;
                System.out.println(packetSize + "\t\t" + (tokens+packetSize) + "\t\t\t" + sent + "\t" + tokens +  "\t\t\tAccepted");
            } else {
                sent = 0;
                System.out.println(packetSize + "\t\t" + tokens + "\t\t\t" + sent + "\t" + tokens + "\t\t\tDropped");
            }
        }
        scanner.close();
    }
}
