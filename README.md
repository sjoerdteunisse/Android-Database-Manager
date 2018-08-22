Android Database Manager

Usage:


databaseManager = new DatabaseManager(this);

Person person = new Person();
person.firstName = "Peter";
person.lastName = "Drama";

databaseManager.addEntity(person);

int userID = databaseManager.getEntityById(person, person.PERSON_COL_FIRSTNAME, "Peter");
