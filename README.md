Android Database Manager

Usage:


        //Create database manager
        databaseManager = new DatabaseManager(this);

        //Create entity
        Person person = new Person();
        person.firstName = "Peter";
        person.lastName = "Pan";

         //Adds the specified entity
        databaseManager.addEntity(person);

        //Gets the Id of the user
        int userID = databaseManager.getEntityById(person, person.PERSON_COL_FIRSTNAME, "Peter");
        
        //Deletes a user
        bool succes = databaseManager.deleteEntity(userID)
        
        
Copyright (c) 2018 [AXR (Sjoerd Teunisse)]

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in
        all copies or substantial portions of the Software.
