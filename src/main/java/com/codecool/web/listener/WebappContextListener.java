package com.codecool.web.listener;

import com.codecool.web.model.Subject;
import com.codecool.web.model.SubjectList;
import com.codecool.web.model.UserList;
import com.codecool.web.service.Serializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public final class WebappContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("This method is invoked once when the webapp gets deployed.");
        SubjectList.getInstance().addSubject(new Subject("Berta", "Helpful, Goddess of Java, bitten by a radioactive computer, coding abilities give her amazing powers she uses tu help others", true));
        SubjectList.getInstance().addSubject(new Subject("Captain Marvel", "After an alien device mutated her DNA, Danvers transformed from a merely brilliant pilot into one of the most powerful Super Heroes in the universe. Now soaring among the stars, Carol Danvers is known as Captain Marvel!", true));
        SubjectList.getInstance().addSubject(new Subject("Thanos", "The Mad Titan Thanos quests across the universe in search of the Infinity Stones, intending to use their limitless power for shocking purposes.", true));
        SubjectList.getInstance().addSubject(new Subject("Spider-Man", "Bitten by a radioactive spider, Peter Parker’s arachnid abilities give him amazing powers he uses to help others, while his personal life continues to offer plenty of obstacles.", true));
        SubjectList.getInstance().addSubject(new Subject("Iron Man", "Genius. Billionaire. Playboy. Philanthropist. Tony Stark's confidence is only matched by his high-flying abilities as the hero called Iron Man.", true));
        SubjectList.getInstance().addSubject(new Subject("Captain America", "Recipient of the Super-Soldier serum, World War II hero Steve Rogers fights for American ideals as one of the world’s mightiest heroes and the leader of the Avengers.", true));
        SubjectList.getInstance().addSubject(new Subject("Hulk", "Dr. Bruce Banner lives a life caught between the soft-spoken scientist he’s always been and the uncontrollable green monster powered by his rage.", true));
        SubjectList.getInstance().addSubject(new Subject("Black Widow", "Despite super spy Natasha Romanoff’s checkered past, she’s become one of S.H.I.E.L.D.’s most deadly assassins and a frequent member of the Avengers.", true));
        SubjectList.getInstance().addSubject(new Subject("Thor", "The son of Odin uses his mighty abilities as the God of Thunder to protect his home Asgard and planet Earth alike.", true));
        SubjectList.getInstance().addSubject(new Subject("Hawkeye", "A master marksman and longtime friend of Black Widow, Clint Barton serves as the Avengers’ amazing archer.", true));
        SubjectList.getInstance().addSubject(new Subject("Yondu", "Adventurer and natural mystic, Yondu wields a mighty bow with Yaka arrows that move according to his whistles. ", true));
        SubjectList.getInstance().addSubject(new Subject("Rocket", "As the weapons and tactical expert of the Guardians of the Galaxy, Rocket risks his hide to defend the cosmos.", true));

        Serializer serializer = new Serializer();
        try {
            UserList.getInstance().setUserList(serializer.readSer());
            System.out.println("Userlist read.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Serializer serializer = new Serializer();
        try {
            serializer.saveUser(UserList.getInstance().getUserList());
            System.out.println("Userlist saved");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("This method is invoked once when the webapp gets undeployed.");
    }
}
