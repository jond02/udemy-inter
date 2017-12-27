package com.nwjon.udemy.general;

import java.util.ArrayList;
import java.util.List;

public class ChunkDocument {

    private static final String DELIMITER = ":";
    private static final int CHUNK_SIZE = 5;

    public static void main(String[] args) {

        final String doc = "a:bb:cc:abcdef:ab:c:d:";

        ChunkDocument chunkDocument = new ChunkDocument();

        List<String> list = chunkDocument.chunkify(doc);

        System.out.println(list);
    }


    private List<String> chunkify(String doc) {

        if (doc == null) {
            return null;
        }

        List<String> list = new ArrayList<>();
        String[] paragraphs = doc.split(DELIMITER);

        StringBuilder currentChunk = new StringBuilder();

        for (String para : paragraphs) {

            //check if adding current to para exceeds size.
            if (currentChunk.length() + para.length() > CHUNK_SIZE) {

                //if current increased the size then it should be added as it's own chunk
                if (currentChunk.length() > 0) {
                    list.add(currentChunk.toString());
                    currentChunk = new StringBuilder();
                }
            }

            //if para itself is longer than size add it to the list
            if (para.length() > CHUNK_SIZE) {

                //first add any chunk that might be remaining
                if (currentChunk.length() > 0) {
                    list.add(currentChunk.toString());
                    currentChunk = new StringBuilder();
                }

                //add delimited back so paragraph boundaries are kept
                list.add(para + DELIMITER);
                continue;
            }

            //add para and delimiter to chunk
            currentChunk.append(para).append(DELIMITER);
        }

        //add last chunk if it is present
        if (currentChunk.length() > 0) {
            list.add(currentChunk.toString());
        }

        return list;
    }


}
