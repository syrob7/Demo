package com.example.demo.stripper;

public class Stripper {
    public static void main(String[] args) {
        String html = "<div>\n" +
                "  <p>Hello</p> <span>World!</span>\n" +
                "  <div>\n" +
                "          <span>Viewed</span>\n" +
                "          57k times\n" +
                "  </div>\n" +
                "  <b>This is test</b>\n" +
                "</div>";

        System.out.println(stripHtmlTags(html));
    }

    public static String stripHtmlTags(String input) {
        boolean intag = false;
        String output = "";

        for (int ii = 0; ii < input.length(); ii++) {
            if (!intag && input.charAt(ii) == '<') {
                intag = true;
                continue;
            }
            if (intag && input.charAt(ii) == '>') {
                intag = false;
                continue;
            }
            if (!intag) {
                output = output + input.charAt(ii);
            }
        }

        return output;
    }
}
