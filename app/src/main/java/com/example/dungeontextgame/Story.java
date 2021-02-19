package com.example.dungeontextgame;

import android.content.Intent;
import android.view.View;

public class Story {
    GameScreen gs;
    String nextposition1,nextposition2,nextposition3,nextposition4;
    boolean club = false;
    boolean key = false;
    boolean holySword = false;
    boolean antiMimicPotion = false;

    public  Story(GameScreen gs){
        this.gs = gs;
    }


    public void selectPosition(String position){
        switch(position){
            case "startingPoint":startingPoint();break;
            case "room":room();break;
            case "slime":slime();break;
            case "slimeDefeated":slimeDefeated();break;
            case "dead":dead();break;
            case "goTitleScreen":gs.goTitleScreen();break;
            case "chest":chest();break;
            case "club":club();break;
            case "mimicChest":mimicChest();break;
            case "mimic":mimic();break;
            case "mimicIsDead":mimicIsDead();break;
            case "bossLairDoor":bossLairDoor();break;
            case "noKey":noKey();break;
            case "bossLair":bossLair();break;
            case "mimicPotion":mimicPotion();break;
            case "potion":potion();break;
            case "bossFight": bossFight();break;
            case "victory":victory();break;

        }
    }

    public void showAllButtons(){
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);
    }

    public void startingPoint(){
        gs.image.setImageResource(R.drawable.hallway_first);
        gs.text.setText("You're met with a long hallway..\n.\nYou can go forward,turn left,turn right or turn back from where you came. ");

        gs.button1.setText("Go forward");
        gs.button2.setText("Go left");
        gs.button3.setText("Go right");
        gs.button4.setText("Flee and save yourself");

        showAllButtons();

        nextposition1 = "room";
        nextposition2 = "slime";
        nextposition3 = "chest";
        nextposition4 = "goTitleScreen";
    }

    public void slime(){
            gs.image.setImageResource(R.drawable.slimed);
            gs.text.setText("You're faced with one of the weakest enemies,but if you're not prepared it could cost your life.\n.\nWill you fight or flee. ");

            gs.button1.setText("Fight");
            gs.button2.setText("Flee");
            gs.button3.setText("");
            gs.button4.setText("");

            if (club == false){
                nextposition1 = "dead";
                nextposition2 = "startingPoint";
                nextposition3 = "";
                nextposition4 = "";
                gs.button3.setVisibility(View.INVISIBLE);
                gs.button4.setVisibility(View.INVISIBLE);
            }
            else if (club == true){
                nextposition1 = "slimeDefeated";
                nextposition2 = "startingPoint";
                nextposition3 = "";
                nextposition4 = "";
                gs.button3.setVisibility(View.INVISIBLE);
                gs.button4.setVisibility(View.INVISIBLE);
            }

            if (key == true){
                    gs.image.setImageResource(R.drawable.slime_dead);
                    gs.text.setText("The room is filled only with what is left of the slime.");

                    gs.button1.setText("Go back");
                    gs.button2.setText("");
                    gs.button3.setText("");
                    gs.button4.setText("");

                    nextposition1 = "startingPoint";
                    nextposition2 = "";
                    nextposition3 = "";
                    nextposition4 = "";
                    gs.button2.setVisibility(View.INVISIBLE);
                    gs.button3.setVisibility(View.INVISIBLE);
                    gs.button4.setVisibility(View.INVISIBLE);
            }
    }
    public void slimeDefeated(){
        gs.image.setImageResource(R.drawable.key);
        gs.text.setText("You've defeated the slime..\n.\nIt has dropped a key.It might help you travel further into the dungeon.");

        key = true;

        gs.button1.setText("Back");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        nextposition1 = "startingPoint";
        nextposition2 = "";
        nextposition3 = "";
        nextposition4 = "";
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);
    }
    public void dead(){
        gs.image.setImageResource(R.drawable.dead);
        gs.text.setText("You were not prepared.\n.\nYou've succumbed to the dungeon.");

        gs.button1.setText("Revive");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        nextposition1 = "goTitleScreen";
        nextposition2 = "";
        nextposition3 = "";
        nextposition4 = "";
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);
    }
    public void chest(){
        if (club == false){
            gs.image.setImageResource(R.drawable.chest_closed);
            gs.text.setText("There is a chest.\n.\nWill you open it");

            gs.button1.setText("Open");
            gs.button2.setText("Go back");
            gs.button3.setText("");
            gs.button4.setText("");

            nextposition1 = "club";
            nextposition2 = "startingPoint";
            nextposition3 = "";
            nextposition4 = "";
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
        else if(club){
            gs.image.setImageResource(R.drawable.empty_chest);
            gs.text.setText("There is nothing in the chest");

            gs.button1.setText("Go back");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            nextposition1 = "startingPoint";
            nextposition2 = "";
            nextposition3 = "";
            nextposition4 = "";
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }

    }
    public void club(){
        gs.image.setImageResource(R.drawable.club);
        gs.text.setText("You've found the most basic weapon. .\n.\nMaybe you'll be able to defend yourself.");

        club = true;

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        nextposition1 = "startingPoint";
        nextposition2 = "";
        nextposition3 = "";
        nextposition4 = "";
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);
    }
    public void room(){
        gs.image.setImageResource(R.drawable.hallway_second);
        gs.text.setText("There is a door in the distance and a room on your right..\n.\nWill you open the door,go back or go right. ");

        showAllButtons();

        gs.button1.setText("Open the door");
        gs.button2.setText("Go right");
        gs.button3.setText("Go back");
        gs.button4.setText("");

        nextposition1 = "bossLairDoor";
        nextposition2 = "mimicChest";
        nextposition3 = "startingPoint";
        nextposition4 = "";
        gs.button4.setVisibility(View.INVISIBLE);
    }
    public void mimicChest(){
        gs.image.setImageResource(R.drawable.chest_closed);
        gs.text.setText("There is another suspicious chest.\n\nWill you open it or go back. ");

        showAllButtons();

        gs.button1.setText("Open it");
        gs.button2.setText("Go back");
        gs.button3.setText("");
        gs.button4.setText("");

        nextposition1 = "mimic";
        nextposition2 = "room";
        nextposition3 = "";
        nextposition4 = "";
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        if(holySword == true ){
            gs.image.setImageResource(R.drawable.empty_chest);
            gs.text.setText("You've killed it.There's nothing left to do here");
            gs.button1.setText("Back");
            nextposition1 = "room";
        }
    }
    public void mimic(){
        gs.image.setImageResource(R.drawable.mimic);
        gs.text.setText("It's a mimic.\n\nFight!\nFlee! ");

        showAllButtons();

        gs.button1.setText("Fight!");
        gs.button2.setText("Flee!");
        gs.button3.setText("");
        gs.button4.setText("");
        if(antiMimicPotion == false) {
            nextposition1 = "dead";
            nextposition2 = "room";
            nextposition3 = "";
            nextposition4 = "";
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
        else if(antiMimicPotion == true){
            nextposition1 = "mimicIsDead";

            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
    }
    public void mimicIsDead(){
        gs.image.setImageResource(R.drawable.holysword);
        gs.text.setText("You've defeated the mimic!You find a 'Master Sword'.\nIt will help you with a tough enemy.");

        holySword = true;

        gs.button1.setText("Go back!");
        nextposition1 = "room";

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);
    }
    public void bossLairDoor(){
        gs.image.setImageResource(R.drawable.door_to_wood);
        gs.text.setText("The door is locked.\n.\nUnlock it or go back.");

        gs.button1.setText("Unlock the door");
        gs.button2.setText("Go back");
        gs.button3.setText("");
        gs.button4.setText("");

        if (key == false){
            nextposition1 = "noKey";
            nextposition2 = "room";
            nextposition3 = "";
            nextposition4 = "";
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
        else if (key == true){
            nextposition1 = "bossLair";
            nextposition2 = "room";
            nextposition3 = "";
            nextposition4 = "";
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
    }
    public void noKey(){
        gs.image.setImageResource(R.drawable.door_to_wood);
        gs.text.setText("You don't have a key.");

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button1.setText("room");
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);
    }
    public void bossLair(){
        gs.image.setImageResource(R.drawable.bosslair);
        gs.text.setText("There are two doors in front of you.You feel a sinister energy behind the left one. ");

        showAllButtons();
        gs.button1.setText("Go to the left");
        gs.button2.setText("Go to the right");
        gs.button3.setText("Go back");
        gs.button4.setText("");

        nextposition1 = "bossFight";
        nextposition2 = "mimicPotion";
        nextposition3 = "room";
        nextposition4 = "";
        gs.button4.setVisibility(View.INVISIBLE);
    }
    public void mimicPotion(){
        gs.image.setImageResource(R.drawable.potionnonempty);
        gs.text.setText("There is a potion.");

        if (antiMimicPotion == true){
            gs.image.setImageResource(R.drawable.potionempty);
            gs.text.setText("There is nothing more to take from this room.");

            gs.button1.setText("Back");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            nextposition1 = "bossLair";
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
        else if (antiMimicPotion == false){
            gs.button1.setText("Take a closer look");
            gs.button2.setText("Back");
            gs.button3.setText("");
            gs.button4.setText("");

            nextposition1 = "potion";
            nextposition2 = "bossLair";
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
    }
    public void potion(){
        gs.image.setImageResource(R.drawable.potion);
        gs.text.setText("The text on the potion states:\nFor when you're faced against a chest full of teeth.");

        antiMimicPotion = true;

        gs.button1.setText("Back");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        nextposition1 = "bossLair";
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);
    }
    public void bossFight(){
        gs.image.setImageResource(R.drawable.boss);
        gs.text.setText("There is a powerful black orb.You feel that you can go deeper in to the dungeon if you get past it.");

        gs.button1.setText("Fight");
        gs.button2.setText("Flee");
        gs.button3.setText("");
        gs.button4.setText("");

        if (holySword == false){
            nextposition1 = "dead";
            nextposition2 = "bossLair";

            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
        else if(holySword == true){
            nextposition1 = "victory";
            nextposition2 = "bossLair";
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
        }
    }
    public void victory(){
        gs.image.setImageResource(R.drawable.congrats);
        gs.text.setText("You managed to clear the first floor of the dungeon.\n" +
                "You continue to venture deeper into it,not knowing what kind of fate awaits you.\n" +
                "Nonetheless you enjoy a small but sweet victory.\nTHE END\nfor now....");

        gs.button1.setText("Go to start");
        nextposition1 = "goTitleScreen";
        gs.button2.setVisibility(View.INVISIBLE);
    }
}
