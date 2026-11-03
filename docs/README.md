# Project Title: CardTrack

* Student: Andrew Firestone
* Instructor: Ken Smith
* Class: IST261 - App Development Studio I, Section 001
* Semester: Fall 2026

Project Description: CardTrack is a desktop Java application for small trading-card sellers to manage inventory, listings, and sales. The current version uses Swing, MVC, a JTable list-view, and a separate card detail-view with create, read, update, and delete functionality.

## Current Assignment Name: M06-A01: Implementing the List-Detail Pattern

### Assignment Accomplishments - (Description)

* Added `CardListUI` as the list-view. It displays the card inventory in a scrollable `JTable` and shows seven card attributes: Inventory ID, Name, Game, Set, Condition, Quantity, and Asking Price.
* The application now starts with six sample `Card` model objects so the JTable is populated immediately.
* Added `CardDetailUI` as the separate detail-view. It displays all eleven attributes of one selected card without using a `JOptionPane` for card details.
* Implemented CRUD behavior through the list-detail pattern. Users can add a new card, view a selected card, edit only the selected card, and delete a selected card.
* Adding, editing, or deleting a card updates the `CardList` model and refreshes the JTable so the views stay synchronized.
* The application prevents deletion when the card list is empty. The Delete button is disabled when no row can be selected, and the controller also checks the model before deleting.
* The detail-view closes without exiting the application. The application can only be exited from the list-view using the Exit button or by closing the list window.
* Previous model classes, inheritance/interface work, tests, and other earlier project files remain in the project.
* Changes are stored in memory only for the current application run, as required for this unit.

### MVC Classes

* **Model:** `Card` and `CardList`
* **View - list-view:** `CardListUI`
* **View - detail-view:** `CardDetailUI`
* **Controller:** `CardController`
* **Application entry point:** `CardTrackApp`

## Current Assignment Name: M05-A01: Implementing a Simple MVC Application GUI

* `CardTrackApp` starts `CardController`, which creates the model and view.
* Model: `Card` stores the eleven card attributes.
* List model: `CardList` creates an `ArrayList<Card>` with five sample cards and provides access to that list.
* View: `CardView` displays labeled text fields and Previous, Next, New, Update, Clear, Delete, and Exit buttons.
* Controller: `CardController` handles the button actions and transfers data between the list and the view. The view does not access model objects.
* The first card appears when the application opens. Previous and Next stop at the list boundaries. Update and Delete are disabled when the list is empty.
* New adds the values currently entered in the fields as another card. Use Clear first to empty the fields when entering a new card. Update saves changes to the current card, and Delete removes it.
* Empty fields, invalid numeric input, and negative quantities or prices are rejected before adding or updating a card.
* Changes remain in memory while the application is open. Restarting loads the five sample cards again.

## Current Assignment Name: M04-A01: Implementing Inheritance and Interfaces

## Assignment Accomplishments - (Description)

* Added a class hierarchy with `Card` as the super-class and `GradedCard` and `RawCard` as two sub-classes that both use the Java `extends` keyword.
* `GradedCard` adds the grading company, numerical grade, and certification number. `RawCard` adds top-loader status, sleeve type, and binder section.
* Added `displayCardDetails()` and `displayStorageInfo()` to `Card`. Both sub-classes override both methods with unique code and console messages that identify the class and method being executed.
* Added `test/TestInheritInterface.java` with a `main()` method and a `testClassHierarchy()` method. The method creates an `ArrayList<Card>`, adds two `GradedCard` objects and two `RawCard` objects, and iterates through the list to call the overridden methods and demonstrate polymorphism.
* Added the `Printable` Java interface with the abstract methods `printSetup()` and `print()`.
* The unrelated model classes `Sale` and `Inventory` both implement `Printable`, and each class provides different code for both interface methods.
* Added `testInterface()` to `TestInheritInterface`. It creates an `ArrayList<Printable>`, adds a `Sale` object and an `Inventory` object, and iterates through the list to call the implemented methods and demonstrate interface polymorphism.
* Preserved the M03 manual and JUnit tests in the `/test` directory.

## Current Assignment Name: M03_A01: Writing Model Unit Tests

## Assignment Accomplishments - (Description)

* Added `test/TestHarness.java` for manual unit testing of the `Card` and `Sale` model classes. It tests each class's constructor, getters, setters, and `toString()` method, and displays pass/fail results in the console.
* Added JUnit tests for two different model classes: `test/InventoryTest.java` and `test/ListingTest.java`. Each class tests realistic inventory or listing data through constructors, getters, setters, and `toString()` output.
* Added `pom.xml` so IntelliJ can load JUnit Jupiter and run the JUnit test classes using JDK 21.
* The `test` folder keeps all manual and automated test code separate from the application model code in `src`.

## Current Assignment Name: M02-A01: Identifying and Creating SW Model Classes

## Assignment Accomplishments - (Description)

* `docs/NounVerbAnalysis.pdf` identifies five nouns, their proposed attributes, and five verbs with sources from the CardTrack proposal.
* `src/Card.java` stores card identity, game, set, number, condition, quantity, purchase cost, asking price, location, and status. Purchase cost and asking price are per card.
* `src/Sale.java` stores a sale's identity, card ID, date, platform, quantity sold, total sale price, total purchase cost, fees, shipping cost, and profit. Profit is a stored snapshot in this first version; callers must keep it consistent with the other amounts.
* `src/Inventory.java` stores inventory identity, owner ID, name, storage location, and last-updated date. Collection management will be added in a later assignment.
* `src/Seller.java` stores seller identity, name, business name, preferred platform, and default storage location.
* `src/Listing.java` stores a listing's identity, card ID, platform, per-card asking price, quantity, and status.
* Every model has at least five private fields, a constructor initializing all fields, getters and setters for all fields, and an overridden `toString()` returning all field values.
* `src/CardTrackApp.java` creates one instance of each model through its parameterized constructor and explicitly prints each object's `toString()` output. All example data is fictional.
* IDs connect related records conceptually in this initial version. Dates are stored as strings in YYYY-MM-DD form. GUI, persistence, validation, card collections, and the proposed GradedCard subclass are future work.

## Running the Project

### Steps

1. In IntelliJ, choose File > Open (or Open on the welcome screen). Select the entire CardTrack folder and open it as a project.
2. If asked for a JDK, select JDK 17 or newer under File > Project Structure > Project.
3. Expand `src` in the Project panel and open `CardTrackApp.java`.
4. Click the green triangle next to `main` and select Run 'CardTrackApp.main()'.
5. A CardTrack window opens with the first sample card. Use the buttons to browse, add, edit, clear, or delete cards. Exit closes the application.

The main class is `CardTrackApp`. To run the manual tests, open `test/TestHarness.java` and run its `main()` method. To run the JUnit tests, open the Maven panel in IntelliJ, reload the project, and run the test goal. Maven downloads the required JUnit library automatically.
