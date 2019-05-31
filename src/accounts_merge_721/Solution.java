package accounts_merge_721;

import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] owners = unionOwners(accounts);

        int distinctAccounts = 0;
        Map<Integer, Integer> ownerNumberToIndexes = new HashMap<>();
        for (int owner: owners) {
            while (owner != owners[owner])
                owner = owners[owner];

            if (!ownerNumberToIndexes.containsKey(owner))
                ownerNumberToIndexes.put(owner, distinctAccounts++);
        }

        List<Set<String>> preResult = mergeEmails(accounts, owners, distinctAccounts, ownerNumberToIndexes);

        Map<Integer, String> indexToOwnerName = new HashMap<>();
        for (Map.Entry<Integer, Integer> ownerNumberToIndex: ownerNumberToIndexes.entrySet())
            indexToOwnerName.put(ownerNumberToIndex.getValue(), accounts.get(ownerNumberToIndex.getKey()).get(0));

        return convertToAccounts(preResult, indexToOwnerName);
    }

    private List<List<String>> convertToAccounts(
            List<Set<String>> preResult,
            Map<Integer, String> indexToName
    ) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < preResult.size(); i++) {
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(indexToName.get(i));
            mergedAccount.addAll(preResult.get(i));

            result.add(mergedAccount);
        }
        return result;
    }

    private List<Set<String>> mergeEmails(
            List<List<String>> accounts,
            int[] owners,
            int distinctAccounts,
            Map<Integer, Integer> ownerNumberToIndex
    ) {

        List<Set<String>> preResult = new ArrayList<>(distinctAccounts);
        for (int i = 0; i < distinctAccounts; i++)
            preResult.add(new TreeSet<>());

        for (int i = 0; i < owners.length; i++) {
            List<String> account = accounts.get(i);

            int owner = i;
            while (owner != owners[owner])
                owner = owners[owner];

            int targetIndex = ownerNumberToIndex.get(owner);
            for (int j = 1; j < account.size(); j++)
                preResult.get(targetIndex).add(account.get(j));
        }
        return preResult;
    }

    private int[] unionOwners(List<List<String>> accounts) {
        int[] owners = new int[accounts.size()];
        for (int i = 0; i < owners.length; i++)
            owners[i] = i;

        Map<String, Integer> emailToOwner = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++)
                if (emailToOwner.containsKey(account.get(j))) {
                    int mergeAccount = emailToOwner.get(account.get(j));
                    while(owners[mergeAccount] != mergeAccount)
                        mergeAccount = owners[mergeAccount];
                    owners[mergeAccount] = i;
                } else emailToOwner.put(account.get(j), i);
        }
        return owners;
    }
}