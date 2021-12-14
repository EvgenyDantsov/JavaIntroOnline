package com.evgeny.unit.workRegularTerms;

//Дана строка, содержащая следующий текст (xml-документ):
//<notes>
//<note id = "1">
//<to>Вася</to>
//<from>Света</from>
//<heading>Напоминание</heading>
//<body>Позвони мне завтра!</body>
//</note>
//<note id = "2">
//<to>Петя</to>
//<from>Маша</from>
//<heading>Важное напоминание</heading>
//<body/>
//</note>
//</notes>
//Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа
// и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
// Пользоваться готовыми парсерами XML для решения данной задачи нельзя.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskTwoRegular {
    public static void main(String[] args) {
        String string = "<notes > \r\n" +
                "   <note id = \"1\"> \r\n" +
                "       <to>Вася</to> \r\n" +
                "       <from>Света</from> \r\n" +
                "       <heading>Напоминание</heading> \r\n" +
                "       <body>Позвони мне завтра!</body> \r\n" +
                "   </note> \r\n" +
                "   <note id = \"2\"> \r\n" +
                "       <to>Петя</to> \r\n" +
                "       <from>Маша</from> \r\n" +
                "       <heading>Важное напоминание</heading> \r\n" +
                "       <body/> \r\n" +
                "   </note> \r\n" +
                "</notes> \r\n";
        analiserXmlDocument(string);
    }

    public static void analiserXmlDocument(String string) {
        Pattern pattern = Pattern.compile("(<[^\\/].*?[^\\/]?>(?<contentTeg>[\\r\\n]?.+?[\\r\\n]?)<\\/.*?>)" +
                "|(?<noBodyTag><.*?\\/>)|(?<openTeg><[A-Za-z]+.*?>)|(?<closeTeg><\\/.*?[^\\/]>)");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}