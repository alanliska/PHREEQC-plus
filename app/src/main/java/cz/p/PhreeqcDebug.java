package cz.p;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PhreeqcDebug extends DevMode {

    private Handler handler = new Handler();
    private TextView InputFileLabel;
    private EditText InputFile;
    private TextView DatabaseFileLabel;
    private EditText DatabaseFile;
    private TextView OutputViewLabel;
    private EditText outputView2;
    Button RunProgram;
    Button Highlight;
    Button Quit;

    /**
     * Colorize a specific substring in a string for TextView. Use it like this: <pre>
     * textView.setText(
     *     Strings.colorized("The some words are black some are the default.","black", Color.BLACK),
     *     TextView.BufferType.SPANNABLE
     * );
     * </pre>
     * @param text Text that contains a substring to colorize
     * @param word0 The substring to colorize
     * @param word1 The substring to colorize
     * @param word2 The substring to colorize
     * @param word3 The substring to colorize
     * @param word4 The substring to colorize
     * @param word5 The substring to colorize
     * @param word6 The substring to colorize
     * @param word7 The substring to colorize
     * @param word8 The substring to colorize
     * @param word9 The substring to colorize
     * @param word10 The substring to colorize
     * @param word11 The substring to colorize
     * @param word12 The substring to colorize
     * @param argb The color
     * @return the Spannable for TextView's consumption
     */
    public static Spannable colorized(final String text, final String word0, final String word1, final String word2, final String word3, final String word4, final String word5, final String word6, final String word7, final String word8, final String word9, final String word10, final String word11, final String word12, final int argb) {
        final Spannable spannable = new SpannableString(text);
        int substringStart0=0;
        int substringStart1=0;
        int substringStart2=0;
        int substringStart3=0;
        int substringStart4=0;
        int substringStart5=0;
        int substringStart6=0;
        int substringStart7=0;
        int substringStart8=0;
        int substringStart9=0;
        int substringStart10=0;
        int substringStart11=0;
        int substringStart12=0;
        int start0;
        int start1;
        int start2;
        int start3;
        int start4;
        int start5;
        int start6;
        int start7;
        int start8;
        int start9;
        int start10;
        int start11;
        int start12;
        while((start0=text.indexOf(word0,substringStart0))>=0){
            spannable.setSpan(
                    new ForegroundColorSpan(argb),start0,start0+word0.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            while((start1=text.indexOf(word1,substringStart1))>=0) {
                spannable.setSpan(
                        new ForegroundColorSpan(argb), start1, start1 + word1.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                while((start2=text.indexOf(word2,substringStart2))>=0) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb), start2, start2 + word2.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                    while((start3=text.indexOf(word3,substringStart3))>=0) {
                        spannable.setSpan(
                                new ForegroundColorSpan(argb), start3, start3 + word3.length(),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                        while((start4=text.indexOf(word4,substringStart4))>=0) {
                            spannable.setSpan(
                                    new ForegroundColorSpan(argb), start4, start4 + word4.length(),
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            );
                            while((start5=text.indexOf(word5,substringStart5))>=0) {
                                spannable.setSpan(
                                        new ForegroundColorSpan(argb), start5, start5 + word5.length(),
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                );
                                while((start6=text.indexOf(word6,substringStart6))>=0) {
                                    spannable.setSpan(
                                            new ForegroundColorSpan(argb), start6, start6 + word6.length(),
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    );
                                    while((start7=text.indexOf(word7,substringStart7))>=0) {
                                        spannable.setSpan(
                                                new ForegroundColorSpan(argb), start7, start7 + word7.length(),
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                        );
                                        while((start8=text.indexOf(word8,substringStart8))>=0) {
                                            spannable.setSpan(
                                                    new ForegroundColorSpan(argb), start8, start8 + word8.length(),
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                            );
                                            while((start9=text.indexOf(word9,substringStart9))>=0) {
                                                spannable.setSpan(
                                                        new ForegroundColorSpan(argb), start9, start9 + word9.length(),
                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                );
                                                while((start10=text.indexOf(word10,substringStart10))>=0) {
                                                    spannable.setSpan(
                                                            new ForegroundColorSpan(argb), start10, start10 + word10.length(),
                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                    );
                                                    while((start11=text.indexOf(word11,substringStart11))>=0) {
                                                        spannable.setSpan(
                                                                new ForegroundColorSpan(argb), start11, start11 + word11.length(),
                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                        );
                                                        while((start12=text.indexOf(word12,substringStart12))>=0) {
                                                            spannable.setSpan(
                                                                    new ForegroundColorSpan(argb), start12, start12 + word12.length(),
                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                            );
                                                            substringStart12 = start12 + word12.length();
                                                        }
                                                        substringStart11 = start11 + word11.length();
                                                    }
                                                    substringStart10 = start10 + word10.length();
                                                }
                                                substringStart9 = start9 + word9.length();
                                            }
                                            substringStart8 = start8+word8.length();
                                        }
                                        substringStart7 = start7+word7.length();
                                    }
                                    substringStart6 = start6+word6.length();
                                }
                                substringStart5 = start5+word5.length();
                            }
                            substringStart4 = start4+word4.length();
                        }
                        substringStart3 = start3+word3.length();
                    }
                    substringStart2 = start2+word2.length();
                }
                substringStart1 = start1+word1.length();
            }
            substringStart0 = start0+word0.length();
        }
        return spannable;
    }

    // does not work with keywords...:
//    public static Spannable colorizedPhreeqc(final String text, final String digit0, final String digit1, final String digit2, final String digit3, final String digit4, final String digit5, final String digit6, final String digit7, final String digit8, final String digit9, final String digit10, final String digit11, final String digit12, final int digit_rgb, final String keyw13, final String keyw14, final String keyw15, final String keyw16, final String keyw17, final String keyw18, final String keyw19, final String keyw20, final String keyw21, final String keyw22, final String keyw23, final String keyw24, final String keyw25, final String keyw26, final String keyw27, final String keyw28, final String keyw29, final String keyw30, final String keyw31, final String keyw32, final String keyw33, final String keyw34, final String keyw35, final String keyw36, final String keyw37, final String keyw38, final String keyw39, final String keyw40, final String keyw41, final String keyw42, final String keyw43, final String keyw44, final String keyw45, final String keyw46, final String keyw47, final String keyw48, final String keyw49, final String keyw50, final String keyw51, final String keyw52, final String keyw53, final String keyw54, final String keyw55, final String keyw56, final String keyw57, final String keyw58, final String keyw59, final String keyw60, final String keyw61, final String keyw62, final String keyw63, final String keyw64, final String keyw65, final String keyw66, final String keyw67, final String keyw68, int keyw_rgb) {        final Spannable spannable = new SpannableString(text);
//        int substringStart0=0;
//        int substringStart1=0;
//        int substringStart2=0;
//        int substringStart3=0;
//        int substringStart4=0;
//        int substringStart5=0;
//        int substringStart6=0;
//        int substringStart7=0;
//        int substringStart8=0;
//        int substringStart9=0;
//        int substringStart10=0;
//        int substringStart11=0;
//        int substringStart12=0;
//        int substringStart13=0;
//        int substringStart14=0;
//        int substringStart15=0;
//        int substringStart16=0;
//        int substringStart17=0;
//        int substringStart18=0;
//        int substringStart19=0;
//        int substringStart20=0;
//        int substringStart21=0;
//        int substringStart22=0;
//        int substringStart23=0;
//        int substringStart24=0;
//        int substringStart25=0;
//        int substringStart26=0;
//        int substringStart27=0;
//        int substringStart28=0;
//        int substringStart29=0;
//        int substringStart30=0;
//        int substringStart31=0;
//        int substringStart32=0;
//        int substringStart33=0;
//        int substringStart34=0;
//        int substringStart35=0;
//        int substringStart36=0;
//        int substringStart37=0;
//        int substringStart38=0;
//        int substringStart39=0;
//        int substringStart40=0;
//        int substringStart41=0;
//        int substringStart42=0;
//        int substringStart43=0;
//        int substringStart44=0;
//        int substringStart45=0;
//        int substringStart46=0;
//        int substringStart47=0;
//        int substringStart48=0;
//        int substringStart49=0;
//        int substringStart50=0;
//        int substringStart51=0;
//        int substringStart52=0;
//        int substringStart53=0;
//        int substringStart54=0;
//        int substringStart55=0;
//        int substringStart56=0;
//        int substringStart57=0;
//        int substringStart58=0;
//        int substringStart59=0;
//        int substringStart60=0;
//        int substringStart61=0;
//        int substringStart62=0;
//        int substringStart63=0;
//        int substringStart64=0;
//        int substringStart65=0;
//        int substringStart66=0;
//        int substringStart67=0;
//        int substringStart68=0;
//        int start0;
//        int start1;
//        int start2;
//        int start3;
//        int start4;
//        int start5;
//        int start6;
//        int start7;
//        int start8;
//        int start9;
//        int start10;
//        int start11;
//        int start12;
//        int start13;
//        int start14;
//        int start15;
//        int start16;
//        int start17;
//        int start18;
//        int start19;
//        int start20;
//        int start21;
//        int start22;
//        int start23;
//        int start24;
//        int start25;
//        int start26;
//        int start27;
//        int start28;
//        int start29;
//        int start30;
//        int start31;
//        int start32;
//        int start33;
//        int start34;
//        int start35;
//        int start36;
//        int start37;
//        int start38;
//        int start39;
//        int start40;
//        int start41;
//        int start42;
//        int start43;
//        int start44;
//        int start45;
//        int start46;
//        int start47;
//        int start48;
//        int start49;
//        int start50;
//        int start51;
//        int start52;
//        int start53;
//        int start54;
//        int start55;
//        int start56;
//        int start57;
//        int start58;
//        int start59;
//        int start60;
//        int start61;
//        int start62;
//        int start63;
//        int start64;
//        int start65;
//        int start66;
//        int start67;
//        int start68;
//        while((start0=text.indexOf(digit0,substringStart0))>=0){
//            spannable.setSpan(
//                    new ForegroundColorSpan(digit_rgb),start0,start0+digit0.length(),
//                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//            );
//            while((start1=text.indexOf(digit1,substringStart1))>=0) {
//                spannable.setSpan(
//                        new ForegroundColorSpan(digit_rgb), start1, start1 + digit1.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
//                while((start2=text.indexOf(digit2,substringStart2))>=0) {
//                    spannable.setSpan(
//                            new ForegroundColorSpan(digit_rgb), start2, start2 + digit2.length(),
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
//                    while((start3=text.indexOf(digit3,substringStart3))>=0) {
//                        spannable.setSpan(
//                                new ForegroundColorSpan(digit_rgb), start3, start3 + digit3.length(),
//                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                        );
//                        while((start4=text.indexOf(digit4,substringStart4))>=0) {
//                            spannable.setSpan(
//                                    new ForegroundColorSpan(digit_rgb), start4, start4 + digit4.length(),
//                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                            );
//                            while((start5=text.indexOf(digit5,substringStart5))>=0) {
//                                spannable.setSpan(
//                                        new ForegroundColorSpan(digit_rgb), start5, start5 + digit5.length(),
//                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                );
//                                while((start6=text.indexOf(digit6,substringStart6))>=0) {
//                                    spannable.setSpan(
//                                            new ForegroundColorSpan(digit_rgb), start6, start6 + digit6.length(),
//                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                    );
//                                    while((start7=text.indexOf(digit7,substringStart7))>=0) {
//                                        spannable.setSpan(
//                                                new ForegroundColorSpan(digit_rgb), start7, start7 + digit7.length(),
//                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                        );
//                                        while((start8=text.indexOf(digit8,substringStart8))>=0) {
//                                            spannable.setSpan(
//                                                    new ForegroundColorSpan(digit_rgb), start8, start8 + digit8.length(),
//                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                            );
//                                            while((start9=text.indexOf(digit9,substringStart9))>=0) {
//                                                spannable.setSpan(
//                                                        new ForegroundColorSpan(digit_rgb), start9, start9 + digit9.length(),
//                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                );
//                                                while((start10=text.indexOf(digit10,substringStart10))>=0) {
//                                                    spannable.setSpan(
//                                                            new ForegroundColorSpan(digit_rgb), start10, start10 + digit10.length(),
//                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                    );
//                                                    while((start11=text.indexOf(digit11,substringStart11))>=0) {
//                                                        spannable.setSpan(
//                                                                new ForegroundColorSpan(digit_rgb), start11, start11 + digit11.length(),
//                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                        );
//                                                        while((start12=text.indexOf(digit12,substringStart12))>=0) {
//                                                            spannable.setSpan(
//                                                                    new ForegroundColorSpan(digit_rgb), start12, start12 + digit12.length(),
//                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                            );
//                                                            while((start13=text.indexOf(keyw13,substringStart13))>=0) {
//                                                                spannable.setSpan(
//                                                                        new ForegroundColorSpan(keyw_rgb), start13, start13 + keyw13.length(),
//                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                );
//                                                                while((start14=text.indexOf(keyw14,substringStart14))>=0) {
//                                                                    spannable.setSpan(
//                                                                            new ForegroundColorSpan(keyw_rgb), start14, start14 + keyw14.length(),
//                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                    );
//                                                                    while((start15=text.indexOf(keyw15,substringStart15))>=0) {
//                                                                        spannable.setSpan(
//                                                                                new ForegroundColorSpan(keyw_rgb), start15, start15 + keyw15.length(),
//                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                        );
//                                                                        while((start16=text.indexOf(keyw16,substringStart16))>=0) {
//                                                                            spannable.setSpan(
//                                                                                    new ForegroundColorSpan(keyw_rgb), start16, start16 + keyw16.length(),
//                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                            );
//                                                                            while((start17=text.indexOf(keyw17,substringStart17))>=0) {
//                                                                                spannable.setSpan(
//                                                                                        new ForegroundColorSpan(keyw_rgb), start17, start17 + keyw17.length(),
//                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                );
//                                                                                while((start18=text.indexOf(keyw18,substringStart18))>=0) {
//                                                                                    spannable.setSpan(
//                                                                                            new ForegroundColorSpan(keyw_rgb), start18, start18 + keyw18.length(),
//                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                    );
//                                                                                    while((start19=text.indexOf(keyw19,substringStart19))>=0) {
//                                                                                        spannable.setSpan(
//                                                                                                new ForegroundColorSpan(keyw_rgb), start19, start19 + keyw19.length(),
//                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                        );
//                                                                                        while((start20=text.indexOf(keyw20,substringStart20))>=0) {
//                                                                                            spannable.setSpan(
//                                                                                                    new ForegroundColorSpan(keyw_rgb), start20, start20 + keyw20.length(),
//                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                            );
//                                                                                            while((start21=text.indexOf(keyw21,substringStart21))>=0) {
//                                                                                                spannable.setSpan(
//                                                                                                        new ForegroundColorSpan(keyw_rgb), start21, start21 + keyw21.length(),
//                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                );
//                                                                                                while((start22=text.indexOf(keyw22,substringStart22))>=0) {
//                                                                                                    spannable.setSpan(
//                                                                                                            new ForegroundColorSpan(keyw_rgb), start22, start22 + keyw22.length(),
//                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                    );
//                                                                                                    while((start23=text.indexOf(keyw23,substringStart23))>=0) {
//                                                                                                        spannable.setSpan(
//                                                                                                                new ForegroundColorSpan(keyw_rgb), start23, start23 + keyw23.length(),
//                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                        );
//                                                                                                        while((start24=text.indexOf(keyw24,substringStart24))>=0) {
//                                                                                                            spannable.setSpan(
//                                                                                                                    new ForegroundColorSpan(keyw_rgb), start24, start24 + keyw24.length(),
//                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                            );
//                                                                                                            while((start25=text.indexOf(keyw25,substringStart25))>=0) {
//                                                                                                                spannable.setSpan(
//                                                                                                                        new ForegroundColorSpan(keyw_rgb), start25, start25 + keyw25.length(),
//                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                );
//                                                                                                                while((start26=text.indexOf(keyw26,substringStart26))>=0) {
//                                                                                                                    spannable.setSpan(
//                                                                                                                            new ForegroundColorSpan(keyw_rgb), start26, start26 + keyw26.length(),
//                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                    );
//                                                                                                                        while((start27=text.indexOf(keyw27,substringStart27))>=0) {
//                                                                                                                            spannable.setSpan(
//                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start27, start27 + keyw27.length(),
//                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                            );
//                                                                                                                            while((start28=text.indexOf(keyw28,substringStart28))>=0) {
//                                                                                                                                spannable.setSpan(
//                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start28, start28 + keyw28.length(),
//                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                );
//                                                                                                                                while((start29=text.indexOf(keyw29,substringStart29))>=0) {
//                                                                                                                                    spannable.setSpan(
//                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start29, start29 + keyw29.length(),
//                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                    );
//                                                                                                                                    while((start30=text.indexOf(keyw30,substringStart30))>=0) {
//                                                                                                                                        spannable.setSpan(
//                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start30, start30 + keyw30.length(),
//                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                        );
//                                                                                                                                        while((start31=text.indexOf(keyw31,substringStart31))>=0) {
//                                                                                                                                            spannable.setSpan(
//                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start31, start31 + keyw31.length(),
//                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                            );
//                                                                                                                                            while((start32=text.indexOf(keyw32,substringStart32))>=0) {
//                                                                                                                                                spannable.setSpan(
//                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start32, start32 + keyw32.length(),
//                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                );
//                                                                                                                                                while((start33=text.indexOf(keyw33,substringStart33))>=0) {
//                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start33, start33 + keyw33.length(),
//                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                    );
//                                                                                                                                                    while((start34=text.indexOf(keyw34,substringStart34))>=0) {
//                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start34, start34 + keyw34.length(),
//                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                        );
//                                                                                                                                                        while((start35=text.indexOf(keyw35,substringStart35))>=0) {
//                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start35, start35 + keyw35.length(),
//                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                            );
//                                                                                                                                                            while((start36=text.indexOf(keyw36,substringStart36))>=0) {
//                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start36, start36 + keyw36.length(),
//                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                );
//                                                                                                                                                                while((start37=text.indexOf(keyw37,substringStart37))>=0) {
//                                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start37, start37 + keyw37.length(),
//                                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                    );
//                                                                                                                                                                    while((start38=text.indexOf(keyw38,substringStart38))>=0) {
//                                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start38, start38 + keyw38.length(),
//                                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                        );
//                                                                                                                                                                        while((start39=text.indexOf(keyw39,substringStart39))>=0) {
//                                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start39, start39 + keyw39.length(),
//                                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                            );
//                                                                                                                                                                            while((start40=text.indexOf(keyw40,substringStart40))>=0) {
//                                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start40, start40 + keyw40.length(),
//                                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                );
//                                                                                                                                                                                while((start41=text.indexOf(keyw41,substringStart41))>=0) {
//                                                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start41, start41 + keyw41.length(),
//                                                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                    );
//                                                                                                                                                                                    while((start42=text.indexOf(keyw42,substringStart42))>=0) {
//                                                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start42, start42 + keyw42.length(),
//                                                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                        );
//                                                                                                                                                                                        while((start43=text.indexOf(keyw43,substringStart43))>=0) {
//                                                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start43, start43 + keyw43.length(),
//                                                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                            );
//                                                                                                                                                                                            while((start44=text.indexOf(keyw44,substringStart44))>=0) {
//                                                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start44, start44 + keyw44.length(),
//                                                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                );
//                                                                                                                                                                                                while((start45=text.indexOf(keyw45,substringStart45))>=0) {
//                                                                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start45, start45 + keyw45.length(),
//                                                                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                    );
//                                                                                                                                                                                                    while((start46=text.indexOf(keyw46,substringStart46))>=0) {
//                                                                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start46, start46 + keyw46.length(),
//                                                                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                        );
//                                                                                                                                                                                                        while((start47=text.indexOf(keyw47,substringStart47))>=0) {
//                                                                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start47, start47 + keyw47.length(),
//                                                                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                            );
//                                                                                                                                                                                                            while((start48=text.indexOf(keyw48,substringStart48))>=0) {
//                                                                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start48, start48 + keyw48.length(),
//                                                                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                );
//                                                                                                                                                                                                                while((start49=text.indexOf(keyw49,substringStart49))>=0) {
//                                                                                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start49, start49 + keyw49.length(),
//                                                                                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                    );
//                                                                                                                                                                                                                    while((start50=text.indexOf(keyw50,substringStart50))>=0) {
//                                                                                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start50, start50 + keyw50.length(),
//                                                                                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                        );
//                                                                                                                                                                                                                        while((start51=text.indexOf(keyw51,substringStart51))>=0) {
//                                                                                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start51, start51 + keyw51.length(),
//                                                                                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                            );
//                                                                                                                                                                                                                            while((start52=text.indexOf(keyw52,substringStart52))>=0) {
//                                                                                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start52, start52 + keyw52.length(),
//                                                                                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                );
//                                                                                                                                                                                                                                while((start53=text.indexOf(keyw53,substringStart53))>=0) {
//                                                                                                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start53, start53 + keyw53.length(),
//                                                                                                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                    );
//                                                                                                                                                                                                                                    while((start54=text.indexOf(keyw54,substringStart54))>=0) {
//                                                                                                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start54, start54 + keyw54.length(),
//                                                                                                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                        );
//                                                                                                                                                                                                                                        while((start55=text.indexOf(keyw55,substringStart55))>=0) {
//                                                                                                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start55, start55 + keyw55.length(),
//                                                                                                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                            );
//                                                                                                                                                                                                                                            while((start56=text.indexOf(keyw56,substringStart56))>=0) {
//                                                                                                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start56, start56 + keyw56.length(),
//                                                                                                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                );
//                                                                                                                                                                                                                                                while((start57=text.indexOf(keyw57,substringStart57))>=0) {
//                                                                                                                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start57, start57 + keyw57.length(),
//                                                                                                                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                    );
//                                                                                                                                                                                                                                                    while((start58=text.indexOf(keyw58,substringStart58))>=0) {
//                                                                                                                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start58, start58 + keyw58.length(),
//                                                                                                                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                        );
//                                                                                                                                                                                                                                                        while((start59=text.indexOf(keyw59,substringStart59))>=0) {
//                                                                                                                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start59, start59 + keyw59.length(),
//                                                                                                                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                            );
//                                                                                                                                                                                                                                                            while((start60=text.indexOf(keyw60,substringStart60))>=0) {
//                                                                                                                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start60, start60 + keyw60.length(),
//                                                                                                                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                );
//                                                                                                                                                                                                                                                                while((start61=text.indexOf(keyw61,substringStart61))>=0) {
//                                                                                                                                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start61, start61 + keyw61.length(),
//                                                                                                                                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                    );
//                                                                                                                                                                                                                                                                    while((start62=text.indexOf(keyw62,substringStart62))>=0) {
//                                                                                                                                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start62, start62 + keyw62.length(),
//                                                                                                                                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                        );
//                                                                                                                                                                                                                                                                        while((start63=text.indexOf(keyw63,substringStart63))>=0) {
//                                                                                                                                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start63, start63 + keyw63.length(),
//                                                                                                                                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                            );
//                                                                                                                                                                                                                                                                            while((start64=text.indexOf(keyw64,substringStart64))>=0) {
//                                                                                                                                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start64, start64 + keyw64.length(),
//                                                                                                                                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                                );
//                                                                                                                                                                                                                                                                                while((start65=text.indexOf(keyw65,substringStart65))>=0) {
//                                                                                                                                                                                                                                                                                    spannable.setSpan(
//                                                                                                                                                                                                                                                                                            new ForegroundColorSpan(keyw_rgb), start65, start65 + keyw65.length(),
//                                                                                                                                                                                                                                                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                                    );
//                                                                                                                                                                                                                                                                                    while((start66=text.indexOf(keyw66,substringStart66))>=0) {
//                                                                                                                                                                                                                                                                                        spannable.setSpan(
//                                                                                                                                                                                                                                                                                                new ForegroundColorSpan(keyw_rgb), start66, start66 + keyw66.length(),
//                                                                                                                                                                                                                                                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                                        );
//                                                                                                                                                                                                                                                                                        while((start67=text.indexOf(keyw67,substringStart67))>=0) {
//                                                                                                                                                                                                                                                                                            spannable.setSpan(
//                                                                                                                                                                                                                                                                                                    new ForegroundColorSpan(keyw_rgb), start67, start67 + keyw67.length(),
//                                                                                                                                                                                                                                                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                                            );
//                                                                                                                                                                                                                                                                                            while((start68=text.indexOf(keyw68,substringStart68))>=0) {
//                                                                                                                                                                                                                                                                                                spannable.setSpan(
//                                                                                                                                                                                                                                                                                                        new ForegroundColorSpan(keyw_rgb), start68, start68 + keyw68.length(),
//                                                                                                                                                                                                                                                                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                                                                                                                                                                                                                                                                            );
//                                                                                                                                                                                                                                                                                            substringStart68 = start68 + keyw68.length();
//                                                                                                                                                                                                                                                                                        }
//                                                                                                                                                                                                                                                                                        substringStart67 = start67 + keyw67.length();
//                                                                                                                                                                                                                                                                                    }
//                                                                                                                                                                                                                                                                                    substringStart66 = start66 + keyw66.length();
//                                                                                                                                                                                                                                                                                }
//                                                                                                                                                                                                                                                                                substringStart65 = start65 + keyw65.length();
//                                                                                                                                                                                                                                                                            }
//                                                                                                                                                                                                                                                                            substringStart64 = start64 + keyw64.length();
//                                                                                                                                                                                                                                                                        }
//                                                                                                                                                                                                                                                                        substringStart63 = start63 + keyw63.length();
//                                                                                                                                                                                                                                                                    }
//                                                                                                                                                                                                                                                                    substringStart62 = start62 + keyw62.length();
//                                                                                                                                                                                                                                                                }
//                                                                                                                                                                                                                                                                substringStart61 = start61 + keyw61.length();
//                                                                                                                                                                                                                                                            }
//                                                                                                                                                                                                                                                            substringStart60 = start60 + keyw60.length();
//                                                                                                                                                                                                                                                        }
//                                                                                                                                                                                                                                                        substringStart59 = start59 + keyw59.length();
//                                                                                                                                                                                                                                                    }
//                                                                                                                                                                                                                                                    substringStart58 = start58 + keyw58.length();
//                                                                                                                                                                                                                                                }
//                                                                                                                                                                                                                                                substringStart57 = start57 + keyw57.length();
//                                                                                                                                                                                                                                            }
//                                                                                                                                                                                                                                            substringStart56 = start56 + keyw56.length();
//                                                                                                                                                                                                                                        }
//                                                                                                                                                                                                                                        substringStart55 = start55 + keyw55.length();
//                                                                                                                                                                                                                                    }
//                                                                                                                                                                                                                                    substringStart54 = start54 + keyw54.length();
//                                                                                                                                                                                                                                }
//                                                                                                                                                                                                                                substringStart53 = start53 + keyw53.length();
//                                                                                                                                                                                                                            }
//                                                                                                                                                                                                                            substringStart52 = start52 + keyw52.length();
//                                                                                                                                                                                                                        }
//                                                                                                                                                                                                                        substringStart51 = start51 + keyw51.length();
//                                                                                                                                                                                                                    }
//                                                                                                                                                                                                                    substringStart50 = start50 + keyw50.length();
//                                                                                                                                                                                                                }
//                                                                                                                                                                                                                substringStart49 = start49 + keyw49.length();
//                                                                                                                                                                                                            }
//                                                                                                                                                                                                            substringStart48 = start48 + keyw48.length();
//                                                                                                                                                                                                        }
//                                                                                                                                                                                                        substringStart47 = start47 + keyw47.length();
//                                                                                                                                                                                                    }
//                                                                                                                                                                                                    substringStart46 = start46 + keyw46.length();
//                                                                                                                                                                                                }
//                                                                                                                                                                                                substringStart45 = start45 + keyw45.length();
//                                                                                                                                                                                            }
//                                                                                                                                                                                            substringStart44 = start44 + keyw44.length();
//                                                                                                                                                                                        }
//                                                                                                                                                                                        substringStart43 = start43 + keyw43.length();
//                                                                                                                                                                                    }
//                                                                                                                                                                                    substringStart42 = start42 + keyw42.length();
//                                                                                                                                                                                }
//                                                                                                                                                                                substringStart41 = start41 + keyw41.length();
//                                                                                                                                                                            }
//                                                                                                                                                                            substringStart40 = start40 + keyw40.length();
//                                                                                                                                                                        }
//                                                                                                                                                                        substringStart39 = start39 + keyw39.length();
//                                                                                                                                                                    }
//                                                                                                                                                                    substringStart38 = start38 + keyw38.length();
//                                                                                                                                                                }
//                                                                                                                                                                substringStart37 = start37 + keyw37.length();
//                                                                                                                                                            }
//                                                                                                                                                            substringStart36 = start36 + keyw36.length();
//                                                                                                                                                        }
//                                                                                                                                                        substringStart35 = start35 + keyw35.length();
//                                                                                                                                                    }
//                                                                                                                                                    substringStart34 = start34 + keyw34.length();
//                                                                                                                                                }
//                                                                                                                                                substringStart33 = start33 + keyw33.length();
//                                                                                                                                            }
//                                                                                                                                            substringStart32 = start32 + keyw32.length();
//                                                                                                                                        }
//                                                                                                                                        substringStart31 = start31 + keyw31.length();
//                                                                                                                                    }
//                                                                                                                                    substringStart30 = start30 + keyw30.length();
//                                                                                                                                }
//                                                                                                                                substringStart29 = start29 + keyw29.length();
//                                                                                                                            }
//                                                                                                                            substringStart28 = start28 + keyw28.length();
//                                                                                                                        }
//                                                                                                                        substringStart27 = start27 + keyw27.length();
//                                                                                                                    }
//                                                                                                                    substringStart26 = start26 + keyw26.length();
//                                                                                                                }
//                                                                                                                substringStart25 = start25 + keyw25.length();
//                                                                                                            }
//                                                                                                            substringStart24 = start24 + keyw24.length();
//                                                                                                        }
//                                                                                                        substringStart23 = start23 + keyw23.length();
//                                                                                                    }
//                                                                                                    substringStart22 = start22 + keyw22.length();
//                                                                                                }
//                                                                                                substringStart21 = start21 + keyw21.length();
//                                                                                            }
//                                                                                            substringStart20 = start20 + keyw20.length();
//                                                                                        }
//                                                                                        substringStart19 = start19 + keyw19.length();
//                                                                                    }
//                                                                                    substringStart18 = start18 + keyw18.length();
//                                                                                }
//                                                                                substringStart17 = start17 + keyw17.length();
//                                                                            }
//                                                                            substringStart16 = start16 + keyw16.length();
//                                                                        }
//                                                                        substringStart15 = start15 + keyw15.length();
//                                                                    }
//                                                                    substringStart14 = start14 + keyw14.length();
//                                                                }
//                                                                substringStart13 = start13 + keyw13.length();
//                                                            }
//                                                            substringStart12 = start12 + digit12.length();
//                                                        }
//                                                        substringStart11 = start11 + digit11.length();
//                                                    }
//                                                    substringStart10 = start10 + digit10.length();
//                                                }
//                                                substringStart9 = start9 + digit9.length();
//                                            }
//                                            substringStart8 = start8+digit8.length();
//                                        }
//                                        substringStart7 = start7+digit7.length();
//                                    }
//                                    substringStart6 = start6+digit6.length();
//                                }
//                                substringStart5 = start5+digit5.length();
//                            }
//                            substringStart4 = start4+digit4.length();
//                        }
//                        substringStart3 = start3+digit3.length();
//                    }
//                    substringStart2 = start2+digit2.length();
//                }
//                substringStart1 = start1+digit1.length();
//            }
//            substringStart0 = start0+digit0.length();
//        }
//        return spannable;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phreeqcdebug);

        InputFileLabel = (TextView) findViewById(R.id.InputFileLabel);
        InputFile = (EditText) findViewById(R.id.InputFile);
        InputFile.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        InputFile.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                InputFile.removeTextChangedListener(this);
                String text = InputFile.getText().toString();
//                InputFile.setText(colorizedPhreeqc(text, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED, "ADVECTION", "CALCULATE_VALUES", "COPY", "DATABASE", "DELETE", "DUMP", "END", "EQUILIBRIUM_PHASES", "EXCHANGE", "EXCHANGE_MASTER_SPECIES", "EXCHANGE_SPECIES", "GAS_PHASE", "INCLUDE$", "INCREMENTAL_REACTIONS", "INVERSE_MODELING", "ISOTOPES", "ISOTOPE_ALPHAS", "ISOTOPE_RATIOS", "KINETICS", "KNOBS", "LLNL_AQUEOUS_MODEL_PARAMETERS", "MIX", "NAMED_EXPRESSIONS", "PHASES", "PITZER", "PRINT", "RATES", "REACTION", "REACTION_PRESSURE", "REACTION_TEMPERATURE", "RUN_CELLS", "SAVE", "SELECTED_OUTPUT", "SIT", "SOLID_SOLUTIONS", "SOLUTION", "SOLUTION_MASTER_SPECIES", "SOLUTION_SPECIES", "SOLUTION_SPREAD", "SURFACE", "SURFACE_MASTER_SPECIES", "SURFACE_SPECIES", "TITLE", "TRANSPORT", "USE", "USER_GRAPH", "USER_PRINT", "USER_PUNCH", "EQUILIBRIUM_PHASES_MODIFY", "EXCHANGE_MODIFY", "GAS_PHASE_MODIFY", "KINETICS_MODIFY", "REACTION_MODIFY", "SOLID_SOLUTIONS_MODIFY", "SOLUTION_MODIFY", "SURFACE_MODIFY", Color.BLUE));
                InputFile.setText(colorized(text, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                InputFile.setSelection(startChanged+countChanged);
                InputFile.addTextChangedListener(this);
            }
        });
        DatabaseFileLabel = (TextView) findViewById(R.id.DatabaseFileLabel);
        DatabaseFile = (EditText) findViewById(R.id.DatabaseFile);
        DatabaseFile.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/InputTextSize.txt")).intValue());
        DatabaseFile.addTextChangedListener(new TextWatcher() {
            int startChanged,beforeChanged,countChanged;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startChanged = start;
                beforeChanged = before;
                countChanged = count;
            }
            @Override
            public void afterTextChanged(Editable s) {
                DatabaseFile.removeTextChangedListener(this);
                String text = DatabaseFile.getText().toString();
//                DatabaseFile.setText(colorizedPhreeqc(text, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED, "ADVECTION", "CALCULATE_VALUES", "COPY", "DATABASE", "DELETE", "DUMP", "END", "EQUILIBRIUM_PHASES", "EXCHANGE", "EXCHANGE_MASTER_SPECIES", "EXCHANGE_SPECIES", "GAS_PHASE", "INCLUDE$", "INCREMENTAL_REACTIONS", "INVERSE_MODELING", "ISOTOPES", "ISOTOPE_ALPHAS", "ISOTOPE_RATIOS", "KINETICS", "KNOBS", "LLNL_AQUEOUS_MODEL_PARAMETERS", "MIX", "NAMED_EXPRESSIONS", "PHASES", "PITZER", "PRINT", "RATES", "REACTION", "REACTION_PRESSURE", "REACTION_TEMPERATURE", "RUN_CELLS", "SAVE", "SELECTED_OUTPUT", "SIT", "SOLID_SOLUTIONS", "SOLUTION", "SOLUTION_MASTER_SPECIES", "SOLUTION_SPECIES", "SOLUTION_SPREAD", "SURFACE", "SURFACE_MASTER_SPECIES", "SURFACE_SPECIES", "TITLE", "TRANSPORT", "USE", "USER_GRAPH", "USER_PRINT", "USER_PUNCH", "EQUILIBRIUM_PHASES_MODIFY", "EXCHANGE_MODIFY", "GAS_PHASE_MODIFY", "KINETICS_MODIFY", "REACTION_MODIFY", "SOLID_SOLUTIONS_MODIFY", "SOLUTION_MODIFY", "SURFACE_MODIFY", Color.BLUE));
                DatabaseFile.setText(colorized(text, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                DatabaseFile.setSelection(startChanged+countChanged);
                DatabaseFile.addTextChangedListener(this);
            }
        });
        RunProgram = (Button) findViewById(R.id.RunProgram);
        RunProgram.setOnClickListener(RunProgramClick);
        Highlight = (Button) findViewById(R.id.Highlight);
        Highlight.setOnClickListener(HighlightClick);
        OutputViewLabel = (TextView) findViewById(R.id.OutputViewLabel);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        outputView2.setTextSize(Integer.valueOf(exec("cat "+getFilesDir()+"/OutputTextSize.txt")).intValue());
        outputView2.setMovementMethod(new ScrollingMovementMethod());
        Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(QuitClick);

    }

    public void onStart()
    {
        super.onStart();

        output3(exec("cat "+getFilesDir()+"/debug/Input.phr"));
        output4(exec("cat "+getFilesDir()+"/debug/Input.dat"));
        output(exec("cat "+getFilesDir()+"/debug/Input.phr.out"));
    }

    private View.OnClickListener RunProgramClick; {

        RunProgramClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Databasefile = DatabaseFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("Input.phr", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Input.dat", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Databasefile);
                    outputWriter2.close();
                    exec("mv "+getFilesDir()+"/Input.phr "+getFilesDir()+"/debug/");
                    exec("mv "+getFilesDir()+"/Input.dat "+getFilesDir()+"/debug/");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO Auto-generated method stub //
                openprogressdialog();
            }
        };
    }


    private void openprogressdialog() {
        // TODO Auto-generated method stub //
        progressDialog = new ProgressDialog(PhreeqcDebug.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Calculation is running...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();
        new Thread() {
            public void run() {
//                exec("cp "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ File.separator+"phreeqc_plus"+File.separator+"phreeqc_datasets"+File.separator+"Database.dat "+getFilesDir()+"");
                try {
                    exec("chmod 755 -R "+getFilesDir()+"/debug");
                    exec("chmod 755 -R "+getFilesDir());
                    exec(getApplicationInfo().nativeLibraryDir+"/libphreeqc.so "+getFilesDir()+"/debug/Input.phr "+getFilesDir()+"/debug/Input.phr.out "+getFilesDir()+"/debug/Input.dat");
                    exec("chmod 755 "+getFilesDir()+"/debug/Input.phr.out");

                    try {
                        output2(exec("cat "+getFilesDir()+"/debug/Input.phr"));
                        output4(exec("cat "+getFilesDir()+"/debug/Input.dat"));
                        output2(exec("cat "+getFilesDir()+"/debug/Input.phr.out"));
                        Toast.makeText(getApplicationContext(), "Calculation finished", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
                onFinish();
            }

            // Executes UNIX command.
            private String exec(String command) {
                try {
                    Process process = Runtime.getRuntime().exec(command);
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    int read;
                    char[] buffer = new char[65536];
                    StringBuffer output = new StringBuffer();
                    while ((read = reader.read(buffer)) > 0) {
                        output.append(buffer, 0, read);
                    }
                    reader.close();
                    process.waitFor();
                    return output.toString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }



    private View.OnClickListener HighlightClick; {

        HighlightClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                openhighlightdialog();
            }
        };
    }


    private void openhighlightdialog() {
        // TODO Auto-generated method stub //
        ProgressDialog progressDialog = new ProgressDialog(PhreeqcDebug.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Highlighting numbers is in progress...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();

        new Thread() {
            public void run() {
                try {
                    output3(exec("cat "+getFilesDir()+"/debug/Input.phr"));
                    output4(exec("cat "+getFilesDir()+"/debug/Input.dat"));
                    outputX(exec("cat "+getFilesDir()+"/debug/Input.phr.out"));
                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

                onFinish();
            }

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void outputX(final String strX) {
                Runnable procX = new Runnable() {
                    public void run() {
//                        outputView2.setText(colorizedPhreeqc(strX, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED, "ADVECTION", "CALCULATE_VALUES", "COPY", "DATABASE", "DELETE", "DUMP", "END", "EQUILIBRIUM_PHASES", "EXCHANGE", "EXCHANGE_MASTER_SPECIES", "EXCHANGE_SPECIES", "GAS_PHASE", "INCLUDE$", "INCREMENTAL_REACTIONS", "INVERSE_MODELING", "ISOTOPES", "ISOTOPE_ALPHAS", "ISOTOPE_RATIOS", "KINETICS", "KNOBS", "LLNL_AQUEOUS_MODEL_PARAMETERS", "MIX", "NAMED_EXPRESSIONS", "PHASES", "PITZER", "PRINT", "RATES", "REACTION", "REACTION_PRESSURE", "REACTION_TEMPERATURE", "RUN_CELLS", "SAVE", "SELECTED_OUTPUT", "SIT", "SOLID_SOLUTIONS", "SOLUTION", "SOLUTION_MASTER_SPECIES", "SOLUTION_SPECIES", "SOLUTION_SPREAD", "SURFACE", "SURFACE_MASTER_SPECIES", "SURFACE_SPECIES", "TITLE", "TRANSPORT", "USE", "USER_GRAPH", "USER_PRINT", "USER_PUNCH", "EQUILIBRIUM_PHASES_MODIFY", "EXCHANGE_MODIFY", "GAS_PHASE_MODIFY", "KINETICS_MODIFY", "REACTION_MODIFY", "SOLID_SOLUTIONS_MODIFY", "SOLUTION_MODIFY", "SURFACE_MODIFY", Color.BLUE));
                    outputView2.setText(colorized(strX, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                    }
                };
                handler.post(procX);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }

    private View.OnClickListener QuitClick; {

        QuitClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                Intent intent = new Intent(PhreeqcDebug.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/debug/Input.phr"));
        output4(exec("cat "+getFilesDir()+"/debug/Input.dat"));
        output(exec("cat "+getFilesDir()+"/debug/Input.phr.out"));
    }
    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                outputView2.setText(str2);
            }
        };
        handler.post(proc2);
    }
    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
//                InputFile.setText(colorizedPhreeqc(str3, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED, "ADVECTION", "CALCULATE_VALUES", "COPY", "DATABASE", "DELETE", "DUMP", "END", "EQUILIBRIUM_PHASES", "EXCHANGE", "EXCHANGE_MASTER_SPECIES", "EXCHANGE_SPECIES", "GAS_PHASE", "INCLUDE$", "INCREMENTAL_REACTIONS", "INVERSE_MODELING", "ISOTOPES", "ISOTOPE_ALPHAS", "ISOTOPE_RATIOS", "KINETICS", "KNOBS", "LLNL_AQUEOUS_MODEL_PARAMETERS", "MIX", "NAMED_EXPRESSIONS", "PHASES", "PITZER", "PRINT", "RATES", "REACTION", "REACTION_PRESSURE", "REACTION_TEMPERATURE", "RUN_CELLS", "SAVE", "SELECTED_OUTPUT", "SIT", "SOLID_SOLUTIONS", "SOLUTION", "SOLUTION_MASTER_SPECIES", "SOLUTION_SPECIES", "SOLUTION_SPREAD", "SURFACE", "SURFACE_MASTER_SPECIES", "SURFACE_SPECIES", "TITLE", "TRANSPORT", "USE", "USER_GRAPH", "USER_PRINT", "USER_PUNCH", "EQUILIBRIUM_PHASES_MODIFY", "EXCHANGE_MODIFY", "GAS_PHASE_MODIFY", "KINETICS_MODIFY", "REACTION_MODIFY", "SOLID_SOLUTIONS_MODIFY", "SOLUTION_MODIFY", "SURFACE_MODIFY", Color.BLUE));
                InputFile.setText(colorized(str3, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
            }
        };
        handler.post(proc3);
    }
    public void output4(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
//                DatabaseFile.setText(colorizedPhreeqc(str4, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED, "ADVECTION", "CALCULATE_VALUES", "COPY", "DATABASE", "DELETE", "DUMP", "END", "EQUILIBRIUM_PHASES", "EXCHANGE", "EXCHANGE_MASTER_SPECIES", "EXCHANGE_SPECIES", "GAS_PHASE", "INCLUDE$", "INCREMENTAL_REACTIONS", "INVERSE_MODELING", "ISOTOPES", "ISOTOPE_ALPHAS", "ISOTOPE_RATIOS", "KINETICS", "KNOBS", "LLNL_AQUEOUS_MODEL_PARAMETERS", "MIX", "NAMED_EXPRESSIONS", "PHASES", "PITZER", "PRINT", "RATES", "REACTION", "REACTION_PRESSURE", "REACTION_TEMPERATURE", "RUN_CELLS", "SAVE", "SELECTED_OUTPUT", "SIT", "SOLID_SOLUTIONS", "SOLUTION", "SOLUTION_MASTER_SPECIES", "SOLUTION_SPECIES", "SOLUTION_SPREAD", "SURFACE", "SURFACE_MASTER_SPECIES", "SURFACE_SPECIES", "TITLE", "TRANSPORT", "USE", "USER_GRAPH", "USER_PRINT", "USER_PUNCH", "EQUILIBRIUM_PHASES_MODIFY", "EXCHANGE_MODIFY", "GAS_PHASE_MODIFY", "KINETICS_MODIFY", "REACTION_MODIFY", "SOLID_SOLUTIONS_MODIFY", "SOLUTION_MODIFY", "SURFACE_MODIFY", Color.BLUE));
                DatabaseFile.setText(colorized(str4, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
            }
        };
        handler.post(proc4);
    }
    public void output(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
//                outputView2.setText(colorizedPhreeqc(str, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED, "ADVECTION", "CALCULATE_VALUES", "COPY", "DATABASE", "DELETE", "DUMP", "END", "EQUILIBRIUM_PHASES", "EXCHANGE", "EXCHANGE_MASTER_SPECIES", "EXCHANGE_SPECIES", "GAS_PHASE", "INCLUDE$", "INCREMENTAL_REACTIONS", "INVERSE_MODELING", "ISOTOPES", "ISOTOPE_ALPHAS", "ISOTOPE_RATIOS", "KINETICS", "KNOBS", "LLNL_AQUEOUS_MODEL_PARAMETERS", "MIX", "NAMED_EXPRESSIONS", "PHASES", "PITZER", "PRINT", "RATES", "REACTION", "REACTION_PRESSURE", "REACTION_TEMPERATURE", "RUN_CELLS", "SAVE", "SELECTED_OUTPUT", "SIT", "SOLID_SOLUTIONS", "SOLUTION", "SOLUTION_MASTER_SPECIES", "SOLUTION_SPECIES", "SOLUTION_SPREAD", "SURFACE", "SURFACE_MASTER_SPECIES", "SURFACE_SPECIES", "TITLE", "TRANSPORT", "USE", "USER_GRAPH", "USER_PRINT", "USER_PUNCH", "EQUILIBRIUM_PHASES_MODIFY", "EXCHANGE_MODIFY", "GAS_PHASE_MODIFY", "KINETICS_MODIFY", "REACTION_MODIFY", "SOLID_SOLUTIONS_MODIFY", "SOLUTION_MODIFY", "SURFACE_MODIFY", Color.BLUE));
                outputView2.setText(colorized(str, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
            }
        };
        handler.post(proc);
    }

    // Executes UNIX command.
    private String exec(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[65536];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            process.waitFor();
            return output.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}