package org.example;

public class PasswordManager {
    private final String str1 = "Sony";
    private final String str2 = "Hewlett";
    private final String str3 = "Packard";
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private StringBuilder result;

    public PasswordManager(){
        this.result = new StringBuilder();
    }
    public void setResult(){
        // Step 1
        int i = getCountLettersIn1and3Str();
        if(i > 26){
            i = i % 26;
        }
        char a = getLetterFromIndex(i);
        result.append(a);

        // Step 2
        char b = getPreLastLetterIn2Str();
        result.append(b);

        // Step 3
        if(str3.length() % 2 == 1){ // нечетное
            char midlCharOfStr3 = str3.charAt(str3.length() / 2);
            if(midlCharOfStr3 == 'z'){
                result.append('a');
            }else {
                result.append(alphabet.charAt(alphabet.indexOf(midlCharOfStr3) + 1));
            }
        }else { // Четное
            char midlCharOfStr3 = str3.charAt(str3.length() / 2 - 1);
            if(midlCharOfStr3 == 'a'){
                result.append('z');
            }else {
                result.append(alphabet.charAt(alphabet.indexOf(midlCharOfStr3) - 1));
            }
        }

        // Step 4
        char firstCharAtSrt1 = str1.toLowerCase().charAt(0);
        if(firstCharAtSrt1 == 'Z'){
            result.append('a');
        }else {
            result.append(alphabet.charAt(alphabet.indexOf(firstCharAtSrt1) + 1));
        }
    }
    public char getPreLastLetterIn2Str(){
        char lastChar = str2.charAt(str2.length() - 1);
        if (lastChar == 'a'){
            return 'z';
        }
        return alphabet.charAt(alphabet.indexOf(lastChar) - 1);
    }
    public int getCountLettersIn1and3Str(){
        return str1.length() + str3.length();
    }
    public char getLetterFromIndex(int i){
        return alphabet.charAt(i);
    }

    //Getters
    public StringBuilder getResult() {
        return result;
    }
    public String getStr1() {
        return str1;
    }
    public String getStr2() {
        return str2;
    }
    public String getStr3() {
        return str3;
    }
}
