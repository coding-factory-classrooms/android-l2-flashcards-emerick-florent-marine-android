package com.g2.musique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FactoryQuestion {

    public static final String STANDARD = "standard";
    public static final String MANGA = "manga";
    public static final String DISCO = "disco";
    private Map<String, ArrayList<Question>> questionsMap = new HashMap<>();

    public void createDataBase(String level){

        ArrayList<Question> questionsListBasic = new ArrayList<Question>();

        // Standart 15
        questionsListBasic.add(new Question(R.raw.the_week_end,"The Week End", new String[] {"ColdPlay","Imagine Dragon","Linkin Park"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.daft_punk,"Daft Punk", new String[] {"David Guetta","Avicii","Marshmello"}, STANDARD,level));
        questionsListBasic.add(new Question(R.raw.ed_sheeran,"Ed Sheeran", new String[] {"Charlie Puth","Sam Smith","Shawn Mendes"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.acdc,"ACDC", new String[] {"Led Zeppelin","METALLICA","Iron Maiden"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.creedence_clearwater_revival,"Creedence Clearwater Revival", new String[] {"The doors","The Beatles","The Rolling Stones"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.david_guetta,"David Guetta", new String[] {"Daft Punk","DJ Snake","Petit Biscuit"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.eminem,"Eminem", new String[] {"Mac Miller","50 Cent","Orelsan"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.evanescence,"Evanescence", new String[] {"Avril Lavigne","Within Temptation","Nightwish"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.kehlani,"Kehlani", new String[] {"Katy Perry","Demi Lovato","Miley Cyrus"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.macklemore_ryanlewis,"Macklemore Ryanlewis", new String[] {"Wanz","Drake","Bruno Mars"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.linkin_park,"Linkin Park", new String[] {"Evanescence","Slipknot","Limp Bizkit"}, STANDARD, level));
        questionsListBasic.add(new Question(R.raw.queen,"Queen", new String[] {"The Beatles","Elton John","David Bowie"}, STANDARD,level));
        questionsListBasic.add(new Question(R.raw.will_smith,"Will Smith", new String[] {"Jaden Smith","Bruce Willis","Martin Laurence"}, STANDARD,level));
        questionsListBasic.add(new Question(R.raw.wizkhalifa_charlieputh,"Wizkhalifa Charlieputh", new String[] {"Justin Bieber","Harry Styles","Bruno Mars"}, STANDARD,level));
        questionsListBasic.add(new Question(R.raw.gta_pornhub,"GTA", new String[] {"Je ne connais pas ce son","PornHub","Je doute"}, STANDARD,level));

        questionsMap.put(STANDARD,questionsListBasic);
        questionsListBasic = new ArrayList<Question>();

        // Manga
        questionsListBasic.add(new Question(R.raw.therootless,"Therootless", new String[] {"5050","BoyStyle","Red Diamond Dogs"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_sid,"SID", new String[] {"Bump Of Chicken","Dish","Tokio"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_amamiyasora,"Sora Amamiya", new String[] {"Lil'B","Sakura Gakuin","Canary Club"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_fireforce,"Mrs. Green Apple", new String[] {"Shindo Haruichi","King Gnu","Kenshi Yonezu"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_pornograffitti,"Porno Graffitti", new String[] {"Yoasobi","Masaki Suda","Sakanaction"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_flow,"Colors", new String[] {"Therootless","King Gnu","Mrs. Green Apple"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_linkedhorizon,"Linked Horizon", new String[] {"Sound Horizon","Shinsei Kamattechan","Yōko Hikasa"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_lisa,"Lisa", new String[] {"Jennie Kim","Rosé","G-Dragon"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_masatoshiono,"Masatoshiono", new String[] {"Linked Horizon","Sound Horizon","Yoasobi"}, MANGA, level));
        questionsListBasic.add(new Question(R.raw.manga_tkfromlingtositesigure,"Ling Tosite Sigure", new String[] {"Bump Of Chicken","Mrs. Green Apple","Canary Club"}, MANGA, level));

        questionsMap.put(MANGA, questionsListBasic);
        questionsListBasic = new ArrayList<Question>();

        //Disco
        questionsListBasic.add(new Question(R.raw.disco_boneym,"Boneym", new String[] {"Abba","Village Peaple","Modern Talking"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_debutdesoiree,"Debut De Soirée", new String[] {"Jean Pierre Mader","Emile et Images","Jean Luc lahaye"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_earthwindandfire,"Earth Wind And Fire", new String[] {"Kool And The Gang","Earth Wind","Eart And Fire"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_franckyvincent,"Francky Vincent", new String[] {"Pacci","Gilbert Montagné","Carlos"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_images,"Images", new String[] {"Gold","Debut De Soirée","Partenaire Particulier"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_jeanjacquesgoldman,"Jean Jacques Goldman", new String[] {"Daniel Balavoine","Michael Jones","Patrick Bruel"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_jeanschultheis,"Jean Schultheis", new String[] {"François FeldMan","Patrick Hermandez","Serge Lama"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_koolandthegang,"kool And The Gang", new String[] {"Gang","K.O.O.L","Earth Wind And Fire"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_patrickhernandez,"Patrick Hernandez", new String[] {"Plastic Bertrand","Jean Schultheis","Gilbert Montagné"}, DISCO, level));
        questionsListBasic.add(new Question(R.raw.disco_sabrina,"Sabrina", new String[] {"Lio","Julie Pietri","Jeanne Mas"}, DISCO, level));

        questionsMap.put(DISCO,questionsListBasic);

    }

    public ArrayList<Question> setQuestion(String type, int numberOfQuestion, String level){
        if (questionsMap.isEmpty()){
            createDataBase(level);
        }

        ArrayList<Question> questionsReturn = new ArrayList<Question>(questionsMap.get(type));
        Collections.shuffle(questionsReturn);

        if (numberOfQuestion < questionsReturn.size())
        {
            int test = questionsReturn.size() - numberOfQuestion;
            for (int i=0; i < test; ++i){
                questionsReturn.remove(questionsReturn.size() -1);
            }
        }

        return questionsReturn;
    }

    public ArrayList<Question> setAllQuestion(){
        if (questionsMap.isEmpty()) {
            createDataBase(null);
        }
        ArrayList<Question> questionsReturn = new ArrayList<Question>(questionsMap.get(STANDARD));
        questionsReturn.addAll(questionsMap.get(MANGA));
        questionsReturn.addAll(questionsMap.get(DISCO));
        return questionsReturn;
    }
}
