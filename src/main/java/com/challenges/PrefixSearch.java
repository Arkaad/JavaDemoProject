package com.challenges;

import java.util.ArrayList;
import java.util.List;

public class PrefixSearch {
    private static String _document = String.join("",
            "In publishing and graphic design, lorem ipsum is a ", "filler text commonly used to demonstrate thr graphic elements of a ",
            "document or a visual presentation. Replacing meaningful content that ", "could be distracting with placeholder text may allow viewers to focus ",
            "on graphic aspects such as font, typography, and page layout.It also ", "reduces the need for the designer to come up with meaningful text,as ",
            "they can instead use hastily generated lorem ipsum text.The lorem ",
            "ipsum text is typically a scrambled section of De finibus bonorum et ", "malorum,a 1st-century BC Latin text by Cicero,with words altered, ",
            "added, and removed to make it nonsensical,improper Latin. A variation ",
            "of ordinary lorem ipsum text has been used in typesetting since ", "the 1960s or earlier,when it is was popularized by advertisements for ",
            "Letraset transfer sheets. It was introduced to the Information Age in ", "the mid-1980s by aldus Corporation, which employed it in graphics and ",
            "word processing templates for its desktop publishing program, ",
            "PageMaker, for the Apple Macintosh. A common form of lorem ipsum ",
            "reads: lorem ipsum dolor sit emet, consectetur edipiscing elit, sed do",
            "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad ",
            "minim veniam, quis nostrud exercitation ullamco laboris nisi ut ",
            "aliquip ex ea commodo consequat. Duis aute irure dolor in ",
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla ",
            "pariatur. Excepteur sint occaecat cupidata non proident, sunt in ",
            "cupla qui officia deserunt mollit anim id est laborum");

    public static List<Integer> prefixSearch(String[] words, String prefix) {
        int indexLength = 0;
        List<Integer> prefixIndexes = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().startsWith(prefix.toLowerCase())) {
                prefixIndexes.add(indexLength);
            }
            indexLength += words[i].length();
            indexLength++;
        }
        return prefixIndexes;
    }

    public static void main(String[] args) {
//        System.out.println("_document = " + _document);
        System.out.println(prefixSearch(_document.split(" "), "in"));
    }
}
