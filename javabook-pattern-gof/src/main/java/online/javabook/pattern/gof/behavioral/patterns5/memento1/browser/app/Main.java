package online.javabook.pattern.gof.behavioral.patterns5.memento1.browser.app;

import online.javabook.pattern.gof.behavioral.patterns5.memento1.browser.context.Browser;

public class Main {
    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.go("http://www.1.com");
        browser.go("http://www.2.com");
        browser.go("http://www.3.com");
        browser.go("http://www.4.com");
        browser.go("http://www.5.com");
        browser.go("http://www.6.com");

        browser.back();
        browser.back();
        browser.back();
        browser.back();
        browser.back();
        browser.back();
        browser.back();

        browser.forward();
        browser.forward();
        browser.forward();
        browser.forward();
        browser.forward();
        browser.forward();
        browser.forward();

        browser.back();
        browser.back();
        browser.back();

    }
}
