package Lab8;

import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter bucket capacity: ");
        int bucketCapacity = scanner.nextInt();
        System.out.print("Enter output rate (packets per second): ");
        int outputRate = scanner.nextInt();
        System.out.print("Enter the number of packets: ");
        int numPackets = scanner.nextInt();
        int[] packetSizes = new int[numPackets];
        System.out.println("Enter the packet sizes: ");
        for (int i = 0; i < numPackets; i++) {
            packetSizes[i] = scanner.nextInt();
        }

        int currentBucketSize = 0;

        System.out.println("\nPacket Size\tBucket Size\tSent\tRemaining\tStatus");
        for (int packetSize : packetSizes) {
            if (currentBucketSize + packetSize <= bucketCapacity) {
                currentBucketSize += packetSize;
                System.out.println(packetSize + "\t\t" + currentBucketSize + "\t\t"+Math.min(outputRate,currentBucketSize)+"\t\t"+Math.max(0, currentBucketSize - outputRate)+"\t\tAccepted");
            } else {
                System.out.println(packetSize + "\t\t" + currentBucketSize+"\t\t"+Math.min(outputRate,currentBucketSize)+"\t\t"+Math.max(0, currentBucketSize - outputRate)+"\t\tDropped");
            }
            currentBucketSize = Math.max(0, currentBucketSize - outputRate);
        }
        scanner.close();
    }
}
