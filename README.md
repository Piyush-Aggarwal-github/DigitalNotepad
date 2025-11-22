
# **Digital Notepad (Java Swing)**

A simple and clean desktop notepad application built using **Java Swing**.
This project demonstrates GUI creation, file handling, themes, and beginner-friendly application structure without any external libraries.

---

## **Features**

* Open text files
* Save text files
* Clear the editor
* Adjustable font size
* Light and dark mode
* Word wrap for easier reading
* Simple, minimal, and portable Java code

---

## **Project Structure**

```
digital-notepad/
│
├── src/
│   ├── SimpleNotepad.java      # Application entry point
│   ├── NotepadUI.java          # User interface layout and logic
│   └── FileManager.java        # File open/save functionality
│
└── README.md
```

You may also add an optional `out/` directory to store compiled `.class` files.

---

## **How to Compile**

Open a terminal inside the project directory:

```
cd digital-notepad
```

Create an output folder (if needed):

```
mkdir out
```

Compile all Java files:

```
javac -d out src/*.java
```

---

## **How to Run**

Run the compiled program:

```
java -cp out SimpleNotepad
```

---

## **Requirements**

* Java 8 or newer
* No external libraries
* Works on Windows, macOS, and Linux

---

## **File Descriptions**

### **SimpleNotepad.java**

* Contains the `main()` method
* Launches the application using Swing’s event dispatch thread

### **NotepadUI.java**

* Builds and manages the graphical interface
* Contains theme toggling, font size controls, and editor setup

### **FileManager.java**

* Handles file opening and saving using `JFileChooser`
* Uses safe and simple I/O methods

---
