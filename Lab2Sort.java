import java.util.*;

class Lab2Sort {
    static class Frame {
        String content;
        int fnum;

        Frame(int n, String S) {
            this.fnum = n;
            this.content = S;
        }
    }

    // Sorting function using bubble sort
    public static void sorting(int n, Frame[] F) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (F[j].fnum > F[j + 1].fnum) {
                    // Swap the frame details (fnum and content)
                    String s1 = F[j].content, s2 = F[j + 1].content;
                    int a = F[j].fnum, b = F[j + 1].fnum;
                    F[j].fnum = b;
                    F[j + 1].fnum = a;
                    F[j].content = s2;
                    F[j + 1].content = s1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of frames: ");
        int n = sc.nextInt();

        // Input frame details
        System.out.println("Enter the frame details:");
        Frame[] F = new Frame[n];
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter frame number: ");
            int a = sc.nextInt();
            System.out.print("Enter frame content: ");
            String b = sc.next();
            F[i] = new Frame(a, b);
        }

        // Convert array to a list, shuffle, and then convert back to array
        List<Frame> frameList = new ArrayList<>(Arrays.asList(F));
        Collections.shuffle(frameList);
        F = frameList.toArray(new Frame[0]);

        // Display shuffled frame content
        System.out.println("\nBefore Sorting (Shuffled frames):");
        for (int i = 0; i < n; i++) {
            System.out.print(F[i].content + " ");
        }

        // Sort the frames based on frame number
        sorting(n, F);

        // Display sorted frame content
        System.out.println("\n\nAfter Sorting the frames:");
        for (int i = 0; i < n; i++) {
            System.out.print(F[i].content + " ");
        }
        System.out.println();

        sc.close();
    }
}