Android Database Manager

Usage:
        Person person = new Person(this);
        person.firstName = "Jan";
        person.lastName = "Drama";
        person.addEntity(person);



.addEntity (CRUD) should be placed in a Manager instead. 

like:
DbManager.addEntity(person);
