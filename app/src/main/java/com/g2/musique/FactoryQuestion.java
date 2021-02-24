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

    /**
     * Create Database of questions for the app
     */
    public void createDataBase(){

        ArrayList<Question> questionsListBasic = new ArrayList<Question>();

        // Standart 15
        questionsListBasic.add(new Question(R.raw.the_week_end,"The Week End", new String[] {"ColdPlay","Imagine Dragon","Linkin Park"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.daft_punk,"Daft Punk", new String[] {"David Guetta","Avicii","Marshmello"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.ed_sheeran,"Ed Sheeran", new String[] {"Charlie Puth","Sam Smith","Shawn Mendes"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.acdc,"ACDC", new String[] {"Led Zeppelin","METALLICA","Iron Maiden"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.creedence_clearwater_revival,"Creedence Clearwater Revival", new String[] {"The doors","The Beatles","The Rolling Stones"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.david_guetta,"David Guetta", new String[] {"Daft Punk","DJ Snake","Petit Biscuit"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.eminem,"Eminem", new String[] {"Mac Miller","50 Cent","Orelsan"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.evanescence,"Evanescence", new String[] {"Avril Lavigne","Within Temptation","Nightwish"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.kehlani,"Kehlani", new String[] {"Katy Perry","Demi Lovato","Miley Cyrus"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.macklemore_ryanlewis,"Macklemore Ryanlewis", new String[] {"Wanz","Drake","Bruno Mars"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.linkin_park,"Linkin Park", new String[] {"Evanescence","Slipknot","Limp Bizkit"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.queen,"Queen", new String[] {"The Beatles","Elton John","David Bowie"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.will_smith,"Will Smith", new String[] {"Jaden Smith","Bruce Willis","Martin Laurence"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.wizkhalifa_charlieputh,"Wizkhalifa Charlieputh", new String[] {"Justin Bieber","Harry Styles","Bruno Mars"}, STANDARD));
        questionsListBasic.add(new Question(R.raw.gta_pornhub,"GTA", new String[] {"Je ne connais pas ce son","PornHub","Je doute"}, STANDARD));

        questionsMap.put(STANDARD,questionsListBasic);
        questionsListBasic = new ArrayList<Question>();

        // Manga
        questionsListBasic.add(new Question(R.raw.therootless,"Therootless", new String[] {"5050","BoyStyle","Red Diamond Dogs"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_sid,"SID", new String[] {"Bump Of Chicken","Dish","Tokio"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_amamiyasora,"Sora Amamiya", new String[] {"Lil'B","Sakura Gakuin","Canary Club"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_fireforce,"Mrs. Green Apple", new String[] {"Shindo Haruichi","King Gnu","Kenshi Yonezu"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_pornograffitti,"Porno Graffitti", new String[] {"Yoasobi","Masaki Suda","Sakanaction"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_flow,"Colors", new String[] {"Therootless","King Gnu","Mrs. Green Apple"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_linkedhorizon,"Linked Horizon", new String[] {"Sound Horizon","Shinsei Kamattechan","Yōko Hikasa"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_lisa,"Lisa", new String[] {"Jennie Kim","Rosé","G-Dragon"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_masatoshiono,"Masatoshiono", new String[] {"Linked Horizon","Sound Horizon","Yoasobi"}, MANGA));
        questionsListBasic.add(new Question(R.raw.manga_tkfromlingtositesigure,"Ling Tosite Sigure", new String[] {"Bump Of Chicken","Mrs. Green Apple","Canary Club"}, MANGA));

        questionsMap.put(MANGA, questionsListBasic);
        questionsListBasic = new ArrayList<Question>();

        //Disco
        questionsListBasic.add(new Question(R.raw.disco_boneym,"Boneym", new String[] {"Abba","Village Peaple","Modern Talking"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_debutdesoiree,"Debut De Soirée", new String[] {"Jean Pierre Mader","Emile et Images","Jean Luc lahaye"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_earthwindandfire,"Earth Wind And Fire", new String[] {"Kool And The Gang","Earth Wind","Eart And Fire"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_franckyvincent,"Francky Vincent", new String[] {"Pacci","Gilbert Montagné","Carlos"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_images,"Images", new String[] {"Gold","Debut De Soirée","Partenaire Particulier"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_jeanjacquesgoldman,"Jean Jacques Goldman", new String[] {"Daniel Balavoine","Michael Jones","Patrick Bruel"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_jeanschultheis,"Jean Schultheis", new String[] {"François FeldMan","Patrick Hermandez","Serge Lama"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_koolandthegang,"kool And The Gang", new String[] {"Gang","K.O.O.L","Earth Wind And Fire"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_patrickhernandez,"Patrick Hernandez", new String[] {"Plastic Bertrand","Jean Schultheis","Gilbert Montagné"}, DISCO));
        questionsListBasic.add(new Question(R.raw.disco_sabrina,"Sabrina", new String[] {"Lio","Julie Pietri","Jeanne Mas"}, DISCO));

        questionsMap.put(DISCO,questionsListBasic);

    }

    /**
     *
     * @param type is equal to the type of music choose
     * @param numberOfQuestion is equal of the numbers of desired question
     * @return Arraylist of questions and response
     */
    public ArrayList<Question> setQuestion(String type, int numberOfQuestion){
        if (questionsMap.isEmpty()){
            createDataBase();
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

    /**
     *
     * @param level is the choose of the difficulty by the user
     * @return Arraylist of all the questions
     */
    public ArrayList<Question> setAllQuestion(String level){
        if (questionsMap.isEmpty()) {
            createDataBase();
        }

        ArrayList<Question> questionsReturn = new ArrayList<Question>(questionsMap.get(STANDARD));
        questionsReturn.addAll(questionsMap.get(MANGA));
        questionsReturn.addAll(questionsMap.get(DISCO));
        return questionsReturn;
    }
}
