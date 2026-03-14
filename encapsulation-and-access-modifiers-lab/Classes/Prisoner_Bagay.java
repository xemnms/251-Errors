// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class Prisoner_Bagay {
   private String inmateName;
   private final int inmateId;
   private int sentenceMonths;
   private int behaviorScore;
   private boolean paroleEligible;
   private static int totalPrisonersCreated = 0;
   private static int nextInmateId = 1001;

   public Prisoner_Bagay() {
      this("Unknown", 12, 50);
   }

   public Prisoner_Bagay(String var1, int var2, int var3) {
      this.inmateId = nextInmateId++;
      this.setInmateName(var1);
      this.setSentenceMonths(var2);
      this.setBehaviorScore(var3);
      this.updateParoleEligibility();
      ++totalPrisonersCreated;
   }

   public String getInmateName() {
      return this.inmateName;
   }

   public int getInmateId() {
      return this.inmateId;
   }

   public int getSentenceMonths() {
      return this.sentenceMonths;
   }

   public int getBehaviorScore() {
      return this.behaviorScore;
   }

   public boolean isParoleEligible() {
      return this.paroleEligible;
   }

   public static int getTotalPrisonersCreated() {
      return totalPrisonersCreated;
   }

   public void setInmateName(String var1) {
      if (var1 != null && !var1.trim().isEmpty()) {
         this.inmateName = var1.trim();
      }

   }

   public boolean serveMonths(int var1) {
      if (var1 <= 0) {
         return false;
      } else if (var1 > this.sentenceMonths) {
         return false;
      } else {
         this.sentenceMonths -= var1;
         this.updateParoleEligibility();
         return true;
      }
   }

   public boolean addBehaviorPoints(int var1) {
      if (var1 <= 0) {
         return false;
      } else if (this.behaviorScore + var1 > 100) {
         return false;
      } else {
         this.behaviorScore += var1;
         this.updateParoleEligibility();
         return true;
      }
   }

   public boolean extendSentence(int var1) {
      if (var1 <= 0) {
         return false;
      } else if (this.sentenceMonths + var1 > 1200) {
         return false;
      } else {
         this.sentenceMonths += var1;
         this.updateParoleEligibility();
         return true;
      }
   }

   private void setSentenceMonths(int var1) {
      if (var1 > 0 && var1 <= 1200) {
         this.sentenceMonths = var1;
      } else {
         this.sentenceMonths = 12;
      }

   }

   private void setBehaviorScore(int var1) {
      if (var1 >= 0 && var1 <= 100) {
         this.behaviorScore = var1;
      } else {
         this.behaviorScore = 50;
      }

   }

   private void updateParoleEligibility() {
      this.paroleEligible = this.sentenceMonths <= 12 && this.behaviorScore >= 70;
   }
}
