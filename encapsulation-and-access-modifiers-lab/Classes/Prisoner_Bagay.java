public class prisoner_Bagay {
    // Core attributes
    private String inmateName;
    private final int inmateId;
    private int sentenceMonths;
    private int behaviorScore;
    private boolean paroleEligible;

    // Shared counters
    private static int totalPrisonersCreated = 0;
    private static int nextInmateId = 1001;

    // Default constructor
    public prisoner_Bagay() {
        this("Unknown", 12, 50);
    }

    // Custom constructor
    public prisoner_Bagay(String inmateName, int sentenceMonths, int behaviorScore) {
        this.inmateId = nextInmateId++;
        setInmateName(inmateName);
        setSentenceMonths(sentenceMonths);
        setBehaviorScore(behaviorScore);
        updateParoleEligibility();
        totalPrisonersCreated++;
    }

    // Basic getters
    public String getInmateName() {
        return inmateName;
    }

    public int getInmateId() {
        return inmateId;
    }

    public int getSentenceMonths() {
        return sentenceMonths;
    }

    public int getBehaviorScore() {
        return behaviorScore;
    }

    public boolean isParoleEligible() {
        return paroleEligible;
    }

    public static int getTotalPrisonersCreated() {
        return totalPrisonersCreated;
    }

    // Name setter
    public void setInmateName(String inmateName) {
        if (inmateName != null && !inmateName.trim().isEmpty()) {
            this.inmateName = inmateName.trim();
        }
    }

    // Serve sentence
    public boolean serveMonths(int monthsServed) {
        if (monthsServed <= 0) {
            return false;
        }

        if (monthsServed > sentenceMonths) {
            return false;
        }

        sentenceMonths -= monthsServed;
        updateParoleEligibility();
        return true;
    }

    // Add behavior points
    public boolean addBehaviorPoints(int points) {
        if (points <= 0) {
            return false;
        }

        if (behaviorScore + points > 100) {
            return false;
        }

        behaviorScore += points;
        updateParoleEligibility();
        return true;
    }

    // Extend sentence
    public boolean extendSentence(int extraMonths) {
        if (extraMonths <= 0) {
            return false;
        }

        if (sentenceMonths + extraMonths > 1200) {
            return false;
        }

        sentenceMonths += extraMonths;
        updateParoleEligibility();
        return true;
    }

    // Validate sentence range
    private void setSentenceMonths(int sentenceMonths) {
        if (sentenceMonths > 0 && sentenceMonths <= 1200) {
            this.sentenceMonths = sentenceMonths;
        } else {
            this.sentenceMonths = 12;
        }
    }

    // Validate score range
    private void setBehaviorScore(int behaviorScore) {
        if (behaviorScore >= 0 && behaviorScore <= 100) {
            this.behaviorScore = behaviorScore;
        } else {
            this.behaviorScore = 50;
        }
    }

    // Update parole status
    private void updateParoleEligibility() {
        paroleEligible = sentenceMonths <= 12 && behaviorScore >= 70;
    }
}