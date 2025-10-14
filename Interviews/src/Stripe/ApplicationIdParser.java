package Stripe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationIdParser {

    /**
     * You are given a string that encodes a list of application IDs.
     *
     * Each application ID is prefixed by the number of characters in that ID.
     * The format is: [length][APPLICATION_ID][length][APPLICATION_ID]...0
     * (ends with a terminating 0).
     *
     * Example:
     *   Input: "10A134141242 18 B124564356434567430"
     *
     * Step 1:
     *   Decode this string into a list of application IDs:
     *     Output: ["A134141242", "B12456435643456743"]
     *
     * Step 2:
     *   Filter the decoded list so that only whitelisted application IDs remain.
     *   Example:
     *     Whitelist: ["A134141242"]
     *     Final Output: ["A134141242"]
     *
     * Implement the method:
     *     List<String> parseAndFilterApplicationIds(String input, List<String> whitelist)
     *
     * Constraints:
     * - Input string always ends with '0'.
     * - Application IDs may have variable lengths.
     * - Whitelist may contain zero or more entries.
     */
    public static List<String> parseAndFilterApplicationIds(String input, List<String> whitelist) {
        // TODO: Implement logic here
        StringBuilder builderInput = new StringBuilder();
        StringBuilder builderResult = new StringBuilder();
        List<String> result = new ArrayList<>();

        try {
            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))) {
                    builderInput.append(input.charAt(i));
                } else {
                    int index = Integer.parseInt(builderInput.toString()) + i;
                    builderResult.append(input, i, index);
                    i = index - 1;
                    result.add(builderResult.toString());
                    builderInput = new StringBuilder();
                    builderResult = new StringBuilder();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result.stream().filter(whitelist::contains).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String input = "10A13414124218B124564356434567431A3K3J2PO";
        List<String> whitelist = List.of("A134141242", "A", "PO");

        List<String> result = parseAndFilterApplicationIds(input, whitelist);

        System.out.println(result); // Expected output: ["A134141242"]
    }
}