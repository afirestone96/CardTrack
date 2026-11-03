# CardTrack

A Java Swing desktop application for managing a trading-card inventory. Developed as a Penn State IST 261 course project by Andrew Firestone.

## Features

- Browse six sample cards in a sortable inventory table.
- Add, view, edit, and delete cards through a separate detail window.
- Track card identity, condition, quantity, purchase cost, asking price, storage location, and status.
- Validate required fields, whole-number quantities, and finite, nonnegative prices.
- Keep the table synchronized with the in-memory inventory.

## Technology and design

Java 17+, Swing, Maven, and JUnit Jupiter. The current GUI uses the Model–View–Controller pattern with `Card`/`CardList`, `CardListUI`/`CardDetailUI`, and `CardController`. Additional model classes demonstrate inheritance, interfaces, and polymorphism.

## Run

Install JDK 17 or newer. From the project root:

```sh
mkdir -p out
javac -d out src/*.java
java -cp out CardTrackApp
```

Alternatively, open `pom.xml` in IntelliJ, select JDK 17 or newer, and run `CardTrackApp.main()`.

## Tests

With Maven installed:

```sh
mvn test
```

The project also includes a manual test harness:

```sh
javac -cp out -d out test/TestHarness.java
java -cp out TestHarness
```

## Current scope

Inventory changes last only for the current session; restarting restores sample data. This version does not implement file/database persistence or marketplace integrations. Sale, seller, listing, and inventory models are included, but the current GUI focuses on card inventory CRUD. Sample prices are fictional, not live market data.

## Project background

This is an academic project shared as a learning portfolio. Assignment history is preserved in [docs/README.md](docs/README.md); its older milestones describe earlier versions. The root README describes the current implementation.
