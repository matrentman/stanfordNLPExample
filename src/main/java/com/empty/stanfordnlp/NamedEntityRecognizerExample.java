package com.empty.stanfordnlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

// uses ner property
public class NamedEntityRecognizerExample {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String text = "Hey! My name is Michael Trentman and I have a friend his name is Tom. " +
                      "We both are living in Cincinnati, Ohio.";

        CoreDocument coreDocument = new CoreDocument(text);

        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabels = coreDocument.tokens();

        for (CoreLabel coreLabel : coreLabels) {
            String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);

            System.out.println(coreLabel.originalText() + " == " + ner);

        }
    }
}
