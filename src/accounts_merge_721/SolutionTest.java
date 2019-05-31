package accounts_merge_721;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "john_newyork@mail.com", "john_newyork111@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"));

        List<List<String>> mergedAccounts = solution.accountsMerge(accounts);
        System.out.println(mergedAccounts);
    }

    @Test
    public void test2() {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("David","David0@m.co","David4@m.co","David3@m.co"),
                Arrays.asList("David","David5@m.co","David5@m.co","David0@m.co"),
                Arrays.asList("David","David1@m.co","David4@m.co","David0@m.co"),
                Arrays.asList("David","David0@m.co","David1@m.co","David3@m.co"),
                Arrays.asList("David","David4@m.co","David1@m.co","David3@m.co")
        );

        List<List<String>> mergedAccounts = solution.accountsMerge(accounts);
        System.out.println(mergedAccounts);
    }

}