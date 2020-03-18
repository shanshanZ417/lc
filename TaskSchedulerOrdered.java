public class Main {
    public static void main(String[] args) {
        char[] tasks = new char[]{'A','B','A','B','C','B'};
        int n = 3;
        Main test = new Main();
        System.out.println(test.leastInterval(tasks, n));
        
    }
    public int leastInterval(char[] tasks, int n) {
        int idle = 0;
        int[] mapper = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            int add = mapper[tasks[i] - 'A'];
            idle += add;
            for (int j = 0; j < 26; j++) {
                mapper[j] = Math.max(0, mapper[j] - add - 1);
            }
            mapper[tasks[i] - 'A'] = n;
        }
        return idle + tasks.length;
    }
        
}
/*
A 4
B 5
C 0
4 + 4
*/
// {'A','B','A','B','C','B'};
// A B _ A B C_B
