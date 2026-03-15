## Encapsulation Review  
---
Reviewer: Badosa | Reviewee: Acosta (Cat1_Acosta.java)    
- The class has proper validation for the most part, with the only major problem I saw was that null in string issue.   
    
Reviewer: Badosa | Reviewee" Costiniano (ReservationCostiniano.java)  
- The class has proper validation and no major problem was found during testing 
--- 
Reviewer: Acosta | Reviewee: Badosa (Room_Badosa.java)  
- All instructions were fulfilled, the only issue found in the static method was a Getter.  
- All instructions were fulfilled.  

Reviewer: Acosta | Reviewee: Costiniano(ReservationCostiniano.java)
- All instructions were fulfilled.
---
Reviewer: Batangan | Reviewee: Isles (Isles_Reservations.java)
- The class demonstrates proper validation for reservation details such as the booker’s name, time booked, and payment amount.
- During testing, no major issues were found and the confirmation logic works as expected.

Reviewer: Batangan | Reviewee: Rodenas (LRCBookRodenas.java)
- The class correctly implements validation for its attributes and behaviors, including borrowing and returning books.
- The title setter safely handles empty or null inputs, so no major issues were found during testing.
---
Reviewer: Isles | Reviewee: Batangan (Playlist_Batangan.java)
- The code works as intended without crashing when encountering invalid inputs.
- Only issue is that the songs still count as songs despite the value being set to 0, and minutes may exist in a playlist while displaying 0 songs.
- Overall, the code aligns with the instructions.

Reviewer: Isles | Reviewee: Rodenas (LRCBookRodenas.java)
- The code works as intended without crashing when encountering invalid inputs.
- Only issue is that books still register as books even if the entries aren’t complete with valid details.
- Overall, the code aligns with the instructions.
---
Reviewer: Rodenas | Reviewee: Batangan (Playlist_Batangan.java)
- The class is well-encapsulated with proper validation for playlist name, genre, number of songs, and duration.
- The addSong and removeSong behaviors work correctly, and the static totalPlaylists attribute accurately tracks created playlists.
- One minor improvement could be adding feedback when an invalid value is entered for clarity.

Reviewer: Rodenas | Reviewee: Isles (Isles_Reservations.java)
- The class correctly enforces validation rules for booker name, booked time, and payment amount.
- The confirmBooking method works as intended and updates the static totalBookers attribute.
- It handles invalid inputs gracefully, though adding a message confirming a successful booking could improve user feedback.
---
Reviewer: Nepomuceno | Reviewee: Bagay (Prisoner_Bagay.java)    
- The class demonstrates excellent encapsulation with proper validation for all attributes. 
- The parole eligibility logic is well-implemented and updates correctly when sentence or behavior changes. 
- Static tracking of total prisoners and ID generation works as intended.   
- All behaviors (serveMonths, addBehaviorPoints, extendSentence) properly validate inputs and return boolean feedback.  
- One minor improvement: adding success/failure messages in the behavior methods would enhance user feedback clarity.   
- Overall, the code aligns perfectly with the instructions. 

Reviewer: Nepomuceno | Reviewee: Rodenas (LRCBook_Rodenas.java) 
- The class correctly implements validation for book attributes (ID, title, pages). 
- Borrow and return functionality works as intended without crashing on invalid inputs. 
- Proper handling of null and empty string inputs in the title setter.  
- Static tracking of totalBooks and totalBorrowedBooks is accurate and updates correctly.   
- One issue found: incomplete book entries (with 0 values) still register in the system and can be borrowed, which may not reflect real-world requirements. 
- The welcome message provides good user context.   
- Overall, the code meets the requirements but could benefit from stricter validation for incomplete books. 
---     
Reviewer: Bagay | Reviewee: Nepomuceno (GachaCharacterMaker_Nepomuceno.java)    
- The class demonstrates strong encapsulation with private attributes and controlled access through getters and setters.    
- Validation is implemented effectively for attributes such as name, level, health, stamina, and rarity.    
- The helper method updateAliveStatus properly maintains the relationship between health and the character’s alive status.  
- The behavior methods (attack, takeDamage, levelUp, and displayStatus) simulate game mechanics clearly and logically.  
- The static variable totalCharacters correctly tracks the number of characters created.    
- One improvement would be initializing the isAlive attribute in the constructors to ensure the character’s status is correct from the start.   
- Overall, the class demonstrates a clear understanding of object-oriented design and good use of validation and behavior methods.  

Reviewer: Bagay | Reviewee: Acosta (Cat1_Acosta.java)   
- The class demonstrates good encapsulation by keeping attributes private and providing getters and setters.    
- The implementation of the static variable totalCats successfully tracks the total number of created cat objects.  
- Both the default and parameterized constructors allow flexible object creation.   
- Basic validation is implemented in the setters to prevent empty names, breeds, and unrealistic ages.  
- The behavior methods (introduceCat and meow) clearly represent actions associated with the object.    
- One improvement would be adding the same validation used in setters to the parameterized constructor to prevent invalid values during object creation.    
- Overall, the class shows a solid understanding of object-oriented principles and basic validation.    
---
Reviewer: Costiniano | Reviewee: Badosa (Room)  
- The class has proper encapsulation with private attributes and validation for room number, price, and type.
- The checkIn() and checkOut() methods work correctly to change the room status.    
- One small improvement would be adding a null check in setRoomType().  

Reviewer: Costiniano | Reviewee: Acosta (Cat)   
- The class uses good encapsulation with private attributes and validation for name, breed, and age.
- The introduceCat() and meow() methods provide clear behavior for the object.
- One improvement would be checking for null values in setName() and setBreed().    

Reviewer: Galindon | Reviewee: Arandela(Movie Reservation)
- The class shows good validation for each attribute.
- It followed the instructions and access modifiers correctly.
- it can be improved by adding display methods.

Reviewer: Arandela | Reviewee: Galindon(Students)
- The class shows good private attributes, and good validation.
- Clearly followed the instructions.
- Shows good overall performance regarding the class.

Reviewer: Arandela | Reviewee: Rodenas(LRCBook)
- The class correctly implements validation for book attributes (ID, title, pages). 
- Static tracking of totalBooks and totalBorrowedBooks is accurate and updates correctly.
- Return and Borrow function correctly.

---
Reviewer: <Surname> | Reviewee: <Surname>(Class name)