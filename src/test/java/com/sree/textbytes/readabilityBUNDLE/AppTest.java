package com.sree.textbytes.readabilityBUNDLE;

import com.sree.textbytes.network.HtmlFetcher;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {

       Article article = new Article();
        ContentExtractor ce = new ContentExtractor();
        HtmlFetcher htmlFetcher = new HtmlFetcher();
        String html = null;
        try {
           // html = htmlFetcher.getHtml("http://www.militarytimes.com/articles/burns-sees-vietnam-war-as-virus-documentary-as-vaccination", 0,"gbk");
            html = htmlFetcher.getHtml("http://www.gpowersoft.com/news/2437.htm", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        article = ce.extractContent(html, "ReadabilitySnack");

        try {
            System.out.println("article.getMetaDescription() " + article.getMetaDescription());
            System.out.println("article.getCanonicalLink() = " + article.getCanonicalLink());
            System.out.println("article.getMetaKeywords() = " + article.getMetaKeywords());
            System.out.println("article.getTopImage() = " + article.getTopImage());
            String title = StringEscapeUtils.unescapeHtml(article.getTitle()) ;
            System.out.println("title = " + title);
           // System.out.println(article.getRawHtml());
            FileUtils.writeStringToFile(new File("D:/1.html"), article.getCleanedArticleText());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Content : "+article.getCleanedArticleText());
    }
}
