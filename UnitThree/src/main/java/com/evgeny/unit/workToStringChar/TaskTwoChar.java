package com.evgeny.unit.workToStringChar;

//Замените в строке все вхождения 'word' на 'letter'.

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskTwoChar {
    public static void main(String[] args) {
        String string = "Word in word_word, last word how to say me. Wort or word.";
        Pattern pattern = Pattern.compile("word"); //шаблон поиска(по слову word)
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) { //поиск совпадений в тексте с шаблоном
            matcher.appendReplacement(stringBuffer, "letter"); //производиться объединение и замена на слово "letter"
        }
        matcher.appendTail(stringBuffer); //производиться объединение и замена, добавляется хвост строки
        string = stringBuffer.toString();
        System.out.println(string);
    }
}