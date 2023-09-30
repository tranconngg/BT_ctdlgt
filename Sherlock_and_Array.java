package BTtuan1CTGL;

public class Sherlock_and_Array {
    public static String balancedSums(List<Integer> arr) {
        int tongSum = 0;
        for (int num : arr) {
            tongSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            tongSum -= arr.get(i);
            if (leftSum == tongSum) {
                return "YES";
            }
            leftSum += arr.get(i);
        }

        return "NO";

    }
}
