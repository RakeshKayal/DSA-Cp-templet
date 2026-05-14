package DESIGN_PATTERN;

import java.util.ArrayList;
import java.util.List;

// Subject
interface Channel {
    void subscribe(User u);
    void unSubscribe(User u);
    void notifyAllSubscribers();
}

// Observer
interface User {
    void update(String video, String channelName);
    String getName();

}


// Concrete Subject
class YouTube implements Channel {

    String name;
    String latestVideo;

    List<User> subscribers = new ArrayList<>();

    YouTube(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(User u) {
        if (!subscribers.contains(u)) {
            subscribers.add(u);
            System.out.println(u.getName()+" Subscribed to " + name+" Channel");
        }
    }

    @Override
    public void unSubscribe(User u) {
        if (subscribers.contains(u)) {
            subscribers.remove(u);
            System.out.println(u.getName()+ " Unsubscribed  " + name+" Channel");
        }
    }

    @Override
    public void notifyAllSubscribers() {
        for (User u : subscribers) {
            u.update(latestVideo, name); // PUSH data
        }
    }

    public void upload(String video) {
        this.latestVideo = video;
        System.out.println("\n📢 New video uploaded on " + name + ": " + video);
        notifyAllSubscribers();
    }
}


// Concrete Observer
class Subscriber implements User {

    String name;

    Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String video, String channelName) {
        System.out.println(name + " received notification → Video: "
                + video + " | Channel: " + channelName);
    }

    @Override
    public String getName() {
        return name;
    }
}


// Main class
public class Observer {

    public static void main(String[] args) {

        // Channels
        YouTube channel1 = new YouTube("MyYoutube");
        YouTube channel2 = new YouTube("A");

        // Subscribers
        Subscriber sub1 = new Subscriber("Rakesh");
        Subscriber sub2 = new Subscriber("Ram");
        Subscriber sub3 = new Subscriber("Tanu");

        // Subscriptions
        channel1.subscribe(sub1);
        channel1.subscribe(sub2);

        channel2.subscribe(sub3);
        channel2.subscribe(sub1); // same user, multiple channels

        // Uploads
        channel1.upload("Dintanana");
        channel1.upload("Karisma");

        channel2.upload("Tera Mera Song");
        channel2.upload("Tere Bin Song");

        // Unsubscribe test
        channel1.unSubscribe(sub1);
        channel1.upload("tere mera milna song");
    }
}