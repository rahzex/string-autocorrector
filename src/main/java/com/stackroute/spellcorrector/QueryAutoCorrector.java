package com.stackroute.spellcorrector;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

import java.io.IOException;
import java.util.List;

class QueryAutoCorrector {

    static String correctQuery(String query) throws IOException {

        JLanguageTool langTool = new JLanguageTool(new BritishEnglish());

        List<RuleMatch> matches = langTool.check(query);
        String correctedQuery = query;

        for (RuleMatch match : matches) {
            String incorrectWord = query.substring(match.getFromPos(),match.getToPos());
            String correctedWord = match.getSuggestedReplacements().get(0);

            if (match.getFromPos() == 0)
                correctedQuery = correctedQuery.replaceFirst(incorrectWord,correctedWord);
            else if (match.getToPos() == query.length())
                correctedQuery = correctedQuery.replaceFirst(" "+incorrectWord," "+correctedWord);
            else
                correctedQuery = correctedQuery.replaceFirst(" "+incorrectWord+" "," "+correctedWord+" ");
        }

        return correctedQuery;
    }
}
