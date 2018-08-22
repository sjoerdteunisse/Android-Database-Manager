Android Database Manager

Usage:


databaseManager = new DatabaseManager(this);

Person person = new Person();
person.firstName = "Peter";
person.lastName = "Drama";

databaseManager.addEntity(person);

int userID = databaseManager.getEntityById(person, person.PERSON_COL_FIRSTNAME, "Peter");

Copyright (c) 2018 [AXR (Sjoerd Teunisse)]

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in
        all copies or substantial portions of the Software.
