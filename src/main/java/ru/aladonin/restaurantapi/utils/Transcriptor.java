package ru.aladonin.restaurantapi.utils;


import com.ibm.icu.text.Transliterator;
import org.springframework.stereotype.Component;

@Component
public class    Transcriptor {

    private static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";

    private Transliterator toLatinTrans;


    public Transcriptor() {
        this.toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);;
    }

    public String russianToLatin(String text) {
        String result = toLatinTrans.transliterate(text);
        return result;
    }
}
