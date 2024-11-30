public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations
        String[] keywords = {"synergy", "disrupt", "leverage", "paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the keywords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i].toLowerCase();
            boolean foundKeyword = false;

            for (int j = 0; j < keywords.length; j++) {
                String keyword = keywords[j];
                int keywordLength = keyword.length();
                int sentenceLength = sentence.length();

                // check for the keyword
                for (int h = 0; h <= sentenceLength - keywordLength; h++) {
                    boolean match = true;

                    // Compare characters of the sentence with the keyword
                    for (int l = 0; l < keywordLength; l++) {
                        if (sentence.charAt(h + l) != keyword.charAt(l)) {
                            match = false;
                            break;
                        }
                    }

                    // print && break
                    if (match) {
                        System.out.println(sentences[i]);
                        foundKeyword = true;
                        break;
                    }
                }

                if (foundKeyword) {
                    break; // Stop checking for further keywords if one is found
                }
            }
        }
    }
}