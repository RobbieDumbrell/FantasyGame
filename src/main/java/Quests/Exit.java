package Quests;

public enum Exit {

    NORTH("North"),
    EAST("East"),
    SOUTH("South"),
    WEST("West");

    String humanReadable;

    Exit(String humanReadable){
        this.humanReadable = humanReadable;
    }

    public String getHumanReadable() {
        return humanReadable;
    }

}
