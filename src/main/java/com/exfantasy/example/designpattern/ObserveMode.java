package com.exfantasy.example.designpattern;

import java.util.Observable;
import java.util.Observer;

class ObserveMode extends Observable {
     private String message;

     public String getMessage() {
          return message;
     }

     public void changeMessage(String message) {
          this.message = message;
          setChanged();
          notifyObservers(message);
     }

     public static void main(String[] args) {
          ObserveMode msgBoard = new ObserveMode();

          Student alice = new Student("Alice");
          Student tommy = new Student("Tommy");

          msgBoard.addObserver(alice);
          msgBoard.addObserver(tommy);

          msgBoard.changeMessage("More Homework!");
          
          msgBoard.deleteObserver(tommy);
          
          msgBoard.changeMessage("Tommy leave");
     }
}

class Student implements Observer {
     private String name;
    
     public Student(String name) {
          this.name = name;
     }
    
     @Override
     public void update(Observable o, Object arg) {
          System.out.println(o);
          System.out.println(name + ">>>>> Message board changed: " + arg);
     }
}