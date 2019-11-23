package Application.Question;

import Application.Configuration.Constants;
import Application.Configuration.PropertyUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Application.Configuration.Constants.ENCRYPTION_KEY;

public class Question {

    private Integer id;
    private String question;
    private String oneOption;
    private String twoOption;
    private String oneImage;
    private String twoImage;
    private String category;
    private String isnsfw;

    public Question() {

    }

    public Question(Integer id, String question, String oneOption, String twoOption,
                    String oneImage, String twoImage, String category, String isnsfw) {
        this.id = id;
        this.question = question;
        this.oneOption = oneOption;
        this.twoOption = twoOption;
        this.oneImage = oneImage;
        this.twoImage = twoImage;
        this.category = category;
        this.isnsfw = isnsfw;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {

        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOneOption() {
        return oneOption;
    }

    public void setOneOption(String oneOption) {
        this.oneOption = oneOption;
    }

    public String getTwoOption() {
        return twoOption;
    }

    public void setTwoOption(String twoOption) {
        this.twoOption = twoOption;
    }

    public String getOneImage() {
        return makeLink(oneImage);
    }

    public void setOneImage(String oneImage) {
        this.oneImage = oneImage;
    }

    public String getTwoImage() {
        return makeLink(twoImage);
    }

    public void setTwoImage(String twoImage) {
        this.twoImage = twoImage;
    }

    public List<String> getCategory() {
        return new ArrayList<String>(Arrays.asList(category.split(",")));
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsnsfw() {
        return isnsfw;
    }

    public void setIsnsfw(String isnsfw) {
        this.isnsfw = isnsfw;
    }

    private String makeLink(String link) {
        String url = "https://doesthisworkthree.s3.us-east-2.amazonaws.com/";
        return url + link.substring(link.lastIndexOf("/") + 1);
    }
}
