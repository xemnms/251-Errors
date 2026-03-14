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

Reviewer: Rodenas | Reviewee: Batangan (Playlist_Batangan.java)
- The class is well-encapsulated with proper validation for playlist name, genre, number of songs, and duration.
- The addSong and removeSong behaviors work correctly, and the static totalPlaylists attribute accurately tracks created playlists.
- One minor improvement could be adding feedback when an invalid value is entered for clarity.

Reviewer: Rodenas | Reviewee: Isles (Isles_Reservations.java)
- The class correctly enforces validation rules for booker name, booked time, and payment amount.
- The confirmBooking method works as intended and updates the static totalBookers attribute.
- It handles invalid inputs gracefully, though adding a message confirming a successful booking could improve user feedback.

Reviewer: <Surname> | Reviewee: <Surname>(Class name)
